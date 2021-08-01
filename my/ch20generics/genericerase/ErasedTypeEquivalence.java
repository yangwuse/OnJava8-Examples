package my.ch20generics.genericerase;

import java.util.ArrayList;

// 泛型类型擦除

public class ErasedTypeEquivalence {
    public static void main(String[] args) {
        Class c1 = new ArrayList<String>().getClass();
        Class c2 = new ArrayList<Integer>().getClass();
        System.out.println(c1 == c2);
    }    
}
