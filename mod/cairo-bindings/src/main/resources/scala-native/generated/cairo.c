#include <string.h>
#include "cairo.h"
#include "cairo-ft.h"

FcBool __sn_wrap_cairo_FcPatternAdd(FcPattern * p, const char * object, FcValue *value, FcBool append) {
 return FcPatternAdd(p, object, *value, append);
};


FcBool __sn_wrap_cairo_FcPatternAddWeak(FcPattern * p, const char * object, FcValue *value, FcBool append) {
 return FcPatternAddWeak(p, object, *value, append);
};


void __sn_wrap_cairo_FcValueDestroy(FcValue *v) {
 FcValueDestroy(*v);
};


FcBool __sn_wrap_cairo_FcValueEqual(FcValue *va, FcValue *vb) {
 return FcValueEqual(*va, *vb);
};


void __sn_wrap_cairo_FcValuePrint(const FcValue *v) {
 FcValuePrint(*v);
};


void __sn_wrap_cairo_FcValueSave(FcValue *v, FcValue *____return) {
  FcValue ____ret = FcValueSave(*v);
  memcpy(____return, &____ret, sizeof(FcValue));
}