package my.ch20generics.bounds;

import java.util.List;

// 更多层次的继承结构

interface SuperPower {}

interface XRayVision extends SuperPower {
    void seeThroughWalls();
}

interface SuperHearing extends SuperPower {
    void hearSubtleNoises();
}

interface SuperSmell extends SuperPower {
    void trackBySmell();
}

// 顶层父类 类型参数也是最顶层
// 相当于一个包装器
class SuperHero<POWER extends SuperPower> {
    POWER power;
    SuperHero(POWER power) { this.power = power; }
    POWER getPower() { return power; }
}

class SuperSleuth<POWER extends XRayVision> 
extends SuperHero<POWER> {
    SuperSleuth(POWER power) { super(power); }
    void see() { power.seeThroughWalls(); }
}

class CanineHero<POWER extends SuperHearing & SuperSmell> 
extends SuperHero<POWER> {
    CanineHero(POWER power) { super(power); }
    void hear() { power.hearSubtleNoises(); }
    void smell() { power.trackBySmell(); }
}

// 测试类
class SuperHearSmell implements SuperHearing, SuperSmell {
    @Override public void hearSubtleNoises() {}
    @Override public void trackBySmell() {}
}

class DogPerson extends CanineHero<SuperHearSmell> {
    DogPerson() { super(new SuperHearSmell()); }
}

public class EpicBattle {
    static <POWER extends SuperHearing> 
    void useSuperHearing(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
    }  
    static <POWER extends SuperHearing & SuperSmell> 
    void superFind(SuperHero<POWER> hero) {
        hero.getPower().hearSubtleNoises();
        hero.getPower().trackBySmell();
    }

    public static void main(String[] args) {
        DogPerson dogPerson = new DogPerson();
        useSuperHearing(dogPerson);
        superFind(dogPerson);
        List<? extends SuperHearing> audioPeople;
    }
}