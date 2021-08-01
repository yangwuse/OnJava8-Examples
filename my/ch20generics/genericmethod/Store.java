package my.ch20generics.genericmethod;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import bookcode.onjava.Suppliers;

// 泛型构造复合数据结构

class Product {
    private final int id;
    private String description;
    private double price;
    Product(int id, String descr, double price) {
        this.id = id;
        description = descr;
        this.price = price;
        System.out.println(toString());
    }
    @Override public String toString() {
        return id + ": " + description + ", price: $" + price;
    }
    public void changePrice(double change) {
        price += change;
    }
    // 生成器
    public static Supplier<Product> generator = 
        new Supplier<>() {
            private Random rand = new Random(47);
            @Override public Product get() {
                return new Product(rand.nextInt(1000), "Test",
                    Math.round(rand.nextDouble() * 1000.0) + 0.90);
            }
        };
    
}

class Shelf extends ArrayList<Product>  {
    Shelf(int nProducts) {
        Suppliers.fill(this, Product.generator, nProducts);
    }
}

class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelves, int nProducts) {
        IntStream.range(0, nShelves)
            .forEach(i -> add(new Shelf(nProducts)));
    }
}

class CheckoutStand {}
class Office {}

public class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts  = 
        new ArrayList<>();
    private Office office = new Office();
    public Store(int nAisles, int nShelves, int nProducts) {
        IntStream.range(0, nAisles)
            .forEach(i -> add(new Aisle(nShelves, nProducts)));
            
    }
    @Override public String toString() {
        StringBuilder res = new StringBuilder();
        // this.stream()
        //     .forEach(aisle -> 
        //         forEach(shelf -> 
        //             forEach(product -> 
        //                 res.append(product).append("\n"))));
        for(Aisle a : this)
            for(Shelf s : a)
                for(Product p : s) {
                    res.append(p).append("\n");
            }
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Store(5, 4, 3));
    }
}
