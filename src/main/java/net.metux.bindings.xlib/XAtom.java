
package net.metux.bindings.xlib;

public class XAtom
{
    public static final int XA_PRIMARY              = 1;
    public static final int XA_SECONDARY            = 2;
    public static final int XA_ARC                  = 3;
    public static final int XA_ATOM                 = 4;
    public static final int XA_BITMAP               = 5;
    public static final int XA_CARDINAL             = 6;
    public static final int XA_COLORMAP             = 7;
    public static final int XA_CURSOR               = 8;
    public static final int XA_CUT_BUFFER0          = 9;
    public static final int XA_CUT_BUFFER1          = 10;
    public static final int XA_CUT_BUFFER2          = 11;
    public static final int XA_CUT_BUFFER3          = 12;
    public static final int XA_CUT_BUFFER4          = 13;
    public static final int XA_CUT_BUFFER5          = 14;
    public static final int XA_CUT_BUFFER6          = 15;
    public static final int XA_CUT_BUFFER7          = 16;
    public static final int XA_DRAWABLE             = 17;
    public static final int XA_FONT                 = 18;
    public static final int XA_INTEGER              = 19;
    public static final int XA_PIXMAP               = 20;
    public static final int XA_POINT                = 21;
    public static final int XA_RECTANGLE            = 22;
    public static final int XA_RESOURCE_MANAGER     = 23;
    public static final int XA_RGB_COLOR_MAP        = 24;
    public static final int XA_RGB_BEST_MAP         = 25;
    public static final int XA_RGB_BLUE_MAP         = 26;
    public static final int XA_RGB_DEFAULT_MAP      = 27;
    public static final int XA_RGB_GRAY_MAP         = 28;
    public static final int XA_RGB_GREEN_MAP        = 29;
    public static final int XA_RGB_RED_MAP          = 30;
    public static final int XA_STRING               = 31;
    public static final int XA_VISUALID             = 32;
    public static final int XA_WINDOW               = 33;
    public static final int XA_WM_COMMAND           = 34;
    public static final int XA_WM_HINTS             = 35;
    public static final int XA_WM_CLIENT_MACHINE    = 36;
    public static final int XA_WM_ICON_NAME         = 37;
    public static final int XA_WM_ICON_SIZE         = 38;
    public static final int XA_WM_NAME              = 39;
    public static final int XA_WM_NORMAL_HINTS      = 40;
    public static final int XA_WM_SIZE_HINTS        = 41;
    public static final int XA_WM_ZOOM_HINTS        = 42;
    public static final int XA_MIN_SPACE            = 43;
    public static final int XA_NORM_SPACE           = 44;
    public static final int XA_MAX_SPACE            = 45;
    public static final int XA_END_SPACE            = 46;
    public static final int XA_SUPERSCRIPT_X        = 47;
    public static final int XA_SUPERSCRIPT_Y        = 48;
    public static final int XA_SUBSCRIPT_X          = 49;
    public static final int XA_SUBSCRIPT_Y          = 50;
    public static final int XA_UNDERLINE_POSITION   = 51;
    public static final int XA_UNDERLINE_THICKNESS  = 52;
    public static final int XA_STRIKEOUT_ASCENT     = 53;
    public static final int XA_STRIKEOUT_DESCENT    = 54;
    public static final int XA_ITALIC_ANGLE         = 55;
    public static final int XA_X_HEIGHT             = 56;
    public static final int XA_QUAD_WIDTH           = 57;
    public static final int XA_WEIGHT               = 58;
    public static final int XA_POINT_SIZE           = 59;
    public static final int XA_RESOLUTION           = 60;
    public static final int XA_COPYRIGHT            = 61;
    public static final int XA_NOTICE               = 62;
    public static final int XA_FONT_NAME            = 63;
    public static final int XA_FAMILY_NAME          = 64;
    public static final int XA_FULL_NAME            = 65;
    public static final int XA_CAP_HEIGHT           = 66;
    public static final int XA_WM_CLASS             = 67;
    public static final int XA_WM_TRANSIENT_FOR     = 68;

    public static final String ATOM_NET_WM_STRUT          = "_NET_WM_STRUT";
    public static final String ATOM_NET_WM_STRUT_PARTIAL  = "_NET_WM_STRUT_PARTIAL";

    public final int xid;
    public final String name;

    public XAtom(int new_id, String new_name)
    {
        xid = new_id;
        name = new_name;
    }
}
