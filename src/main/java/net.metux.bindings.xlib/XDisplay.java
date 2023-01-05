package net.metux.bindings.xlib;

import net.metux.bindings.xlib.lowlevel.CPointer;
import net.metux.bindings.xlib.lowlevel.Xlib;

public class XDisplay
{
    public final CPointer ptr;

    public XDisplay(CPointer cptr)
    {
        ptr = cptr;
    }

    public XAtom getAtom(String str)
    {
        return new XAtom(Xlib.XInternAtom(ptr.addr, str, false), str);
    }
}
