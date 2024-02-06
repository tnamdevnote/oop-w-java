package hw06;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Clinic {
  private File patientFile;
  private int day;

  public Clinic(File file) {
    this.patientFile = file;
    this.day = 1;
  }

  public Clinic(String fileName) {
    this(new File(fileName));
  }

  public String nextDay(File f) throws FileNotFoundException {
    day++;
    Scanner fileScan = new Scanner(f);
    Scanner input = new Scanner(System.in);
    String line = null;
    String output = "";
    
    while(fileScan.hasNextLine()) {
      line = fileScan.nextLine();
      String[] tokens = line.split(",");
      String name = tokens[0];
      String typeOfPet = tokens[1];
      String stat = tokens[2];
      String timeIn = tokens[3];
      
      System.out.printf("Consultation for %s the %s at %s. \nWhatis the health of %s?\n",
      name, typeOfPet, timeIn, name);
      
      if (!(typeOfPet.equals("Dog")|| typeOfPet.equals("Cat"))) {
        throw new InvalidPetException();
      }

      double health = 0;
      int painLevel = 0;
      boolean validHealth = false;
      boolean validPain = false;
      while(!validHealth) {
        if (input.hasNextDouble()) {
          health = input.nextDouble();
          validHealth = true;
        } else {
          input.nextLine();
          System.out.print("Please enter a number: ");
        }
      }

      System.out.printf("On a scale of 1 to 10, how much pain is %s in right now?\n", name);
      while(!validPain) {
        if (input.hasNextInt()) {
          painLevel = input.nextInt();
          validPain = true;
        } else {
          input.nextLine();
          System.out.print("Please enter a number: ");
        }
      }

      Pet petInstance;
      if (typeOfPet.equals("Dog")) {
        petInstance = new Dog(name, health, painLevel, Double.parseDouble(stat));
      } else if (typeOfPet.equals("Cat")) {
        petInstance = new Cat(name, health, painLevel, Integer.parseInt(stat));
      } else {
        throw new InvalidPetException();
      }

      health = petInstance.getHealth();
      painLevel = petInstance.getPainLevel();
      petInstance.speak();
      int treatmentTime = petInstance.treat();
      String timeOut = addTime(timeIn, treatmentTime);
      output += String.format("%s,%s,%s,Day %d,%s,%s,%s,%d\n", name, typeOfPet, stat, day, timeIn, timeOut, String.valueOf(health), painLevel);
    }
    fileScan.close();
    input.close();
    return output.trim();
  }

  public String nextDay(String fileName) throws FileNotFoundException {
    return nextDay(new File(fileName));
  }

  public boolean addToFile(String patientInfo) {
    Scanner fileScan = null;
    PrintWriter filePrint = null;
    String stringOutput = "";
    
    try {
      fileScan = new Scanner(patientFile);

      boolean newPatient = true;
      int firstDelimiter = patientInfo.indexOf(",");
      String name = patientInfo.substring(0, firstDelimiter);

      while (fileScan.hasNextLine()) {
        String line = fileScan.nextLine();
        if (line.startsWith(name)) {
          newPatient = false;
          int currentDelim = firstDelimiter;
          for (int i = 2; i <= 3; i++) {
            int nextDelim = patientInfo.indexOf(",", currentDelim + 1);
            currentDelim = nextDelim;
          }
          line += patientInfo.substring(currentDelim);
        }
        stringOutput += (line + "\n");
      }

      if (newPatient) {
        stringOutput += patientInfo;
      }

      fileScan.close();
      filePrint = new PrintWriter(patientFile);
      filePrint.print(stringOutput);
      return true; 
    } catch(Exception e) {
      return false;
    } finally {
      if (fileScan != null) {
        fileScan.close();
      }
      if (filePrint != null) {
        filePrint.close();
      }
    }
  }

  private String addTime(String timeIn, int treatmentTime) {
    int hours = Integer.parseInt(timeIn.substring(0,2));
    int minutes = Integer.parseInt(timeIn.substring(2));
    int hourOut = hours + (int)((minutes + treatmentTime) / 60);
    int minOut = (minutes + treatmentTime) % 60;

    String output = "";
    output += (hourOut < 10) ? ("0" + hourOut) : hourOut;
    output += (minOut < 10) ? ("0" + minOut) : minOut;
    return output;
  }
}
