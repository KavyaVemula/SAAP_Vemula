/**
 * file: Encryption.java
 * author: Kavya Vemula
 * course: MSCS 630
 * assignment: Lab 1
 * due date: January 25, 2017
 *
 * This file encrypts the input string
 * and returns corresponding integer values
 */

import java.io.*;
public class Encryption {
  static char ALPHABETS[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};
  static int NUMERICALS[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26};
  public static void main(String[] args)throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    System.out.println("Enter number of lines");
    int lines= Integer.parseInt(br.readLine());
    String[] input= new String[50];                              //Array that stores each line at each index position
    for(int i=1; i<=lines; i++){                                 //Accepting input for each line separately and storing it in an array at different index positions
      System.out.println("Enter line " +i);
      input[i]=br.readLine();
    }
    for(int i=1;i<=lines;i++){
      CharExtract(input[i]);                                      //Extracting one line at a time and passing it as parameter to the next function
      System.out.println("\n");
    }
  }
  /**
   * CharExtract
   *
   * This function extracts all the characters from
   * each given line individually and this extracted character
   * is sent as a parameter to the next function.
   *
   * Parameters:
   *   text: Words in a line
   *
   * Return value:
   *   Individual characters returned iteratively.
   */
  public static void CharExtract(String text){
    for (int i=0; i<text.length();i++){
      char n= text.charAt(i);
      str2int(n);
    }
  }
  /**
   * str2int
   *
   * This function converts the given input character into
   * its respective integer value and prints its value.
   *
   * Parameters:
   *   x: Character that is extracted iteratively from different words in a line
   *
   * Return Value:
   *   Corresponding integer value
   */
  public static void str2int(char x){
    int i;
    for(i=0;i<27;i++)
      if(x==ALPHABETS[i]){
        int flag=NUMERICALS[i];
        System.out.print(flag + " ");
      }
  }
}
