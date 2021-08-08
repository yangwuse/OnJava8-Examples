package my.interfaces.decouple.filters;

public class HighPass extends Filter {
    double cutoff;
    public HighPass(double c) { cutoff = c; }
    @Override public WaveForm process(WaveForm input) {
        return input;
    }
}
