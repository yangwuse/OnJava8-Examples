package my.interfaces.interfacecreation;

public class AnImplementation implements AnInterface {

    @Override public void firstMethod() {
        System.out.println("firstMethod");
    }

    @Override public void secondeMethod() {
        System.out.println("secondMethod");
    }

    public static void main(String[] args) {
        AnInterface i = new AnImplementation();
        i.firstMethod();
        i.secondeMethod();
    }
}
