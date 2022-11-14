
#include <X11/Xlib.h>
#include <X11/Xatom.h>
#include <jni.h>
#include <string.h>
#include <alloca.h>

#include "de_metux_bindings_xlib_lowlevel_Xlib.h"
#include "jni_util.h"
#include "typeconv.h"

/*
 * Class:     de_metux_bindings_xlib_lowlevel_Xlib
 * Method:    XChangeProperty_str
 * Signature: (JIILjava/lang/String;)I
 */
JNIEXPORT jint JNICALL Java_de_metux_bindings_xlib_lowlevel_Xlib_XChangeProperty_1str
  (JNIEnv *env, jclass clazz, jlong x_display, jint window_id, jint atom_id, jstring value)
{
    jint ret = -BadAccess;
    DECLARE_JCSTR(value);

    if (value_c.cval == NULL)
        goto out;

    ret = XChangeProperty(to_Display(x_display), to_Window(window_id), atom_id,
                          XA_STRING, 8, PropModeReplace, value_c.cval, value_c.len);

out:
    RELEASE_JCSTR(value);
    return ret;
}

/*
 * Class:     de_metux_bindings_xlib_lowlevel_Xlib
 * Method:    XChangeProperty_cardlist
 * Signature: (JII[I)I
 */
JNIEXPORT jint JNICALL Java_de_metux_bindings_xlib_lowlevel_Xlib_XChangeProperty_1cards
  (JNIEnv *env, jclass clazz, jlong x_display, jint window_id, jint atom_id,
   jintArray cards)
{
    jint ret = -BadAccess;
    DECLARE_JCINTARRAY(cards);
    long *buffer = (long*)alloca(sizeof(long)*(cards_c.len+1));

    /* need to convert between int sizes: xlib expects arch dependent C long and converts
       automatically */
    for (int x=0; x<cards_c.len; x++)
        buffer[x] = cards_c.cval[x];

    ret = XChangeProperty(to_Display(x_display), to_Window(window_id), atom_id,
                          XA_CARDINAL, 32, PropModeReplace, (unsigned char*)buffer, cards_c.len);
out:
    RELEASE_JCINTARRAY(cards);
    return ret;
}
