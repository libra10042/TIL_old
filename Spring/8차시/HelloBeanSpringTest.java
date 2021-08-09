package myspring.di.xml.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanSpringTest {
	@Autowired
	ApplicationContext context;

	@Test
	public void bean1() {
		// 2. getBean() 호출
		Hello hello = (Hello) context.getBean("hello2");
		// 3. Hello 의 sayHello() 호출.
		assertEquals("Hello Spring", hello.sayHello());
		;
		// 3. Hello의 printer() 호출
		hello.print();

		// StringPrinter getBean()
		Printer printer = context.getBean("printer", Printer.class);
		assertEquals("Hello Spring", printer.toString());

		assertEquals(3, hello.getNames().size());

		List<String> list = hello.getNames();
		for (String value : list) {
			System.out.println(value);
		}
	}

}
