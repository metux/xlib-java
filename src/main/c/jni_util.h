#ifndef __JNI_UTIL_H__
#define __JNI_UTIL_H__

#include <string.h>
#include <jni.h>
#include <string.h>

typedef struct
{
    JNIEnv *env;
    jint *cval;
    jstring jval;
    char need_free;
    jsize len;
} JCINTARRAY;

static inline JCINTARRAY jcintarray_convert(JNIEnv *env, jstring jval)
{
    JCINTARRAY buf = {
        .env = env,
        .jval = jval
    };

    if (jval == NULL)
        return buf;

    buf.len = (*env)->GetArrayLength(env, jval);
    buf.cval = (*env)->GetIntArrayElements(env, jval, 0);

    return buf;
}

static inline void jcintarray_release(JCINTARRAY buf)
{
    if (buf.need_free)
    {
        (*(buf.env))->ReleaseIntArrayElements(buf.env, buf.jval, buf.cval, 0);
    }
}

#define DECLARE_JCINTARRAY(name) \
    JCINTARRAY name##_c = jcintarray_convert(env, name)

#define RELEASE_JCINTARRAY(name) \
    jcintarray_release(name##_c)

typedef struct
{
    JNIEnv *env;
    unsigned const char *cval;
    jstring jval;
    jsize len;
    char need_free;
} JCSTR;

static JCSTR jcstr_convert(JNIEnv *env, jstring jval)
{
    JCSTR buf = {
        .env = env,
        .jval = jval
    };

    if (jval == NULL)
        return buf;

    buf.cval = (*env)->GetStringUTFChars(env, jval, 0);
    buf.need_free = 1;
    buf.len = strlen(buf.cval);

    return buf;
}

static void jcstr_release(JCSTR buf)
{
    if (buf.need_free)
    {
        (*(buf.env))->ReleaseStringUTFChars(buf.env, buf.jval, buf.cval);
    }
}

#define DECLARE_JCSTR(name) \
    JCSTR name##_c = jcstr_convert(env, name)

#define RELEASE_JCSTR(name) \
    jcstr_release(name##_c)

#endif /* __JNI_UTIL_H__ */
