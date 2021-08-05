package my.functionnal.lambdaexpression;

import bookcode.generics.Fibonacci;

// 递归 Lambda 表达式实现斐波那契数列

public class RecursiveFibonacci {   
    IntCall fib;
    RecursiveFibonacci() {
        fib = n -> n == 0 ? 0 :
                   n == 1 ? 1 :
                   fib.call(n - 2) + fib.call(n - 1);
    }
    int fibonacci(int n) { return fib.call(n); }
    public static void main(String[] args) {
        RecursiveFibonacci rf = new RecursiveFibonacci();
        for (int i = 0; i <= 10; i++)
            System.out.println(rf.fibonacci(i));
    }
}
