package com.example;


import com.example.bean.SpringBean;
import com.example.config.AppConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import com.example.bean.A;

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

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(AppConfiguration.class);
        context.refresh();
        SpringBean bean = context.getBean(SpringBean.class);
        System.out.println(bean);
    }
}
