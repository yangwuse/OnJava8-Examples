package my.ch20generics.genericmethod;

import java.util.stream.Stream;

import bookcode.generics.CountedObject;

public class BasicSupplierDemo {
    public static void main(String[] args) {
        // generate 参数是一个参数化的 Supplier 对象
        Stream.generate(
            BasicSupplier.create(CountedObject.class))
            .limit(5)
            .forEach(System.out::println);
    }    
}
