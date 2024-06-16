package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpringContainer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(ClassPathXmlApplicationContext ctx= new ClassPathXmlApplicationContext("bean-config.xml"))
				{
					System.out.println("SC running");
				}catch (Exception e) {
					e.printStackTrace();
					// TODO: handle exception
				}

	}

}
