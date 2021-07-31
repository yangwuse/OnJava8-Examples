package my.ch14stream.optional;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Stream;

// Optionals 的辅助函数

public class Optionals {
    static void basics(Optional<String> optString) {
        if (optString.isPresent())
            System.out.println(optString.get());
        else 
            System.out.println("Nothing inside!");
    }    

    // ifPresent 当值存在调用函数 否则不做
    static void ifPresent(Optional<String> optString) {
        optString.ifPresent(System.out::println);
    }

    // orElse 值存在直接返回 否则生成对象
    static void orElse(Optional<String> optString) {
        System.out.println(optString.orElse("none"));
    }

    // orElseGet 值存在直接返回 否则用 Supplier 生成对象
    static void orElseGet(Optional<String> optString) {
        System.out.println(
            optString.orElseGet(() -> "Generated"));
    }

    // orElseThrow 值存在直接返回 否则 Supplier 报出异常
    static void orElseThrow(Optional<String> optString) {
        try {
            System.out.println(optString.orElseThrow(
                () -> new Exception("Supplied")));
        } catch(Exception e) {
            System.out.println("Caught " + e);
        }
    }

    static void test(String testName, 
        Consumer<Optional<String>> cos) {
        System.out.println(" === " + testName + " === ");
        // 测试 Optional 空和不空两种情况
        cos.accept(Stream.of("aaa").findFirst());
        cos.accept(Stream.<String>empty().findFirst());
    }

    public static void main(String[] args) {
        test("basic", Optionals::basics);
        test("ifPresent", Optionals::ifPresent);
        test("orElse", Optionals::orElse);
        test("orElseGet", Optionals::orElseGet);
        test("orElseThrow", Optionals::orElseThrow);
    }
}
