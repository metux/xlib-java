package net.metux.bindings.xlib.lowlevel;

public class Xlib
{
    static {
        System.loadLibrary("jni_xlib");
    };

    public native static int XInternAtom(long x_display, String atom_name, boolean only_if_exists);
    public native static int XChangeProperty_str(long x_display, int window_id, int atom_id, String value);
    public native static int XChangeProperty_cards(long x_display, int window_id, int atom_id, int values[]);
    public native static int XDeleteProperty(long x_display, int window_id, int atom_id);
    public native static int XSetClassHint(long x_display, int window_id, String res_name, String res_class);
}
