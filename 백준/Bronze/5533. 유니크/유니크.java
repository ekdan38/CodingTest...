import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[][] arr = new int[N][3];
		int[] score = new int[N];
		for(int i=0; i<N; i++) {
			arr[i][0] = scan.nextInt();
			arr[i][1] = scan.nextInt();
			arr[i][2] = scan.nextInt();
		}
		
		for(int i=0; i<N; i++) {	
			for(int j=0; j<3; j++) {	 
				boolean flag = true;
				
				for(int k=0; k<N; k++) { 
					if(i == k)	continue;	
					
					if(arr[i][j] == arr[k][j]) {
						flag = false;
						break;
					}
				}
				
				if(flag)
					score[i] += arr[i][j];
			}
		}
		
		for(int i=0; i<score.length; i++) {
			System.out.println(score[i]);
		}
		scan.close();
	}

}