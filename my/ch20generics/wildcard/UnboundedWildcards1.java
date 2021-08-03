package my.ch20generics.wildcard;

import java.util.ArrayList;
import java.util.List;

// 无界通配符 <?>

public class UnboundedWildcards1 {
    static List list1;
    static List<?> list2;
    static List<? extends Object> list3;
    static void assign1(List list) {
        list1 = list;
        list2 = list;
        // warning
        list3 = list;
    }
    static void assign2(List<?> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }
    static void assign3(List<? extends Object> list) {
        list1 = list;
        list2 = list;
        list3 = list;
    }
    public static void main(String[] args) {
        assign1(new ArrayList());
        assign2(new ArrayList());
        // warning 
        assign3(new ArrayList());
        
        assign1(new ArrayList<>());
        assign2(new ArrayList<>());
        assign3(new ArrayList<>());

        // 原始类型和泛型都可以作为 List<?> 类型
        List<?> wildList = new ArrayList();
        wildList = new ArrayList<>();

        assign1(wildList);
        assign2(wildList);
        assign3(wildList);
    }


}
