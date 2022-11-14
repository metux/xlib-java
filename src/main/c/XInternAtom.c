
#include <X11/Xlib.h>
#include <jni.h>

#include "de_metux_bindings_xlib_lowlevel_Xlib.h"
#include "jni_util.h"
#include "typeconv.h"

/*
 * Class:     de_metux_bindings_xlib_lowlevel_Xlib
 * Method:    XInternAtom
 * Signature: (JLjava/lang/String;Z)I
 */
JNIEXPORT jint JNICALL Java_de_metux_bindings_xlib_lowlevel_Xlib_XInternAtom
  (JNIEnv *env, jclass clazz, jlong x_display, jstring atom_name,
   jboolean only_if_exists)
{
    jint ret = -BadAccess;
    DECLARE_JCSTR(atom_name);

    if ((x_display == 0) || (atom_name_c.cval == NULL))
        goto out;

    ret = XInternAtom(to_Display(x_display), atom_name_c.cval, only_if_exists);

out:
    RELEASE_JCSTR(atom_name);
    return ret;
}
