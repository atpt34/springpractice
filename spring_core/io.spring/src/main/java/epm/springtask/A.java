package epm.springtask;

public class A {

	private B b;
	
	public A() {
	}
	
	A(B b) {
		this.b = b;
	}
	
	public String hello() {
		return "very important message!";
	}
}
