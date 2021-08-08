package my.interfaces.decouple.interfaceprocessor;

// 接口中可以使用 main()

public interface StringProcessor extends Processor{
    String str = "Hello World";
    public static void main(String[] args) {
        // 复用 apply() 
        Applicator.apply(new UpCase(), str);
        Applicator.apply(new DownCase(), str);
        Applicator.apply(new Splitter(), str);
    }
}
