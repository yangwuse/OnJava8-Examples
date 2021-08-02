package my.ch20generics.genericerase;

class Generic<T> {}

public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;
    public static void main(String[] args) {
        try {
            gia = (Generic<Integer>[]) new Object[SIZE];
        } catch(ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // 运行时类型是 Generic[] 擦除类类型信息
        gia = (Generic<Integer>[])new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());
        gia[0] = new Generic<>();
    }
}

