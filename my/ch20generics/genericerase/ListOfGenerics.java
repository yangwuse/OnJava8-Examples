package my.ch20generics.genericerase;

import java.util.ArrayList;
import java.util.List;

// 用 ArrayList 替代泛型数组

public class ListOfGenerics<T> {
    private List<T> array = new ArrayList<>();
    public void add(T item) { array.add(item); }
    public T get(int i) { return array.get(i); }
}

// 用继承替代泛型数组

class ListOfGenerics2<T> extends ArrayList<T> {}