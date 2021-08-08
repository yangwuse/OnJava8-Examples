package my.interfaces.multiinterface;

// 接口组合 
// 只能继承一个类 但可以同时组合多个接口

interface CanFight {
    void fight();
}

interface CanSwim {
    void swim();
}

interface CanFly {
    void fly();
}

class ActionCharacter {
    public void fight() {}
}

class Hero extends ActionCharacter implements CanFight,
CanSwim, CanFly {

    @Override
    public void fly() {
        
    }

    @Override
    public void swim() {
        
    }
}

public class Adventure {
    public static void t(CanFight x) {
        x.fight();
    }
    public static void u(CanFly x) {
        x.fly();
    }
    public static void v(CanSwim x) {
        x.swim();
    }
    public static void w(ActionCharacter x) {
        x.fight();
    }
    public static void main(String[] args) {
        Hero h = new Hero();
        // 向上转型到每个父类
        t(h);
        u(h);
        v(h);
        w(h);
    }
}
