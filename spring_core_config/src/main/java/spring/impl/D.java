package spring.impl;

public class D {

    private B b;
    
    public D(B b) {
        System.out.println("D()");
        this.setB(b);
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }
}
