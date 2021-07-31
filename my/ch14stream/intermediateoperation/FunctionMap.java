package my.ch14stream.intermediateoperation;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

// map(func) 映射函数到输入流中每个元素 
// 并且将返回值放入输出流中
public class FunctionMap {
    static String[] elements = { "12", "", "23", "34" };
    static Stream<String> stream() {
        return Arrays.stream(elements);
    }
    static void test(String descr, Function<String, String> func) {
        System.out.println(" ---( " + descr + " )--- ");
        stream()
            .map(func)
            .forEach(System.out::println);
    }
    public static void main(String[] args) {
        // 给每个元素添加括号
        test("Add []", s -> "[" + s + "]");

        // 每个元素 + 1
        test("Increment 1", s -> {
            try {
                return Integer.parseInt(s) + 1 + "";
            } catch(NumberFormatException e) {
                return s;
            }
        });

        // 每个元素替换数字
        test("Replace digit", s -> s.replace("2", "9"));

        // 获取最后一个数字
        test("Take last digit", s -> s.length() > 0 ? 
            s.charAt(s.length() - 1) + "" : s);
    }
}
