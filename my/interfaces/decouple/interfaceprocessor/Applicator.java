package my.interfaces.decouple.interfaceprocessor;

public class Applicator {
    public static void apply(Processor p, Object o) {
        System.out.println("Using Processor " + p.name());
        System.out.println(p.process(o));
    } 
}
