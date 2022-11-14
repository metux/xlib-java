
#include <X11/Xlib.h>
#include <X11/Xatom.h>

static inline Display *to_Display(jlong x)
{
    return (Display*)(long)x;
}

static inline Window to_Window(jint x)
{
    return (Window)x;
}
