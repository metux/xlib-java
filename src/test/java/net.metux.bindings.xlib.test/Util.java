package net.metux.bindings.xlib.test;

import java.lang.reflect.Method;

public class Util {

    public static Method classMethod(Class clazz, String name)
        throws NoSuchMethodException
    {
        final Method method = clazz.getDeclaredMethod(name);
        method.setAccessible(true);
        return method;
    }
};
