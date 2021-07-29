package my.ch20generics.holder;

// 钻石语法 <> 类型推测
public class Diamond<T> {
    public static void main(String[] args) {
        GenericHolder<Bob> h3 = new GenericHolder<>();
        h3.set(new Bob());
    }
}
class Bob {}
