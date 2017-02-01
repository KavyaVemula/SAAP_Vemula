import java.util.Scanner;
class Euclidean
{
	static int q1, r1;
	static int count=0;
	static int[] input= new int[50];
	public static void main(String[] args)
	{
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
			euclidAlg(input[i],input[i+1]);			
		}
    }
	public static void euclidAlg(int a, int b)
	{
		q1= a/b;
		r1= a%b;
		if(r1==0)
			System.out.println(b);
		else{
			a=b;
			b=r1;
			euclidAlg(a,b);
			}
		
	}
}