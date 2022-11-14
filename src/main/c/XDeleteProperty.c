
#include <X11/Xlib.h>
#include <jni.h>

#include "de_metux_bindings_xlib_lowlevel_Xlib.h"
#include "typeconv.h"

/*
 * Class:     de_metux_bindings_xlib_lowlevel_Xlib
 * Method:    XDeleteProperty
 * Signature: (JII)I
 */
JNIEXPORT jint JNICALL Java_de_metux_bindings_xlib_lowlevel_Xlib_XDeleteProperty
  (JNIEnv *env , jclass clazz, jlong x_display, jint window_id, jint atom_id)
{
    return XDeleteProperty(to_Display(x_display), to_Window(window_id), atom_id);
}
