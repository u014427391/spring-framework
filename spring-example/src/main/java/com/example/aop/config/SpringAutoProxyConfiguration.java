package com.example.aop.config;

import com.example.aop.core.interceptor.TestMethodInterceptor;
import com.example.aop.service.UserService;
import com.example.aop.service.impl.UserServiceImpl;
import org.aopalliance.aop.Advice;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.NameMatchMethodPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <pre>
 *      SpringAutoProxyConfiguration
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/26 14:57  修改内容:
 * </pre>
 */
@Configuration
public class SpringAutoProxyConfiguration {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    public Advice methodInterceptor() {
        return new TestMethodInterceptor();
    }

    @Bean
    public NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor() {
        NameMatchMethodPointcutAdvisor nameMatchMethodPointcutAdvisor = new NameMatchMethodPointcutAdvisor();
        nameMatchMethodPointcutAdvisor.setMappedName("get*");
        nameMatchMethodPointcutAdvisor.setAdvice(methodInterceptor());
        return nameMatchMethodPointcutAdvisor;
    }

    @Bean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        return new DefaultAdvisorAutoProxyCreator();
    }

}
