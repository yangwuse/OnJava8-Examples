package my.ch20generics.holder;

// 持有 Object 对象 需要手动类型转换 p793
public class ObjectHolder {
    private Object o;
    public ObjectHolder(Object o) { this.o = o; }
    public void set(Object o) { this.o = o; }
    public Object get() { return o; }

    public static void main(String[] args) {
        System.out.println("hello");
        ObjectHolder h2 = new ObjectHolder(new Automobile());
        // 显示类型转换 麻烦
        Automobile a = (Automobile) h2.get();
        h2.set("hello");
        String s = (String) h2.get();
        h2.set(1);
        Integer i = (Integer) h2.get();
        System.out.printf("%s %s %d %n", a, s, i);
    }
}
