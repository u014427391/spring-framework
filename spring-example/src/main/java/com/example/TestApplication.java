package com.example;


import com.example.aop.config.SpringAspectJConfiguration;
import com.example.aop.service.UserService;
import com.example.bean.SpringBean;
import com.example.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.bean.A;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * <pre>
 *      TestController
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/05 10:22  修改内容:
 * </pre>
 */
public class TestApplication {

    public static void testAnnotationConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfiguration.class);
        context.refresh();
        SpringBean bean = context.getBean(SpringBean.class);
        System.out.println(bean);
    }

    public static void testClassPathXmlApplicationContext() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        SpringBean  springBean = context.getBean(SpringBean.class);
        System.out.println(springBean);
    }

    public static void testCircularReferences() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfiguration.class);
        //context.setAllowCircularReferences(false);
        context.refresh();
        A bean = context.getBean(A.class);
        System.out.println(bean);
    }

    public static void testSpringAopProxy() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringAspectJConfiguration.class);
        context.refresh();
        UserService userService = (UserService) context.getBean("userService");
        System.out.println(userService.findUserNameById(1L));
    }

    public static void main(String[] args) {
        // 测试AnnotationConfigApplicationContext
        //testAnnotationConfigApplicationContext();
        // 测试ClassPathXmlApplicationContext
        //testClassPathXmlApplicationContext();
        // 测试Sprin循环依赖
        //testCircularReferences();
        // 测试AOP代理对象
        testSpringAopProxy();
    }
}
