package com.example.lock;

/**
 * @author Pengllrn
 * @since <pre>2019/9/5 18:31</pre>
 */
public class TryUsingAnomous {
    public void usingInterface(){
        int number = 123;
        StringBuffer a = new StringBuffer();
        System.out.println(number);
        System.out.println(a.toString());

        MyInterface myInterface = new MyInterface() {
            @Override
            public void doSomething() {
                System.out.println(number);
                a.append('a');
            }
        };
        myInterface.doSomething();
        System.out.println(number);
        System.out.println(a.toString());
    }

    public static void main(String[] args) {
        new TryUsingAnomous().usingInterface();
    }
}

interface MyInterface{
    public void doSomething();
}
