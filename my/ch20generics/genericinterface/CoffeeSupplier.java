package my.ch20generics.genericinterface;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

import bookcode.generics.coffee.Americano;
import bookcode.generics.coffee.Breve;
import bookcode.generics.coffee.Cappuccino;
import bookcode.generics.coffee.Coffee;
import bookcode.generics.coffee.Latte;
import bookcode.generics.coffee.Mocha;

// 泛型生成器
// Supplier<T> 生成器

public class CoffeeSupplier implements 
    Supplier<Coffee>, Iterable<Coffee> {

    private Class<?>[] types = { Latte.class, Mocha.class, 
        Cappuccino.class, Americano.class, Breve.class };
    
    private Random rand = new Random(47);
    public CoffeeSupplier() {}
    // 用于迭代
    private int size = 0;
    public CoffeeSupplier(int s) { size = s; }
    @Override public Coffee get() {
        try {
            return (Coffee)types[rand.nextInt(types.length)]
                .getConstructor().newInstance();
        } catch(InstantiationException | 
                NoSuchMethodException |
                InvocationTargetException |
                IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    // 内部迭代类
    class CoffeeIterator implements Iterator<Coffee> {
        int count = size;
        @Override public boolean hasNext() { return count > 0; }
        @Override public Coffee next() {
            count--;
            return CoffeeSupplier.this.get();
        }
        @Override public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    @Override public Iterator<Coffee> iterator() {
        return new CoffeeIterator();
    }
    public static void main(String[] args) throws Exception {
        Stream.generate(new CoffeeSupplier())
            .limit(5)
            .forEach(System.out::println);
        for (Coffee c : new CoffeeSupplier(5))
            System.out.println(c);
        String s = String.class.getConstructor().newInstance();
        System.out.println(s);
    }

    
}
