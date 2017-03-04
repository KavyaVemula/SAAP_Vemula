/**
 * file: ExtendedEuclidean.java
 * author: Kavya Vemula
 * course: MSCS 630
 * assignment: Lab 2, Part 2
 * due date: February 8, 2017
 *
 * This file calculates GCD based on extended euclidean algorithm,
 * that satisfies the equation d=ax+by
 */
import java.util.*;
class ExtendedEuclidean{
  static int count=0;
  static int[] input= new int[50];
  static int[] u = new int[3];
  static int[] v = new int[3];
  static int[] v1 = new int[3];
  static int[] w = new int[3];
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    //System.out.println("Enter the number of lines");
    //int lines= sc.nextInt();
    System.out.println("Enter the pair of digits for which you want to apply Euclidean Algorithm.");
    System.out.println("Press ctrl+c (for windows) or command+c (for mac) once you are done entering");
    while(sc.hasNext()){
      input[count]= sc.nextInt();
      count++;
    }
    for(int i=0;i<count-1;i+=2){
      euclidAlgExt(input[i],input[i+1]);
    }
  }
 /**
  * euclidAlgExt
  *
  * This function calculates values of d, x and y from equation d=ax+by
  * where d is the gcd of two numbers
  *
  * Parameters:
  *   input[]: Digits entered in each line
  *
  * Return value:
  *   GCD of the entered digits, x and y values that satisfy the equation
  */
  public static void euclidAlgExt(int a, int b){
    u[0]=a;
    u[1]=1;
    u[2]=0;
    v[0]=b;
    v[1]=0;
    v[2]=1;
    while(v[0]>0){
      double div=u[0]/ v[0];
      for(int i=0;i<3;i++){
        v1[i]=(int)div*v[i];
	//System.out.print(v[i]);
      }
      //System.out.println();
      for(int j=0;j<3;j++){
        w[j]= u[j] - v1[j];
	//System.out.print(w[j]);
      }
      //System.out.println();
      for(int i=0;i<3;i++){
        u[i] = v[i];
	//System.out.print(u[i]);
      }
      //System.out.println();
      for(int j=0;j<3;j++){
        v[j]= w[j];
	//System.out.print(v[j]);
      }
      //System.out.println();
    }
    System.out.println("d="+u[0]+" x="+u[1]+" y="+u[2]);
  }  
}
