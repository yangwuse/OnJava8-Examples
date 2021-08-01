package my.ch20generics.genericinterface;

import java.util.Iterator;

// 适配器 拓展原来类的功能
// 继承原类 实现某个接口

public class IterableFibonacci extends Fibonacci 
    implements Iterable<Long> {
    private int n;
    public IterableFibonacci(int count) { n = count; }

    @Override public Iterator<Long> iterator() {
        // 匿名内部类 只用一次
        return new Iterator<Long>() {
            @Override public boolean hasNext() { return n >  0; }
            @Override public Long next() {
                n--;
                return IterableFibonacci.this.get();
            }
            @Override public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static void main(String[] args) {
        // 实现了 Iterable 接口 就支持 for-each
        for (Long l : new IterableFibonacci(20))
            System.out.println(l);
    }
        
    
}
