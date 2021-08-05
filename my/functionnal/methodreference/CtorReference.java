package my.functionnal.methodreference;

// 构造函数引用

class Dog {
    String name;
    int age = -1; // 未知
    Dog() { name = "stray"; }
    Dog(String nm) { name = nm; }
    Dog(String nm, int years) { name = nm; age = years; }
}

interface MakeNoArgs {
    Dog make();
}

interface Make1Arg {
    Dog make(String nm);
}

interface Make2Args {
    Dog make(String nm, int age);
}

public class CtorReference {
    public static void main(String[] args) {
        MakeNoArgs mna = Dog::new;
        Make1Arg m1a = Dog::new;
        Make2Args m2a = Dog::new;

        Dog dn = mna.make();
        Dog d1 = m1a.make("Comet");
        Dog d2 = m2a.make("Ralph", 4);  
    }
}
