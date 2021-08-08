package my.interfaces.decouple.filters;

public class WaveForm {
    private static long count;
    private final long id = count++;
    @Override public String toString() {
        return "WaveForm " + id;
    }
}
