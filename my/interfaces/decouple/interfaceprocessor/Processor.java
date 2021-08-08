package my.interfaces.decouple.interfaceprocessor;

public interface Processor {
    // 接口默认方法实现继承效果
    default String name() {
        return getClass().getName();
    }    
    Object process(Object input);
}
