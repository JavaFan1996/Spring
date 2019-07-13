package aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextAop.xml");

        jisuanqi jisuanji = (jisuanqi) context.getBean("jisuanji");
        int result = jisuanji.add(5, 6);
        System.out.println(result);

        result = jisuanji.dvi(5, 5);
        System.out.println(result);

    }


}
