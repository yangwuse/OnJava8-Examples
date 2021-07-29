package my.ch20generics.holder;

// 参数类型占位符 T 替换 Object 
// 不需要手动类型转换 编译器负责类型校验和装换
public class GenericHolder<T> {
    private T o;
    public GenericHolder() {}
    public void set(T o) { this.o = o; }
    public T get() { return o; }

    public static void main(String[] args) {
        GenericHolder<Automobile> h2 = new GenericHolder<>();
        h2.set(new Automobile());
        // 此时不需要显示类型转换
        Automobile a = h2.get();    
        System.out.println(a);
        // 只能持有一种类型
        // h2.set("hello");
        // h2.set(1);
    }
}
