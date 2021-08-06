package my.interfaces.interfacecreation;

import bookcode.polymorphism.music.Note;

// 使用接口作为基类
// default 方法实现多继承效果

interface Instrument {
    // 编译时常量 默认 static final
    int VALUE = 5;
    // 默认 public 
    default void play(Note n) {
        System.out.println(this + ".play() " + n);
    }
    default void adjust() {
        System.out.println("Adjusting " + this);
    }
}

class Wind implements Instrument {
    @Override public String toString() {
        return "Wind";
    }
}

class Percussion implements Instrument {
    @Override public String toString() {
        return "Percussion";
    }
}

class Stringed implements Instrument {
    @Override public String toString() {
        return "Stringed";
    }
}


class Brass extends Wind {
    @Override public String toString() {
        return "Brass";
    }
}

class Woodwind extends Wind {
    @Override public String toString() {
        return "Woodwind";
    }
}

public class Music5 {
    // 使用接口充当参数类型 可以兼容新的实现类
    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for (Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind()
        };
        tuneAll(orchestra);
    }
}


