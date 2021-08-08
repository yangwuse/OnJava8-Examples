package my.interfaces.decouple.interfaceprocessor;

import bookcode.interfaces.filters.BandPass;
import bookcode.interfaces.filters.Filter;
import bookcode.interfaces.filters.HighPass;
import bookcode.interfaces.filters.LowPass;
import bookcode.interfaces.filters.Waveform;

// 适配器模式
// 适配器对象作为中间人 连接A方和B方

public class FilterAdapter implements Processor {
    Filter filter;

    FilterAdapter(Filter f) { filter = f; }

    @Override
    public Waveform process(Object input) {
        return filter.process((Waveform) input);
    }

    @Override
    public String toString() {
        return filter.name();
    }
    
    public static void main(String[] args) {
        Waveform w = new Waveform();
        Applicator.apply(new FilterAdapter(new LowPass(1.0)), w);
        Applicator.apply(new FilterAdapter(new HighPass(5.0)), w);
        Applicator.apply(new FilterAdapter(new BandPass(2.0, 4.0)), w);
    }
}
