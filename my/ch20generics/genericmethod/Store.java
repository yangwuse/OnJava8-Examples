package my.ch20generics.genericmethod;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;

import javax.print.attribute.standard.MediaSize.NA;

import bookcode.onjava.Suppliers;

// 泛型构造复合数据结构
// 商店[ 过道[ 货架[ 产品 ] ] ]

// 产品类
class Product {
    private final int id;
    private String description;
    private double price;
    Product(int id, String descr, double price) {
        this.id = id;
        description = descr;
        this.price = price;
        toString();
    }
    @Override public String toString() {
        return id + ": " + description + ", price: $" + price;
    }
    // Supplier<Product> 构造器
    public static Supplier<Product> generator = 
        new Supplier<>() {
            private Random rand = new Random(47);
            @Override public Product get() {
                return new Product(rand.nextInt(1000), "Test", 
                    Math.round(rand.nextDouble() * 1000.0) + 0.99);
            }
        };
}


// 货架类
class Shelf extends ArrayList<Product> {
    Shelf(int nProducts) {
        Suppliers.fill(this, Product.generator, nProducts);
    }
}

// 过道类
class Aisle extends ArrayList<Shelf> {
    Aisle(int nShelves, int nProducts) {
        IntStream.range(0, nShelves)
            .forEach(i -> add(new Shelf(nProducts)));
    }
}

// 收银台
class CheckoutStand {}
// 办公室
class Office {}

// 商店类
class Store extends ArrayList<Aisle> {
    private ArrayList<CheckoutStand> checkouts = 
        new ArrayList<>();
    private Office office = new Office();

    public Store(int nAisles, int nShelves, int nProducts) {
        IntStream.range(0, nAisles)
            .forEach(i -> add(new Aisle(nShelves, nProducts)));
    }

    @Override public String toString() {
        StringBuilder res = new StringBuilder();
        // this.stream()
        //     .forEach(
        //         aisle -> forEach(
        //                 shelf -> forEach(
        //                     product -> res.append(product).append("\n"))));
        for (Aisle a : this)
            for (Shelf s : a)
                for (Product p : s)
                    res.append(p).append("\n");
                
        return res.toString();
    }
    public static void main(String[] args) {
        System.out.println(new Store(5, 4, 3));
    }
}