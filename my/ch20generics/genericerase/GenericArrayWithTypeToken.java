package my.ch20generics.genericerase;

import java.lang.reflect.Array;

// 传入类型标记 恢复被擦除的类型

public class GenericArrayWithTypeToken<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArrayWithTypeToken(Class<T> type, int sz) {
        array = (T[]) Array.newInstance(type, sz);
    }
    public void put(int i, T e) { array[i] = e; }
    public T get(int i) { return array[i]; }
    public T[] rep() { return array; }
    public static void main(String[] args) {
        GenericArrayWithTypeToken<Integer> gai = 
            new GenericArrayWithTypeToken<>(Integer.class, 10);
        // ok
        Integer[] ia = gai.rep();
    }

}
