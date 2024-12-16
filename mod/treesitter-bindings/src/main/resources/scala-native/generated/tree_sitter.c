#include <string.h>
#include "tree_sitter/api.h"

void __sn_wrap_tree_sitter_ts_node_child(TSNode *_0, uint32_t _1, TSNode *____return) {
  TSNode ____ret = ts_node_child(*_0, _1);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_child_by_field_id(TSNode *_0, TSFieldId _1, TSNode *____return) {
  TSNode ____ret = ts_node_child_by_field_id(*_0, _1);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_child_by_field_name(TSNode *self, const char * field_name, uint32_t field_name_length, TSNode *____return) {
  TSNode ____ret = ts_node_child_by_field_name(*self, field_name, field_name_length);
  memcpy(____return, &____ret, sizeof(TSNode));
}


uint32_t __sn_wrap_tree_sitter_ts_node_child_count(TSNode *_0) {
 return ts_node_child_count(*_0);
};


void __sn_wrap_tree_sitter_ts_node_descendant_for_byte_range(TSNode *_0, uint32_t _1, uint32_t _2, TSNode *____return) {
  TSNode ____ret = ts_node_descendant_for_byte_range(*_0, _1, _2);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_descendant_for_point_range(TSNode *_0, TSPoint *_1, TSPoint *_2, TSNode *____return) {
  TSNode ____ret = ts_node_descendant_for_point_range(*_0, *_1, *_2);
  memcpy(____return, &____ret, sizeof(TSNode));
}


uint32_t __sn_wrap_tree_sitter_ts_node_end_byte(TSNode *_0) {
 return ts_node_end_byte(*_0);
};


void __sn_wrap_tree_sitter_ts_node_end_point(TSNode *_0, TSPoint *____return) {
  TSPoint ____ret = ts_node_end_point(*_0);
  memcpy(____return, &____ret, sizeof(TSPoint));
}


_Bool __sn_wrap_tree_sitter_ts_node_eq(TSNode *_0, TSNode *_1) {
 return ts_node_eq(*_0, *_1);
};


const char * __sn_wrap_tree_sitter_ts_node_field_name_for_child(TSNode *_0, uint32_t _1) {
 return ts_node_field_name_for_child(*_0, _1);
};


void __sn_wrap_tree_sitter_ts_node_first_child_for_byte(TSNode *_0, uint32_t _1, TSNode *____return) {
  TSNode ____ret = ts_node_first_child_for_byte(*_0, _1);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_first_named_child_for_byte(TSNode *_0, uint32_t _1, TSNode *____return) {
  TSNode ____ret = ts_node_first_named_child_for_byte(*_0, _1);
  memcpy(____return, &____ret, sizeof(TSNode));
}


_Bool __sn_wrap_tree_sitter_ts_node_has_changes(TSNode *_0) {
 return ts_node_has_changes(*_0);
};


_Bool __sn_wrap_tree_sitter_ts_node_has_error(TSNode *_0) {
 return ts_node_has_error(*_0);
};


_Bool __sn_wrap_tree_sitter_ts_node_is_extra(TSNode *_0) {
 return ts_node_is_extra(*_0);
};


_Bool __sn_wrap_tree_sitter_ts_node_is_missing(TSNode *_0) {
 return ts_node_is_missing(*_0);
};


_Bool __sn_wrap_tree_sitter_ts_node_is_named(TSNode *_0) {
 return ts_node_is_named(*_0);
};


_Bool __sn_wrap_tree_sitter_ts_node_is_null(TSNode *_0) {
 return ts_node_is_null(*_0);
};


void __sn_wrap_tree_sitter_ts_node_named_child(TSNode *_0, uint32_t _1, TSNode *____return) {
  TSNode ____ret = ts_node_named_child(*_0, _1);
  memcpy(____return, &____ret, sizeof(TSNode));
}


uint32_t __sn_wrap_tree_sitter_ts_node_named_child_count(TSNode *_0) {
 return ts_node_named_child_count(*_0);
};


void __sn_wrap_tree_sitter_ts_node_named_descendant_for_byte_range(TSNode *_0, uint32_t _1, uint32_t _2, TSNode *____return) {
  TSNode ____ret = ts_node_named_descendant_for_byte_range(*_0, _1, _2);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_named_descendant_for_point_range(TSNode *_0, TSPoint *_1, TSPoint *_2, TSNode *____return) {
  TSNode ____ret = ts_node_named_descendant_for_point_range(*_0, *_1, *_2);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_next_named_sibling(TSNode *_0, TSNode *____return) {
  TSNode ____ret = ts_node_next_named_sibling(*_0);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_next_sibling(TSNode *_0, TSNode *____return) {
  TSNode ____ret = ts_node_next_sibling(*_0);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_parent(TSNode *_0, TSNode *____return) {
  TSNode ____ret = ts_node_parent(*_0);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_prev_named_sibling(TSNode *_0, TSNode *____return) {
  TSNode ____ret = ts_node_prev_named_sibling(*_0);
  memcpy(____return, &____ret, sizeof(TSNode));
}


void __sn_wrap_tree_sitter_ts_node_prev_sibling(TSNode *_0, TSNode *____return) {
  TSNode ____ret = ts_node_prev_sibling(*_0);
  memcpy(____return, &____ret, sizeof(TSNode));
}


uint32_t __sn_wrap_tree_sitter_ts_node_start_byte(TSNode *_0) {
 return ts_node_start_byte(*_0);
};


void __sn_wrap_tree_sitter_ts_node_start_point(TSNode *_0, TSPoint *____return) {
  TSPoint ____ret = ts_node_start_point(*_0);
  memcpy(____return, &____ret, sizeof(TSPoint));
}


char * __sn_wrap_tree_sitter_ts_node_string(TSNode *_0) {
 return ts_node_string(*_0);
};


TSSymbol __sn_wrap_tree_sitter_ts_node_symbol(TSNode *_0) {
 return ts_node_symbol(*_0);
};


const char * __sn_wrap_tree_sitter_ts_node_type(TSNode *_0) {
 return ts_node_type(*_0);
};


void __sn_wrap_tree_sitter_ts_parser_logger(const TSParser * self, TSLogger *____return) {
  TSLogger ____ret = ts_parser_logger(self);
  memcpy(____return, &____ret, sizeof(TSLogger));
}


TSTree * __sn_wrap_tree_sitter_ts_parser_parse(TSParser * self, const TSTree * old_tree, TSInput *input) {
 return ts_parser_parse(self, old_tree, *input);
};


void __sn_wrap_tree_sitter_ts_parser_set_logger(TSParser * self, TSLogger *logger) {
 ts_parser_set_logger(self, *logger);
};


void __sn_wrap_tree_sitter_ts_query_cursor_exec(TSQueryCursor * _0, const TSQuery * _1, TSNode *_2) {
 ts_query_cursor_exec(_0, _1, *_2);
};


void __sn_wrap_tree_sitter_ts_query_cursor_set_point_range(TSQueryCursor * _0, TSPoint *_1, TSPoint *_2) {
 ts_query_cursor_set_point_range(_0, *_1, *_2);
};


void __sn_wrap_tree_sitter_ts_tree_cursor_copy(const TSTreeCursor * _0, TSTreeCursor *____return) {
  TSTreeCursor ____ret = ts_tree_cursor_copy(_0);
  memcpy(____return, &____ret, sizeof(TSTreeCursor));
}


void __sn_wrap_tree_sitter_ts_tree_cursor_current_node(const TSTreeCursor * _0, TSNode *____return) {
  TSNode ____ret = ts_tree_cursor_current_node(_0);
  memcpy(____return, &____ret, sizeof(TSNode));
}


int64_t __sn_wrap_tree_sitter_ts_tree_cursor_goto_first_child_for_point(TSTreeCursor * _0, TSPoint *_1) {
 return ts_tree_cursor_goto_first_child_for_point(_0, *_1);
};


void __sn_wrap_tree_sitter_ts_tree_cursor_new(TSNode *_0, TSTreeCursor *____return) {
  TSTreeCursor ____ret = ts_tree_cursor_new(*_0);
  memcpy(____return, &____ret, sizeof(TSTreeCursor));
}


void __sn_wrap_tree_sitter_ts_tree_cursor_reset(TSTreeCursor * _0, TSNode *_1) {
 ts_tree_cursor_reset(_0, *_1);
};


void __sn_wrap_tree_sitter_ts_tree_root_node(const TSTree * self, TSNode *____return) {
  TSNode ____ret = ts_tree_root_node(self);
  memcpy(____return, &____ret, sizeof(TSNode));
}