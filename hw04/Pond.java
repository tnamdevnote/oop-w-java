package hw04;

public class Pond {
  public static void main(String[] args) {
    Frog peepo = new Frog("Peepo");
    Frog pepe = new Frog("Pepe", 10, 15);
    Frog peepaw = new Frog("Peepaw", 4.6, 5);
    Frog yejoo = new Frog("Yejoo", 26.0, 10);
  
    Fly flyOne = new Fly(1, 3);
    Fly flyTwo = new Fly(6);
    Fly flyThree = new Fly(7, 15);

    Frog.setSpecies("1331 Frogs");
    System.out.println(peepo.toString());
    peepo.eat(flyTwo);
    System.out.println(flyTwo.toString());
    peepo.grow(8);
    peepo.eat(flyTwo);
    System.out.println(flyTwo.toString());
    System.out.println(peepo.toString());
    System.out.println(yejoo.toString());
    peepaw.grow(4);
    System.out.println(peepaw.toString());
    System.out.println(pepe.toString());
  }
}
