public class Test1 {
    String temp;
    int tempint;
   public Test1(String aString){
       this.temp=aString;
   }
     Test1(String b,int aInt){
       this.temp=b;
       this.tempint=aInt;
     }
     public void print(){
         System.out.println(temp);
     }
     public void printInt_String(){
         System.out.println(temp+"    int: "+tempint);
     }
}
