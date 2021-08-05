package my.functionnal.functionalinterface;

public class TriFunctionTest {
    static int f(int i, long l, double d) { return 100; }
    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf =
            TriFunctionTest::f;
        System.out.println(tf.apply(1, 2l, 3d));
        tf = (i, l, d) -> i;
        System.out.println(tf.apply(1, 2l, 3d));
    }
}
