package my.functionnal.functionalinterface;

// 函数式接口: 接口中只有一个抽象方法

@FunctionalInterface
interface Functional {
    String goodbye(String arg);
}

interface FunctionalNoAnn {
    String goodbye(String arg);
}

// @FunctionalInterface
// interface NotFunctional {
//     String goodbye(String arg);
//     String hello(String arg);
// }

public class FunctionalAnnotation {
    public String goodbye(String arg) {
        return "Goodbye " + arg;
    }
    public static void main(String[] args) {
        FunctionalAnnotation fa = new FunctionalAnnotation();
        Functional f = fa::goodbye;
        FunctionalNoAnn fna = fa::goodbye;
        
        Functional fl = a -> "Goodbye " + a;
        FunctionalNoAnn fnal = a -> "Goodbye " + a;
    }
}
