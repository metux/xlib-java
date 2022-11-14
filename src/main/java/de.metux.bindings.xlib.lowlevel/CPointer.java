package de.metux.bindings.xlib.lowlevel;

public class CPointer
{
    public long addr;

    public static CPointer fromInt(long addr)
    {
        if (addr == 0)
            return null;

        CPointer my = new CPointer();
        my.addr = addr;
        return my;
    }

    public static CPointer fromObject(Object obj)
    {
        if (obj == null)
            return null;

        if (!(obj instanceof Number))
            return null;

        return fromInt(((Number) obj).longValue());
    }

    public String toString()
    {
        return String.valueOf(addr);
    }
}
