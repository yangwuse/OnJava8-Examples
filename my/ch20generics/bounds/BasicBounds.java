package my.ch20generics.bounds;

import java.awt.Color;

// 绑定类型参数 可以调用被绑定类型的方法
// <T extends HasColor> T 绑定到 HasColor
// T 是 HasColor 的子类

interface HasColor { java.awt.Color getColor(); }

class WithColor<T extends HasColor> {
    T item;
    WithColor(T i) { item = i; }
    T getItem() { return item; }
    // 调用 HasColor getColor()
    java.awt.Color color() { return item.getColor(); }
}

class Coord { int x, y, z; }

class WithColorCoord<T extends Coord & HasColor> {
    T item;
    WithColorCoord(T i) { item = i; }
    T getItem() { return item; }
    java.awt.Color color() { return item.getColor(); }
    // 调用 Coord 属性
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
}

interface Weight { int getWeight(); }

class Solid<T extends Coord & HasColor & Weight> {
    T item;
    Solid(T i) { item = i; }
    T getItem() { return item; }
    java.awt.Color color() { return item.getColor(); }
    int getX() { return item.x; }
    int getY() { return item.y; }
    int getZ() { return item.z; }
    // 调用 Weight getWeight() 
    int weight() { return item.getWeight(); }
}

class Bounded extends Coord implements HasColor, Weight {

    @Override public int getWeight() {
        return 0;
    }
    @Override public Color getColor() {
        return null;
    }
}

public class BasicBounds {
    public static void main(String[] args) {
        Solid<Bounded> solid = new Solid<>(new Bounded());
        solid.color();
        solid.getY();
        solid.weight();
    }
}
