package my.ch20generics.simplegenerics;

import my.commonclass.Tuple2;
import my.commonclass.Tuple3;
import my.commonclass.Tuple4;
import my.commonclass.Tuple5;

public class TupleTest {
    static Tuple2<String, Integer> f() {
        return new Tuple2<>("hi", 47);
    }
    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3<>(new Amphibian(), "hi", 47);
    }
    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4<>(new Vehicle(), new Amphibian(), "hi", 47);
    } 
    static Tuple5<Amphibian, Vehicle, String, Integer, Double> k() {
        return new Tuple5<>(new Amphibian(), new Vehicle(), "hi", 47, 11.1);
    }

    public static void main(String[] args) {
        Tuple2<String, Integer> tuple2 = f();
        System.out.println(tuple2);
        // 编译错误 final 常量不能重新赋值
        // tuple2.a = "hello";
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
