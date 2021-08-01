package my.ch20generics.genericerase;

import java.util.function.Supplier;

// 实例化泛型类型

class ClassAsFactory<T> implements Supplier<T> {
    Class<T> kind;
    public ClassAsFactory(Class<T> kind) {
        this.kind = kind;
    }
    @Override public T get() {
        try {
            return kind.getConstructor().newInstance();
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
    public Employee() {}
    @Override public String toString() {
        return "Employee";
    }
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        // 构造类型工厂
        ClassAsFactory<Employee> fe = 
            new ClassAsFactory(Employee.class);
        System.out.println(fe.get());

        ClassAsFactory<Integer> fi = 
            new ClassAsFactory(Integer.class);
        try {
            System.out.println(fi.get());
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
