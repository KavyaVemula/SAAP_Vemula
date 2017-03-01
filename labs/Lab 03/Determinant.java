/**
 * file: Determinant.java
 * author: Kavya Vemula
 * course: MSCS 630
 * assignment: Lab 3, Part 1
 * due date: March 1, 2017
 *
 * This file finds the determinant of the entered n*n matrix
 */
import java.util.Scanner;
public class Determinant
{
  static double det=0.0;
  static int modulo;
  public static void main(String[] args){
    Scanner sc= new Scanner(System.in);
    System.out.println("Enter the size of the square matrix(i.e., n)");
    int n= sc.nextInt();
    System.out.println("Enter the modulo");
    modulo= sc.nextInt();
    System.out.println("Enter the matrix elements");
    int Array[][]=new int[n][n];
    for(int i=0; i<n; i++){
      for(int j=0;j<n;j++){
        Array[i][j]= sc.nextInt();
      }
    }
    /** calculating modulo for the entered matrix elements */
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        Array[i][j]= Array[i][j]%modulo;
      }
    }
    int determinant= cofModDet(n, Array);
    System.out.println("The determinant is" +determinant);
  }
  /**
   * cofModDet
   *
   * This function finds the determinant of the matrix based on
   * number of rows of the entered matrix
   *
   * Parameters:
   *   n: Size of the matrix
   *   A: User entered Matrix
   *
   * Return value:
   *   Determinant of the matrix
   */
  public static int cofModDet(int n, int[][] A){
    if(n==1){
      return A[0][0];
    }
    else if(n==2){
      det= (A[0][0]*A[1][1]) - (A[0][1]*A[1][0]);
    }
    else if(n>2){
      for(int i=0;i<n;i++){
        int[][] subMatrix= new int[n-1][n-1];
        for(int j=1;j<n;j++){
          int k=0;
          for(int m=0;m<n;m++){
            if(m==i)
              continue;
            subMatrix[j-1][k] = A[j][m];
            k++;
          }
        }
        det = det + Math.pow(-1.0, 1.0+i+1.0)* A[0][i]*cofModDet(n-1, subMatrix);
      }
      //return (int)det;
    }
    return ((int)det)%modulo;
  }
}
