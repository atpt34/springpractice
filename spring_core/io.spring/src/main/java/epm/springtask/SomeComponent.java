package epm.springtask;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component("huawei")
public class SomeComponent implements InitializingBean, DisposableBean {
	   
	private Map<String, List<String>> names;
	private String str;
	
	public SomeComponent(Map<String, List<String>> names) {
		this.setNames(names);
	}
	
    public void init() {
        System.out.print("e");
    }
 
    public void close() {
        System.out.print("f");
    }
 
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.print("g");
    }
 
    @Override
    public void destroy() throws Exception {
        System.out.print("h");
    }
 
    public void print() {
        System.out.print("i");
    }

	public Map<String, List<String>> getNames() {
		return names;
	}

	public void setNames(Map<String, List<String>> names) {
		this.names = names;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}
	
	
	public void update(String name) {
		System.out.println("update...throw");
	}
	
	public void update(String name, String name2) {
		System.out.println("update..2...throw");
	}
	
	public void update(String name, String name2, String str) {
		System.out.println("update..3...throw");
	}
}
