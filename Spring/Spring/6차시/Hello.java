package myspring.di.xml;

import java.util.List;

public class Hello {
	private String name;
	private Printer printer;
	
	public Hello() { }
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello() {
		return "Hello " + name;
	}

	public void print() {
		printer.print(sayHello());
	}
}
