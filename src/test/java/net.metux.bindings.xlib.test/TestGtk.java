package net.metux.bindings.xlib.test;

import org.junit.jupiter.api.Test;

import net.metux.bindings.xlib.XDisplay;
import net.metux.bindings.xlib.XAtom;
import net.metux.bindings.xlib.XWindow;

import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class TestGtk {

    public class Ev1 extends SelectionAdapter
    {
        Control control;
        int counter = 0;

        public Ev1(Control c)
        {
            control = c;
        }

        public void widgetSelected(SelectionEvent e)
        {
            XWindow xwindow = SwtUtil.controlGetXWindow(control);
            System.err.println("Widget XID: "+xwindow.xid);

            XAtom atom = xwindow.display.getAtom("Test-X2");
            xwindow.changeProperty(atom, "COUNTER: "+counter);
            counter = counter + 1;

            SwtUtil.controlSetFence(control, "fence-1");

            xwindow.setStrut(10, 15, 20, 25);
        }
    }

    @Test
    public void testSwtGtk() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setLayout( new RowLayout());

        Button b1 = new Button(shell, SWT.PUSH);
        b1.setText("Press me");
        b1.addSelectionListener(new Ev1(shell));

        shell.pack();
        shell.open();

        XWindow xwindow = SwtUtil.controlGetXWindow(shell);
        xwindow.setClassHint("TestName", "TestCls");

        while( !shell.isDisposed()) {
            if(!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
};
