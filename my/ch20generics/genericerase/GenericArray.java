package my.ch20generics.genericerase;

// 泛型数组包装器

public class GenericArray<T> {
    private T[] array;
    @SuppressWarnings("unchecked")
    public GenericArray(int sz) {
        // 创建擦除后类型数组 然后强转为泛型
        // 此处 T 类型擦除后类型为 Object 
        // 创建 Object[] 然后强转为 T[]
        array = (T[])new Object[sz];
    }
    public void put(int i, T item) {
        array[i] = item;
    }
    public T get(int i) { return array[i]; }
    public T[] rep() { return array; }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        try {
            Integer[] ia = gai.rep();
        } catch(ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // ok
        Object[] oa = gai.rep();
    }
}
