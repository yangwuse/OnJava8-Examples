package my.ch20generics.genericerase;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import bookcode.onjava.Suppliers;

// 显示工厂

// 实现了 Supplier
class IntegerFactory implements Supplier<Integer> {
    private int i;
    @Override public Integer get() {
        return ++i;
    }
}

// 实现了 Supplier
class Widget {
    private int id;
    Widget(int n) { id = n; }
    @Override public String toString() {
        return "Widget " + id;
    }
    public static 
    class Factory implements Supplier<Widget> {
        private int i;
        @Override public Widget get() { return new Widget(++i); }
    }
}

// 未实现 Supplier
class Fudge {
    private static int count = 1;
    private int n = count++;
    @Override public String toString() {
        return "Fudge " + n;
    }
}

class Foo2<T> {
    private List<T> x = new ArrayList<>();
    Foo2(Supplier<T> factory) {
        Suppliers.fill(x, factory, 5);
    }
    @Override public String toString() {
        return x.toString();
    }
}

public class FactoryConstraint {
    public static void main(String[] args) {
        System.out.println(new Foo2<>(new IntegerFactory()));
        System.out.println(new Foo2<>(new Widget.Factory()));
        System.out.println(new Foo2<>(Fudge::new));
    }
}
