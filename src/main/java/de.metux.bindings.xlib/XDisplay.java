package de.metux.bindings.xlib;

import de.metux.bindings.xlib.lowlevel.CPointer;
import de.metux.bindings.xlib.lowlevel.Xlib;

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
