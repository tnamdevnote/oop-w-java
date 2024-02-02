package hw05;

public class Gameplay {

  public static void printString(Player p) {
      System.out.println(p.toString());
  }
  public static void main(String[] args) {
    System.out.println("----------- Game Start -----------");
    BlueAstronaut bob = new BlueAstronaut("Bob", 20, 6, 30);
    printString(bob);
    BlueAstronaut heath = new BlueAstronaut("Heath", 30, 3, 21);
    printString(heath);
    BlueAstronaut albert = new BlueAstronaut("Albert", 44, 2, 0);
    printString(albert);
    BlueAstronaut angel = new BlueAstronaut("Angel", 0, 1, 0);
    printString(angel);
    RedAstronaut liam = new RedAstronaut("Liam", 19, "experienced");
    printString(liam);
    RedAstronaut susPerson = new RedAstronaut("Suspicious Person", 100, "expert");
    printString(susPerson);

    System.out.println("----------- 1. Have RedAstronaut Liam sabotage BlueAstronaut Bob ----------- \n");
    liam.sabotage(bob);
    printString(bob);
    
    System.out.println("----------- 2. Have RedAstronaut Liam freeze RedAstronaut Suspicious Person ----------- \n");
    liam.freeze(susPerson);
    System.out.println(liam.getSusLevel());
    System.out.println(susPerson.isFrozen());
    
    System.out.println("----------- 3. Have RedAstronaut Liam freeze BlueAstronaut Albert. After the freeze ----------- \n");
    liam.freeze(albert);
    System.out.println(albert.isFrozen());

    System.out.println("----------- 4. Have BlueAstronaut Albert call an emergency meeting ----------- \n");
    albert.emergencyMeeting();
    printString(albert);

    System.out.println("----------- 5. Have RedAstronaut Suspicious Person call an emergency meeting ----------- \n");
    susPerson.emergencyMeeting();
    printString(heath);
    printString(bob);

    System.out.println("----------- 6. Have BlueAstronaut Bob call an emergency meeting ----------- \n");
    bob.emergencyMeeting();
    printString(susPerson);
    
    System.out.println("----------- 7. Have BlueAstronaut Heath complete tasks ----------- \n");
    heath.completeTask();
    System.out.println(heath.getNumTasks());
    
    System.out.println("----------- 8. Have BlueAstronaut Heath complete tasks ----------- \n");
    heath.completeTask();
    System.out.println(heath.getNumTasks());
    System.out.println(heath.getSusLevel());
    
    System.out.println("----------- 9. Have BlueAstronaut Heath complete tasks ----------- \n");
    heath.completeTask();
    System.out.println(heath.getNumTasks());
    System.out.println(heath.getSusLevel());
    
    System.out.println("----------- 10. Have RedAstronaut Liam freeze Angel ----------- \n");
    liam.freeze(angel);
    printString(angel);
    printString(liam);

    System.out.println("----------- 11. Have RedAstronaut Liam sabotage Bob twice ----------- \n");
    printString(bob);
    liam.sabotage(bob);
    printString(bob);
    liam.sabotage(bob);
    printString(bob);
    
    System.out.println("----------- 12. Have RedAstronaut Liam freeze Bob ----------- \n");
    liam.freeze(bob);
    printString(bob);
    

    System.out.println("----------- 13. Have BlueAstronaut Angel call emergency meeting ----------- \n");
    angel.emergencyMeeting();
    printString(liam);

    // System.out.println("----------- 14. Have RedAstronaut Liam call sabotage on Heath 5 times -----------");
    // printString(heath);
    // liam.sabotage(heath);
    // printString(heath);
    // liam.sabotage(heath);
    // printString(heath);
    // liam.sabotage(heath);
    // printString(heath);
    // liam.sabotage(heath);
    // printString(heath);
    // liam.sabotage(heath);
    // printString(heath);
    
    // System.out.println("----------- 15. Have RedAstronaut Liam freeze Heath -----------");
    // liam.freeze(heath);
    // printString(heath);

  }
}
