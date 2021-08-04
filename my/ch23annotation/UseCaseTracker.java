package my.ch23annotation;

import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 用例注解跟踪器
// 使用反射机制读取注解元素

public class UseCaseTracker {
    public static void 
    trackUseCases(List<Integer> useCases, Class<?> cl) {
        for (Method m : cl.getDeclaredMethods()) {
            UseCase uc = m.getAnnotation(UseCase.class);
            if (uc != null) {
                System.out.println("Found Use Case " + 
                    uc.id() + "\n" + uc.description());
                // 删除的是对象 不是下标
                useCases.remove(Integer.valueOf(uc.id()));
            }
        }
        useCases.forEach(i ->
            System.out.println("Missing use case" + i));
    }
    public static void main(String[] args) {
        List<Integer> list = IntStream.range(47, 51).
            boxed().collect(Collectors.toList());
        trackUseCases(list, PasswordUtils.class);
    }

}
