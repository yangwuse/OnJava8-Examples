package my.interfaces.decouple.interfaceprocessor;

import java.util.Arrays;

public class Splitter implements StringProcessor{
    // 返回协变类型
    @Override
    public String process(Object input) {
        return Arrays.toString(((String)input).split(" "));
    }
}
