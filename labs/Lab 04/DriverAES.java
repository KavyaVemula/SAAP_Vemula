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
  static String inHex;
  public static void main(String[] args) {
    AESCipher aes= new AESCipher();
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the System Key");
    boolean flag=true;
    do {
      inHex = sc.next();
      if(inHex!="" && inHex!=null && inHex.length()==32) {
        aes.aesRoundKeys(inHex);
      }
      else {
        System.out.println("Enter a valid key");
        flag= false;
      }
    }while(!flag);
  }
}
