package com.example.test;

/**
 * @author Pengllrn
 * @since <pre>2019/7/8 19:56</pre>
 */
public class TestFanx<T> {
    private T v;

    public TestFanx(){

    }

    public TestFanx(T v){
        this.v = v;
    }

    public T getV(){
        return (T) new Integer(8);
    }
    public static void main(String[] args) {
        Object v = new TestFanx().getV();
        System.out.println(v);
    }

}
