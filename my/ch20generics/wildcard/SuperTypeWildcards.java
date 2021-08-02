package my.ch20generics.wildcard;

import java.util.List;

// 超类型通配符

public class SuperTypeWildcards {
    static void writeTo(List<? super Apple> apples) {
        // 父类集合可以添加子类对象
        apples.add(new Apple());
        apples.add(new Jonathan());
        // error
        // apples.add(new Fruit());
        
    }    
}
