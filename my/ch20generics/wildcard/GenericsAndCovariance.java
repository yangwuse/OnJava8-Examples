package my.ch20generics.wildcard;

import java.util.ArrayList;
import java.util.List;

// 通配符允许协变

public class GenericsAndCovariance {
    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<>();
        // 无法添加任何类型的对象
        // flist.add(new Fruit());
        // flist.add(new Apple());
        // flist.add(new Orange());
        flist.add(null); 
        Fruit f = flist.get(0);
        System.out.println(f);
    }
}
