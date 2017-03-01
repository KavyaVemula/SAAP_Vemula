/**
 * file: ASCIIMatrix.java
 * author: Kavya Vemula
 * course: MSCS 630
 * assignment: Lab 3, Part 2
 * due date: March 1, 2017
 *
 * This file finds the 4*4 matrix that contains the ASCII values of the entered plain text
 */

import java.util.Scanner;
public class ASCIIMatrix{

  static String substitute;
  static int[] Plain= new int[100];
  static String[] PlainText= new String[100];
  static String[][] result= new String[4][4];

  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the substitution character");
    char sub= sc.next().charAt(0);
    /** finding the ASCII value of the substitution character */
    int subChar= (int)sub;
    substitute= Integer.toHexString(subChar).toUpperCase();

    sc= new Scanner(System.in);
    System.out.println("Enter the Plain Text");
    String text= sc.nextLine();
    int len= text.length();
    int remain=0;
    /**
     * checking if length of the text equals 16
     * If the length is not equal to 16, increasing the length with the
     * nearest number so that it becomes a multiple of 16
     */
    if(len%16 != 0){
      remain= 16-(len%16);
      len= len+remain;
    }
    /** adding substituion character to the text to match with the length */
    while(remain>0){
      text=text+sub;
      --remain;
    }
    //System.out.println(len);
    //System.out.println(text);
    int a=15;
    int start=0;
    int end=16;
    /** loop to generate 4*4 matrix that contains all the Plain text elements */
    while(len>0){
      result= getHexMatP(substitute, text.substring(start,end));
      /** printing the matrix */
      for(int i=0; i<4; i++){
        for(int j=0; j<4; j++){
          System.out.print(result[i][j]+" ");
        }
        System.out.println();
      }
      start+= 16;
      end+=16;
      System.out.println();
      len=len-16;
    }
  }

	/**
   * getHexMatP
   *
   * This function converts the Plain Text to its corresponding ASCII values
   * and generates a hexadecimal 4*4 matrix. It replaces the empty spaces with
   * the user entered substitution character
   * Parameters:
   *   s: substitution character
   *   p: plain text
   *
   * Return value:
   *   4*4 string matrix containing the corresponding ASCII values of
   *   the Plain Text
   */
  public static String[][] getHexMatP(String s, String p){
    String[][] matrix= new String[4][4];
    for(int i=0;i<p.length();i++){
      Plain[i]= (int)(p.charAt(i));
      PlainText[i]= Integer.toHexString(Plain[i]).toUpperCase();
    }
    int len= PlainText.length;
    int flag=0;
    for(int i=0; i<4; i++){
      for(int j=0; j<4; j++){
        if(PlainText[flag] != null){
          matrix[j][i]= PlainText[flag];
          flag++;
        }
        else{
          matrix[j][i]= s;
          flag++;
        }

      }
    }
    return matrix;
  }
}  
