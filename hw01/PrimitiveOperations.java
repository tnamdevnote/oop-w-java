package hw01;

public class PrimitiveOperations {
  public static void main(String[] args) {
    // a
    int price = 30;
    double discountRate = 0.5;
    System.out.println(price);
    System.out.println(discountRate);

    // b
    double finalPrice = price - (price*discountRate);
    System.out.println(finalPrice);
    // c
    double modifiedPrice = (float)price;
    System.out.println(modifiedPrice);
    // d
    int modifiedDiscountRate = (int)discountRate;
    System.out.println(modifiedDiscountRate);

    // e
    char upperCaseLetter = 'T';
    System.out.println(upperCaseLetter);

    // f
    System.out.println((char)((int)upperCaseLetter + (char)32));
  }
}
