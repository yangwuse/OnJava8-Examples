package my.interfaces.decouple.filters;

public class LowPass extends Filter {
    double cutoff;
    public LowPass(double c) { cutoff = c; }
    @Override public WaveForm process(WaveForm input) {
        // 不处理
        return input;
    }
}
