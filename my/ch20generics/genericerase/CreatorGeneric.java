package my.ch20generics.genericerase;

// 模板方法设计模式 实例化参数类型对象

// 抽象模板类 框架
abstract class GenericWithCreate<T> {
    final T element;
    // 父类构造器中调用覆盖方法
    GenericWithCreate() { element = create(); }
    // 子类覆盖该方法 创建各自类型对象
    abstract T create();
}

class X {}

// X 类的构建器
class XCreator extends GenericWithCreate<X> {
    @Override X create() { return new X(); }
    void f() {
        System.out.println(
            element.getClass().getSimpleName()
        );
    }

}

public class CreatorGeneric {
    public static void main(String[] args) {
        XCreator xc = new XCreator();
        xc.f();
    }
}
