package my.ch20generics.problem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 自动装箱有局限

class ByteSet {
    Byte[] bytes = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
    Set<Byte> mySet = 
        new HashSet<>(Arrays.asList(bytes));

    // 不能自动装箱 int -> Byte
    // Set<Byte> mySet2 = 
    //     new HashSet<>(Arrays.<Byte>asList(1,3,4));
}
