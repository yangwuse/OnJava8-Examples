package my.ch20generics.simplegenerics;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.w3c.dom.ls.LSException;

import bookcode.streams.RandInts;


// 链式泛型栈
public class LinkedStack<T> {
    private static class Node<U> {
        U item;
        Node<U> next;
        Node() {}
        Node(U i, Node<U> n) { item = i; next = n; }
        boolean end() {
            return item == null && next == null;
        }
    }
    private Node<T> top = new Node<>();
    public void push(T e) {
        top = new Node(e, top);
    }
    public T pop() {
        T res = top.item;
        if (!top.end())
            top = top.next;
        return res;
    }
    public static void main(String[] args) {
        LinkedStack<Integer> ls = new LinkedStack<>();
        IntStream.range(1, 11)
            .forEach(ls::push);
        Integer s;
        while ((s = ls.pop()) != null)
            System.out.print(s + " ");
    }
}
