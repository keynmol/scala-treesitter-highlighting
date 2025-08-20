FROM eclipse-temurin:24 as build
RUN apt update && apt install -y curl zip tar unzip git cmake ninja-build clang xz-utils build-essential pkg-config autoconf automake autoconf-archive
RUN curl -Lo /usr/local/bin/sbt https://raw.githubusercontent.com/sbt/sbt/refs/heads/1.11.x/sbt && chmod +x /usr/local/bin/sbt
WORKDIR /source
RUN if [ "$(uname -m)" = "x86_64" ]; then \
    curl -Lo node-install.tar.xz https://nodejs.org/dist/v22.18.0/node-v22.18.0-linux-x64.tar.xz; \
    else \
    curl -Lo node-install.tar.xz https://nodejs.org/dist/v22.18.0/node-v22.18.0-linux-arm64.tar.xz; \
    fi && \
    tar -xf node-install.tar.xz && rm *.tar.xz && mv node-v22* node-install
ENV PATH /source/node-install/bin:$PATH
RUN git clone https://github.com/emscripten-core/emsdk.git && \
    cd emsdk && ./emsdk install latest && ./emsdk activate latest
ENV PATH /source/node-install/bin:/source/emsdk/upstream/emscripten:$PATH
COPY build.sbt .
COPY project/ project
RUN sbt clean update vcpkgInstall
COPY . .
RUN sbt httpServer/stage buildScalaWASM webapp/fullLinkJS buildReleaseBinary
RUN cp -r  mod/http-server/target/universal/stage /source/backend-package
RUN cd webapp && npm install && npm run build
RUN cp -r webapp/dist /source/frontend-package

# FROM vcpkg-deps-build as cli-build
# WORKDIR /source
# COPY mod/themes/ mod/themes
# COPY mod/cairo-bindings/ mod/cairo-bindings
# COPY mod/treesitter-bindings/ mod/treesitter-bindings
# COPY mod/tree-sitter-interface/ mod/tree-sitter-interface
# COPY mod/cmark-bindings/ mod/cmark-bindings
# COPY mod/lib/ mod/lib
# COPY mod/bin/ mod/bin
# COPY tree-sitter/ tree-sitter
# COPY tree-sitter-scala/ tree-sitter-scala
# COPY webapp/FiraCode-Regular.ttf webapp/
# RUN sbt buildReleaseBinary

FROM eclipse-temurin:24
RUN apt update && apt install -y --no-install-recommends --no-install-suggests -y ca-certificates libssl3t64 nginx
COPY ./nginx/nginx.conf /etc/nginx/nginx.conf
COPY ./nginx/entrypoint.sh /app/entrypoint.sh
COPY --from=build /source/backend-package /app/backend
COPY --from=build /source/frontend-package /app/frontend
COPY --from=build /source/out/release/scala-highlight /app/scala-highlight
ENV HIGHLIGHTER_CLI_PATH /app/scala-highlight
EXPOSE 80
CMD ["/app/entrypoint.sh"]
