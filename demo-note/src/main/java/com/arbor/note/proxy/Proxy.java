package com.arbor.note.proxy;

import com.squareup.javapoet.FieldSpec;
import com.squareup.javapoet.JavaFile;
import com.squareup.javapoet.MethodSpec;
import com.squareup.javapoet.TypeSpec;

import javax.lang.model.element.Modifier;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.TimeUnit;

/**
 * @author qiaomu.wang
 * @date 2018-12-18
 */
public class Proxy {

    public static Object newProxyInstance(Class inf, InvocationHandler handler) throws IOException {
        TypeSpec.Builder typeSpecBuilder = TypeSpec.classBuilder("TimeProxy")
                .addModifiers(Modifier.PUBLIC)
                .addSuperinterface(inf);

        FieldSpec fieldSpec = FieldSpec.builder(InvocationHandler.class, "handler", Modifier.PRIVATE).build();
        typeSpecBuilder.addField(fieldSpec);

        MethodSpec constructorMethodSpec = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(InvocationHandler.class, "handler")
                .addStatement("this.handler = handler")
                .build();
        typeSpecBuilder.addMethod(constructorMethodSpec);

        Method[] methods = inf.getDeclaredMethods();
        for (Method method : methods) {
            MethodSpec methodSpec = MethodSpec.methodBuilder(method.getName())
                    .addModifiers(Modifier.PUBLIC)
                    .addAnnotation(Override.class)
                    .returns(method.getReturnType())



                    .addCode("try {\n")
                    .addStatement("\t$T method = " + inf.getName() + ".class.getMethod(\"" + method.getName() + "\")", Method.class)
                    // 为了简单起见，这里参数直接写死为空
                    .addStatement("\tthis.handler.invoke(this, method, null)")
                    .addCode("} catch(Exception e) {\n")
                    .addCode("\te.printStackTrace();\n")
                    .addCode("}\n")
                    .build();

//
//                    .addStatement("long start = $T.currentTimeMillis()", System.class)
//                    .addCode("\n")
//                    .addStatement("this.flyable." + method.getName() + "()")
//                    .addCode("\n")
//                    .addStatement("long end = $T.currentTimeMillis()", System.class)
//                    .addStatement("$T.out.println(\"Fly Time =\" + (end - start))", System.class)
//                    .build();
            typeSpecBuilder.addMethod(methodSpec);
        }

        JavaFile javaFile = JavaFile.builder("com.arbor.note.proxy", typeSpecBuilder.build()).build();
        String pathname = "/Users/kingb/IdeaProjects/hello-world/demo-note/src/main/java/";
        javaFile.writeTo(new File(pathname));

        JavaCompiler.compile(new File(pathname + "/com/arbor/note/proxy/TimeProxy.java"));

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            URL[] urls = new URL[]{new URL("file:/" + pathname)};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class clazz = classLoader.loadClass("com.arbor.note.proxy.TimeProxy");
            Constructor constructor = clazz.getConstructor(InvocationHandler.class);
            Object obj = constructor.newInstance(handler);
//            Flyable flyable = (Flyable) constructor.newInstance(new Bird());
//            flyable.fly();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


    public static void main(String[] args) {
        try {
            MyInvocationHandler myInvocationHandler = new MyInvocationHandler(new Bird());
            TimeProxy timeProxy = new TimeProxy(myInvocationHandler);
            timeProxy.fly();
//            Flyable flyable = (Flyable) Proxy.newProxyInstance(Flyable.class, myInvocationHandler);
//            flyable.fly();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
