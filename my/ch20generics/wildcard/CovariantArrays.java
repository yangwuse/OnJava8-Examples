package my.ch20generics.wildcard;

// 协变数组

class Fruit {}
class Apple extends Fruit {}
class Jonathan extends Apple {}
class Orange extends Fruit {}

public class CovariantArrays {
    public static void main(String[] args) {
        Fruit[] fruit = new Apple[10];
        // 只能存 Apple 和 Apple 子类
        fruit[0] = new Apple(); // ok
        fruit[1] = new Jonathan(); // ok
        // 运行时类型是 Apple[], 不是 Fruit[] 或者 Orange[]
        try {
            // 编译器允许
            fruit[0] = new Fruit(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
        try {
            // 编译器允许
            fruit[0] = new Orange(); // ArrayStoreException
        } catch(Exception e) { System.out.println(e); }
    }    
}
