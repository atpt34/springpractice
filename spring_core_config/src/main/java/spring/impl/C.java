package spring.impl;

public class C {

    private B b;
    private D d;
    
    public C(B b, D d) {
        System.out.println("C()");
        this.setB(b);
        this.setD(d);
    }

    public C(B b) {
        System.out.println("C() w/o d");
        this.b = b;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public D getD() {
        return d;
    }

    public void setD(D d) {
        this.d = d;
    }
}
