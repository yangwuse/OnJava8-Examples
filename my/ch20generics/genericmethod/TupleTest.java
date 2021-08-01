package my.ch20generics.genericmethod;

import bookcode.generics.Vehicle;
import bookcode.onjava.Tuple2;
import bookcode.onjava.Tuple3;
import bookcode.onjava.Tuple4;
import my.ch20generics.simplegenerics.Amphibian;

// 使用静态方法和类型推测重新测试泛型元组类

public class TupleTest {
    static Tuple2<String, Integer> f() {
        return new Tuple2("hi", 47);
    }
    static Tuple3<Amphibian, String, Integer> g() {
        return new Tuple3(new Amphibian(), "hi", 47);
    }
    static 
    Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return new Tuple4(new Vehicle(), new Amphibian(), "hi", 47);
    }
    public static void main(String[] args) {
        System.out.println(f());
        System.out.println(g());
        System.out.println(h());
    }
    
}
