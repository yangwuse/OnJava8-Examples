package my.interfaces.decouple;

import java.util.Arrays;

// 策略模式 
// 子类对象作为策略传入方法
// UpCase DownCase Splitter 对象作为策略

class Processor {
    String name() {
        return getClass().getSimpleName();
    }
    Object process(Object input) {
        return input;
    }
}

class UpCase extends Processor {
    @Override String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class DownCase extends Processor {
    @Override String process(Object input) {
        return ((String)input).toLowerCase();
    }
}

class Splitter extends Processor {
    @Override String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}



public class Applicator {
    // 使用策略 父类型作为接受类型
    public static void apply(Processor p, Object s) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(s));
    }
    public static void main(String[] args) {
        String s = "Hello World";
        apply(new UpCase(), s);
        apply(new DownCase(), s);
        apply(new Splitter(), s);
    }
}
