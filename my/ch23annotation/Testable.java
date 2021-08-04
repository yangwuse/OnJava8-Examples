package my.ch23annotation;

import bookcode.onjava.atunit.Test;

// 通过注解创建工具

public class Testable {
    public void bar() {
        System.out.println("bar...");
    }    
    @Test
    public void testBar() {
        bar();
    }

}
