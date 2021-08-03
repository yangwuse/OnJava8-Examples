package my.ch20generics.wildcard;

import java.util.Arrays;
import java.util.List;


public class GenericReading {
    static List<Apple> apples =  Arrays.asList(new Apple());
    static List<Fruit> fruit = Arrays.asList(new Fruit());
    static <T> T readExact(List<T> list) {
        return list.get(0);
    }

    static void f1() {
        Apple a = readExact(apples);
        Fruit f = readExact(fruit);
        f = readExact(apples);
    }

    static class Reader<T> {
        T readExact(List<T> list) { return list.get(0); }
    }

    static void f2() {
        Reader<Fruit> fReader =  new Reader<>();
        Fruit f = fReader.readExact(fruit);
        // incompatible types: List<Apple> cannot be converted to List<Fruit>
        // Fruit a = fReader.readExact(apples); 
    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list) {
            return list.get(0);
        }
    }

    static void f3() {
        CovariantReader<Fruit> cReader = new CovariantReader<>();
        Fruit f = cReader.readCovariant(fruit);
        Fruit a = cReader.readCovariant(apples);
    }

    public static void main(String[] args) {
        f1(); f2(); f3();
    }
}
