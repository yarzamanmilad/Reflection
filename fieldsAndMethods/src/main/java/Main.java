import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Test1 test1=new Test1();
        Class c1=test1.getClass();
        Field[] fields=c1.getDeclaredFields();
        Method[] methods=c1.getDeclaredMethods();
        Annotation[] annotations=c1.getAnnotations();

        for (Field field : fields) {
            field.setAccessible(true);
            Class temp=field.getType();
            Class stringClass=String.class;
            if(temp ==stringClass){
                field.set(test1,"milad");
            }else {
                field.set(test1,1111);
            }
        }
        for (Method method : methods) {
            method.setAccessible(true);
            int paramsCount=method.getParameterCount();
            if(paramsCount==1){
                method.invoke(test1,"args is ok");
            }else{
                method.invoke(test1);
            }
        }
        for (Annotation annotation : annotations) {
            System.out.println(annotation.annotationType());
            TestAnnotation testAnnotation= ((TestAnnotation) annotation);
            System.out.println(testAnnotation.numberOfField());


        }

    }
}
