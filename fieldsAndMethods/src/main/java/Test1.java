@TestAnnotation(numberOfField = 2)
public class Test1 {
    private String stringTemp;
    @TestAnnotation(numberOfField = 1111)
    private final int intTemp;

    public Test1() {
        intTemp = 0;
    }

    public void Print(){
        System.out.println("string tewp: "+ stringTemp+"  int temp: "+intTemp);
    }
    private void Print2(String val){
        System.out.println("print2 is call::       string tewp: "+ stringTemp+"  int temp: "+intTemp+"  value: "+val);
    }
}
