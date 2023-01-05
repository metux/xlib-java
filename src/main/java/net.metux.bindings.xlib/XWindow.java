
package net.metux.bindings.xlib;

import net.metux.bindings.xlib.lowlevel.Xlib;
import net.metux.bindings.xlib.XAtom;

public class XWindow
{
    public final int xid;
    public final XDisplay display;

    private XAtom _atom(String atom_name)
    {
        return display.getAtom(atom_name);
    }

    private long _display()
    {
        return display.ptr.addr;
    }

    public XWindow(XDisplay dpy, int new_id)
    {
        xid = new_id;
        display = dpy;
    }

    public int deleteProperty(XAtom atom)
    {
        return Xlib.XDeleteProperty(_display(), xid, atom.xid);
    }

    public int changeProperty(XAtom atom, String value)
    {
        return Xlib.XChangeProperty_str(_display(), xid, atom.xid, value);
    }

    public int changeProperty(XAtom atom, int value[])
    {
        return Xlib.XChangeProperty_cards(_display(), xid, atom.xid, value);
    }

    public int setClassHint(String res_name, String res_class)
    {
        return Xlib.XSetClassHint(_display(), xid, res_name, res_class);
    }

    public int setStrut(int left, int right, int top, int bottom)
    {
        int l[] = { left, right, top, bottom };
        return changeProperty(_atom(XAtom.ATOM_NET_WM_STRUT), l);
    }

    public int setStrutPartial(int left, int right, int top, int bottom,
                               int left_start_y, int left_end_y,
                               int right_start_y, int right_end_y,
                               int top_start_x, int top_end_x,
                               int bottom_start_x, int bottom_end_x)
    {
        int l[] = { left, right, top, bottom, left_start_y, left_end_y,
                    right_start_y, right_end_y, top_start_x, top_end_x,
                    bottom_start_x, bottom_end_x };
        return changeProperty(_atom(XAtom.ATOM_NET_WM_STRUT_PARTIAL), l);
    }

    public int deleteStrut()
    {
        return deleteProperty(_atom(XAtom.ATOM_NET_WM_STRUT));
    }

    public int deleteStrutPartial()
    {
        return deleteProperty(_atom(XAtom.ATOM_NET_WM_STRUT_PARTIAL));
    }
}
