package my.interfaces.decouple.interfaceprocessor;

public class DownCase implements StringProcessor {
    // 返回协变类型
    @Override
    public String process(Object input) {
        return ((String)input).toLowerCase();
    }
}
