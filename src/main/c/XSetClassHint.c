
#include <X11/Xlib.h>
#include <X11/Xutil.h>
#include <jni.h>

#include "net_metux_bindings_xlib_lowlevel_Xlib.h"
#include "jni_util.h"
#include "typeconv.h"

/*
 * Class:     net_metux_bindings_xlib_lowlevel_Xlib
 * Method:    XSetClassHint
 * Signature: (JILjava/lang/String;Ljava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_net_metux_bindings_xlib_lowlevel_Xlib_XSetClassHint
  (JNIEnv *env, jclass clazz, jlong x_display, jint window_id, jstring res_name, jstring res_class)
{
    int ret = -BadAccess;
    DECLARE_JCSTR(res_name);
    DECLARE_JCSTR(res_class);
    XClassHint hint = {
        .res_name = (char*)res_name_c.cval,
        .res_class = (char*)res_class_c.cval
    };

    ret = XSetClassHint(to_Display(x_display), to_Window(window_id), &hint);

out:
    RELEASE_JCSTR(res_name);
    RELEASE_JCSTR(res_class);
    return ret;
}
