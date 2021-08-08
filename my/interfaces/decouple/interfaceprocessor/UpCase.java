package my.interfaces.decouple.interfaceprocessor;

// 策略类

public class UpCase implements StringProcessor {
    // 返回协变类型
    @Override
    public String process(Object input) {
        return ((String)input).toUpperCase();
    }
}
