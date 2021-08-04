package my.ch8reuse;

// 初始化引用的四种时机

class Soap {
    private String s;
    Soap() {
        System.out.println("Soap()");
        s = "Constructed";
    }       
    @Override public String toString() { return s; }
}

public class Bath {
    // 定义时
    private String s1 = "aaa", s2 = "bbb", s3, s4;
    private Soap castile;
    private int i;
    private float toy;
    // 构造器中
    public Bath() {
        System.out.println("Inside Bath()");
        s3 = "ccc";
        toy = 3.14f;
        castile = new Soap();
    }
    // 实例初始化时
    { i = 1; }
    // 调用时(延迟初始化)
    @Override public String toString() {
        if (s4 == null)
            s4 = "ddd";
        return 
        "s1 = " + s1 + "\n" +
        "s2 = " + s2 + "\n" +
        "s3 = " + s3 + "\n" +
        "s4 = " + s4 + "\n" +
        "i = " + i + "\n" +
        "toy = " + toy + "\n" +
        "castile = " + castile;
    }
    public static void main(String[] args) {
        Bath b = new Bath();
        System.out.println(b);
    }
}

