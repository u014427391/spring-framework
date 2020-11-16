package com.example.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * <pre>
 *      A class
 * </pre>
 *
 * <pre>
 * @author mazq
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2020/11/05 10:31  修改内容:
 * </pre>
 */
@Component
public class A {

    @Autowired
    B b;

    public A() {
        //b = new B();
        System.out.println("A class is create");
    }
}
