package my.ch23annotation;

// 单元测试

public class AtUnitExample1 {
    public String methodOne() {
        return "MethondOne";
    }    
    public int methodTwo() {
        System.out.println("MethodTwo");
        return 2;
    }
    @Test
    boolean methodOneTest() {
        return methodOne().equals("MethodOne");
    }
    @Test
    boolean methodTwoTest() {
        return methodTwo() == 2;
    }
    @Test 
    private boolean m3() { return true; }
    @Test
    boolean failureTest() { return false; }
    @Test
    boolean anotherDisappointment() {
      return false;
    }
}
