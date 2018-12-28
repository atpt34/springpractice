package spring.impl;

public class B {

    private A a;
    
    public B(A a) {
        System.out.println("B()");
        this.setA(a);
    }

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }
}
