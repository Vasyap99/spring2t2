package kok.spring21;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    /*public static void main(String[] args) {
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //TestBean tb=context.getBean("testBean",TestBean.class);

        BeanPlayer p=context.getBean("beanPlayer",BeanPlayer.class);
        p.playBean();

        BeanPlayer p1=context.getBean("beanPlayer",BeanPlayer.class);
        p1.playBean();

        System.out.println(p.getB());//при Singleton TestBean  одиналовые значения
        System.out.println(p1.getB());
        //System.out.println(tb.getName());
        context.close();
    }*/
}
