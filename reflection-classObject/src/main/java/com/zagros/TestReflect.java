package com.zagros;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.HashMap;
import java.util.Map;

public class TestReflect {
    public static void main(String[] args) throws NoSuchMethodException {
       Object t1=new Test1();
       Test2 t2=new Test2();
       Class c1=t1.getClass();
        Class c2=t2.getClass();
        System.out.println("///"+c2.getAnnotations().length);
        System.out.println(c1.getModifiers());/////18 for  public and 17 for private and ...
        printModifires(c1.getModifiers());
        /////////////print field name
        Field[] fields=c1.getDeclaredFields();/////////private and protected and public
        for (int i = 0; i < fields.length; i++) {
            System.out.println("fieldName: "+fields[i].getName());
            System.out.println("fieldType: "+fields[i].getType());
            try {
                fields[i].setAccessible(true);
               String temp=(String) fields[i].get(t1);
                fields[i].set(t1,"milad");
                System.out.println(temp);
                 temp=(String) fields[i].get(t1);
                printModifires(fields[i].getModifiers());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /////print method name
        Method[] methods=c1.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName() );
        }
        ///////////print constractor parameters  count
        Constructor[] constructors=c1.getConstructors();
        for (int i = 0; i < constructors.length; i++) {
            System.out.println("constructor parametr count: "+constructors[i].getParameterCount()+"    getparameters:  "+constructors[i].getParameters());

        }
        /////////////print annotationname
        Annotation[] annotations=c2.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i].annotationType());
        }
        ///////////print interface name
        Class[] interfaces=c2.getInterfaces();
        for (int i = 0; i < interfaces.length; i++) {
            System.out.println(interfaces[i].getSimpleName());
            System.out.println(interfaces[i].getName());//////fully qualified
        }
    }

    private static void printModifires(int modifiers) {
        Map<String,Boolean> stringMap=new HashMap<>();
              stringMap.put("is abstract:  ",Modifier.isAbstract(modifiers));
        stringMap.put("is static:  ",Modifier.isStatic(modifiers));
        stringMap.put("is final:  ",Modifier.isFinal(modifiers));
        stringMap.put("is synchronized:  ",Modifier.isSynchronized(modifiers));
        stringMap.put("is isVolatile:  ",Modifier.isVolatile(modifiers));
        stringMap.put("is private:  ",Modifier.isPrivate(modifiers));
        stringMap.put("is Protected:  ",Modifier.isProtected(modifiers));
        stringMap.put("is public:  ",Modifier.isPublic(modifiers));

              stringMap.forEach((s, aBoolean)-> System.out.println(s+aBoolean));
    }
}
