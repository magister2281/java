import org.junit.Assert;

public class first {public static void main(String[] args) {


    System.out.println(calculator.add(23, 35));
    System.out.println(calculator.multiply(2, 2));
    System.out.println(calculator.divide(9, 3));
    System.out.println(calculator.subtract(9, 3));
    Assert.assertEquals(3, calculator.divide(9,3));
    Assert.assertEquals(4, calculator.multiply(2,2));
    Assert.assertEquals(12, calculator.add(9,3));
    Assert.assertEquals(6, calculator.subtract(9,3));

}
}
