package my.ch14stream.loop;

// range() 替代普通循环
public class Looping {
    public static void hi() {
        System.out.println("hi");
    }
    public static void main(String[] args) {
        Repeat.repeat(3, () -> System.out.println("Looping"));
        Repeat.repeat(2, Looping::hi);
    }
}
