package net.metux.bindings.xlib.test;

import net.metux.bindings.xlib.lowlevel.CPointer;
import net.metux.bindings.xlib.XDisplay;
import net.metux.bindings.xlib.XWindow;

import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.internal.gtk.GTK;
import org.eclipse.swt.internal.gtk.GDK;
import org.eclipse.swt.internal.gtk3.GTK3;

public class SwtUtil {

    public static final String ATOM_FENCE = "_XFWM_FENCE_NAME";

    public static CPointer controlGetTopHandle(Control control)
    {
        try {
            return CPointer.fromObject(Util.classMethod(Control.class, "topHandle").invoke(control));
        } catch (NoSuchMethodException e) {
            System.err.println("no such method: "+e);
        } catch (IllegalAccessException e) {
            System.err.println("illegal access: "+e);
        } catch (java.lang.reflect.InvocationTargetException e) {
            System.err.println("invocation target exception: "+e);
        }

        throw new RuntimeException("topHandle: could not retrieve topHandle");
    }

    public static CPointer controlGetGdkWindow(Control control)
    {
        CPointer gtk_widget = controlGetTopHandle(control);
        GTK.gtk_widget_realize(gtk_widget.addr);
        return CPointer.fromInt(GTK3.gtk_widget_get_window(gtk_widget.addr));
    }

    public static XWindow controlGetXWindow(Control control)
    {
        CPointer gdk_window = controlGetGdkWindow(control);

        return new XWindow(
            controlGetXDisplay(control),
            (int)GDK.gdk_x11_window_get_xid(gdk_window.addr));
    }

    public static XDisplay controlGetXDisplay(Control control)
    {
        CPointer gdk_window = controlGetGdkWindow(control);

        return new XDisplay(CPointer.fromInt(
                GDK.gdk_x11_display_get_xdisplay(
                    GDK.gdk_window_get_display(gdk_window.addr))));
    }

    public static void controlSetFence(Control control, String fence)
    {
        XWindow win = controlGetXWindow(control);
        win.changeProperty(win.display.getAtom(ATOM_FENCE), fence);
    }
};
