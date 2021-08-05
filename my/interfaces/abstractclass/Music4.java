package my.interfaces.abstractclass;

import bookcode.polymorphism.music.Note;
import jdk.internal.net.http.frame.WindowUpdateFrame;

// 抽象类 管弦乐器

// 抽象基类
abstract class Instrument {
    private int i; 
    public abstract void play(Note n);
    public String what() { return "Instrument"; }
    public abstract void adjust();
}

class Wind extends Instrument {
    @Override public void play(Note n) {
        System.out.println("Wind.play() " + n);
    }
    @Override public String what() { return "Wind"; }
    @Override public void adjust() {
        System.out.println("Adjustint wind");
    }
}

class Percussion extends Instrument {
    @Override public void play(Note n) {
        System.out.println("Percussion.play() " + n);
    }
    @Override public String what() { return "Percussion"; }
    @Override public void adjust() {
        System.out.println("Adjusting percussion");
    }
}

class Stringed extends Instrument {
    @Override public void play(Note n) {
        System.out.println("Stringed.play() " + n);
    }
    @Override public String what() { return "Stringed"; }
    @Override public void adjust() {
        System.out.println("Adjusting Stringed");
    }
}

class Brass extends Wind {
    @Override public void play(Note n) {
      System.out.println("Brass.play() " + n);
    }
    @Override public void adjust() {
      System.out.println("Adjusting Brass");
    }
  }
  
  class Woodwind extends Wind {
    @Override public void play(Note n) {
      System.out.println("Woodwind.play() " + n);
    }
    @Override public String what() { return "Woodwind"; }
  }
  




public class Music4 {
    static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }
    static void tuneAll(Instrument[] e) {
        for (Instrument i : e)
            tune(i);
    }
    public static void main(String[] args) {
        Instrument[] orchestra = {
            new Wind(),
            new Percussion(),
            new Stringed(),
            new Brass(),
            new Woodwind()
        };
        tuneAll(orchestra);
    }
}
