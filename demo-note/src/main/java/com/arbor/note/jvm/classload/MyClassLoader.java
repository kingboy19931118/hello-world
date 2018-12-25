package com.arbor.note.jvm.classload;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    e.printStackTrace();
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = classLoader.loadClass("com.arbor.note.jvm.classload.MyClassLoader");
        System.out.println(obj.getClass());
        System.out.println(obj);
        System.out.println(obj instanceof com.arbor.note.jvm.classload.MyClassLoader);

    }
}
