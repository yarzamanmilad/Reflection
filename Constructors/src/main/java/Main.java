import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Test1 t1=new Test1("jj",7);
        Class c1=t1.getClass();
        Constructor constructors=c1.getDeclaredConstructor(new Class[] {String.class,int.class});
        System.out.println(constructors.getName());
        Constructor[] constructors1=c1.getDeclaredConstructors();
        System.out.println(constructors1.length);
        for (int i = 0; i < constructors1.length; i++) {
            printParametersType(constructors1[i]);
            callPrintMethode(constructors1[i]);
        }

    }

    private static void callPrintMethode(Constructor constructor) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        Test1 test1;
        Class[] params=constructor.getParameterTypes();
        if (params.length==1){
            test1= ((Test1) constructor.newInstance("milad"));
            test1.print();
        }else{

            test1= ((Test1) constructor.newInstance("milad", 1370));
            test1.printInt_String();
        }
    }

    private static void printParametersType(Constructor constructor) {

        Class c=constructor.getDeclaringClass();
        Class[] ptypes=constructor.getParameterTypes();
        for (Class ptype : ptypes) {
            System.out.println(c.getSimpleName()+"   constructorType: "+ptype.getSimpleName());

        }
    }

}
