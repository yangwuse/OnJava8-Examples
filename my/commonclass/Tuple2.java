package my.commonclass;

// 定义泛型二元组 P795
public class Tuple2<A, B> {
    // public final 没有破话封装性
    public final A a;
    public final B b;
    public Tuple2(A a, B b) { 
        this.a = a;
        this.b = b;
    }
    public String rep() { 
        return a + ", " + b; 
    }
    @Override public String toString() {
        return "(" + rep() + ")";
    }
}
