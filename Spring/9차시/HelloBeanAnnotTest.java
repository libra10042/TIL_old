package myspring.di.annot.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

import myspring.di.annot.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/annot.xml")
public class HelloBeanAnnotTest {
	@Autowired
	ApplicationContext context;
	
	@Test
	public void test() {
		Hello hello = context.getBean("hello",Hello.class);
		assertEquals("Hello Spring", hello.sayHello());
	
		hello.print();

		Printer printer = context.getBean("stringPrinter", Printer.class);
		assertEquals("Hello Spring", printer.toString());
	}
}
