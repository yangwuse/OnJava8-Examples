package my.ch20generics.genericerase;

import java.util.stream.IntStream;

// 集合中最好使用 Object[]

public class GenericArray2<T> {
    private Object[] array;
    public GenericArray2(int sz) {
        array = new Object[sz];
    }
    public void put(int i, T e) {
        array[i] = e;
    }
    // Object 转 T ok
    @SuppressWarnings("unchecked")
    public T get(int i) { return (T)array[i]; }
    // Object[] 转 T[] 失败
    @SuppressWarnings("unchecked")
    public T[] rep() { return (T[])array; }
    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        IntStream.range(0, 10)
            .forEach(i -> gai.put(i, i));
        IntStream.range(0, 10)
            .forEach(i -> System.out.format("%d ", gai.get(i)));
        System.out.println();
        try {
            Integer[] ia = gai.rep();
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
