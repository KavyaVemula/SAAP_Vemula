/**
 * file: DriverAES.java
 * author: Kavya Vemula
 * course: MSCS 630
 * assignment: Lab 4
 * due date: April 5, 2017
 *
 * This file accepts the input from User
 * and passes this input to aesRoundKeys function as
 * a parameter to generate the Round Keys.
 */
import java.util.Scanner;

class DriverAES
{
  static String inputKey;
  static String inputPlainText;
  public static void main(String[] args) {
    AESCipher aes= new AESCipher();
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the System Key and plain text");
    if(sc.hasNext()) {
      inputKey = sc.nextLine();
    }
    else {
      System.out.println("Input Key noe found");
      System.exit(0);
    }
    if(sc.hasNext()) {
      inputPlainText = sc.nextLine();
    }
    else {
      System.out.println("Input Text not found");
      System.exit(0);
    }

    if(inputKey.length()==32 && inputPlainText.length()==32) {
      aes.aes(inputKey, inputPlainText);
    }
    else {
      System.out.println("Enter a valid key");
    }
  }
}
