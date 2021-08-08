package my.interfaces.interfaceadapter;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Scanner;

// 构建适配器接口
// 通过 implements 适配两个接口

public class AdapterRandomDouble implements RandonDouble, Readable {
    private int count;
    public AdapterRandomDouble(int count) {
        this.count = count;
    } 

    @Override
    public int read(CharBuffer cb) throws IOException {
        if (count-- == 0)
            return -1;
        String res = Double.toString(next()) + " ";
        cb.append(res);
        return res.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(new AdapterRandomDouble(10));
        while (sc.hasNext())
            System.out.println(sc.next());
    }
}
