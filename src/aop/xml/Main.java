package aop.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAop-xml.xml");

        jisuanqi jisuanqi = (aop.xml.jisuanqi) context.getBean("jisuanqi");
        int result = jisuanqi.add(5, 6);
        System.out.println(result);

        result = jisuanqi.dvi(5, 5);
        System.out.println(result);

    }


}
