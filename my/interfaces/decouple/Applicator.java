package my.interfaces.decouple;

import java.util.Arrays;

class Processor {
    String name() {
        return getClass().getSimpleName();
    }
    Object process(Object input) { return input; }
}

class Upcase extends Processor {
    // 返回协变类型
    @Override String process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Downcase extends Processor {
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
    static void apply(Processor p, Object s) {
        System.out.println("Using processor " + p.name());
        System.out.println(p.process(s));
    }
    public static void main(String[] args) {
        String s =
        "We are such stuff as dreams are made on";
        apply(new Upcase(), s);
        apply(new Downcase(), s);
        apply(new Splitter(), s);
    }
}
