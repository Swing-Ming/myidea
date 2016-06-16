package com.company;


public class Test {


    public static void main(String[] args) {


        Test t = new Test();
        NewTest nt = new NewTest();
       int  s = nt.d;


        System.out.println(t.test("1"));


    }

    static int m= 1;
     String s = "name";

    public int test(String str) {

        String s = "blue";
        System.out.println("s1是" + s);
        int a = 0;
        String b = "red";
        int c = 1;
        System.out.println("a第一次是：" + a);
        a = c;
        System.out.println("a第二次是：" + a);
        s = b;

        for (int i = 0; i < 5; i++) {
            System.out.println(i + s);
        }

        return a;
    }


}
