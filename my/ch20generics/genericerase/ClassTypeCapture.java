package my.ch20generics.genericerase;

class Building{}
class House extends Building{}

public class ClassTypeCapture<T> {
    Class<T> kind;
    public ClassTypeCapture(Class<T> k) { kind = k; }
    public boolean f(Object arg) {
        return kind.isInstance(arg);
    }
    public static void main(String[] args) {
        // 父类标签 Building.class 
        ClassTypeCapture<Building> ctt1 = 
            new ClassTypeCapture<>(Building.class);
        System.out.println(ctt1.f(new Building()));
        System.out.println(ctt1.f(new House()));
    
        // 子类标签
        ClassTypeCapture<House> ctt2 = 
            new ClassTypeCapture<>(House.class);
        System.out.println(ctt2.f(new House()));
        System.out.println(ctt2.f(new Building())); // false
    }
}
