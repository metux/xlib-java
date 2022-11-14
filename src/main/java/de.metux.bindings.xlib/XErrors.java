
package de.metux.bindings.xlib;

/*
 * error code returned by Xlib functions
 */
public class XErrors
{
    /* everything's okay */
    public static final int Success             = 0;

    /* bad request code */
    public static final int BadRequest          = 1;

    /* int parameter out of range */
    public static final int BadValue            = 2;

    /* parameter not a Window */
    public static final int BadWindow           = 3;

    /* parameter not a Pixmap */
    public static final int BadPixmap           = 4;

    /* parameter not an Atom */
    public static final int BadAtom             = 5;

    /* parameter not a Cursor */
    public static final int BadCursor           = 6;

    /* parameter not a Font */
    public static final int BadFont             = 7;

    /* parameter mismatch */
    public static final int BadMatch            = 8;

    /* parameter not a Pixmap or Window */
    public static final int BadDrawable         = 9;

    /* depending on context:
      - key/button already grabbed
      - attempt to free an illegal cmap entry
      - attempt to store into a read-only color map entry.
      - attempt to modify the access control list from other than the local host.
    */
    public static final int BadAccess           = 10;

    /* insufficient resources */
    public static final int BadAlloc            = 11;

    /* no such colormap */
    public static final int BadColor            = 12;

    /* parameter not a GC */
    public static final int BadGC               = 13;

    /* choice not in range or already used */
    public static final int BadIDChoice         = 14;

    /* font or color name doesn't exist */
    public static final int BadName             = 15;

    /* Request length incorrect */
    public static final int BadLength           = 16;

    /* server is defective */
    public static final int BadImplementation   = 17;

    public static final int FirstExtensionError = 128;
    public static final int LastExtensionError  = 255;
}
