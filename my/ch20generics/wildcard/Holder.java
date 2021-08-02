package my.ch20generics.wildcard;

import java.util.Objects;

public class Holder<T> {
    private T value;
    public Holder() {}
    public Holder(T val) { value = val; }
    public void set(T val) { value = val; }
    public T get() { return value; }
    @Override public boolean equals(Object o) {
        return o instanceof Holder && 
            Objects.equals(value, ((Holder)o).value);
    }
    @Override public int hashCode() {
        return Objects.hash(value);
    }
    public static void main(String[] args) {
        Holder<Apple> apple = new Holder<>(new Apple());
        Apple d = apple.get();
        apple.set(d);

        // Holder<Fruit> 和 Holer<Apple> 无关 
        // 不能向上转型
        // Holder<Fruit> fruit = apple; 

        // <? extends Fruit> 表示某个 Fruit 类型
        // <Apple> 是 <? extends Fruit> 具体类型
        Holder<? extends Fruit> fruit = apple; 
        Fruit p = fruit.get();
        // 返回 Object 类型
        d = (Apple)fruit.get();
        try {
            Orange c = (Orange)fruit.get();
        } catch(Exception e) { System.out.println(e); }
        // set() 参数变为 <? extends Fruit> 无法确定具体类型
        // fruit.set(new Apple());
        // fruit.set(new Fruit());
        System.out.println(fruit.equals(d));

    }
}
