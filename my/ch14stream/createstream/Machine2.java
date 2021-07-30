package my.ch14stream.createstream;

import java.util.Arrays;

import bookcode.onjava.Operations;

// Arrays.stream() 数组流
public class Machine2 {
    public static void main(String[] args) {
        Arrays.stream(new Operations[] {
            () -> Operations.show("A"),
            () -> Operations.show("B"),
            () -> Operations.show("C")
        }).forEach(Operations::execute);
    }
}
