package com.zagros;

public final class Test1 {
    private  final   String s;
    public Test1(){
        s="zagros";
    }
    public Test1(int a,int b,float c){
        s="int a";
    }
    public void method1(){
        System.out.println("value for s feild is: "+ s);
    }

    public void method2(int n){
        System.out.println("value for inpout is: "+ n);

    }

    private void method3(){
        System.out.println("private method is call. ");
    }

}
