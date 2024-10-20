import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int mod = 1000000000;
		
		int[][] Dp = new int [N+1][10]; 
		
		for(int i=0;i<=9;i++) {
			Dp[1][i] = 1; //1자리 계단 수 
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=9;j++) {
				if(j==0) { //0으로 시작하는 계단 수
					Dp[i][j]=Dp[i-1][1]%mod;
				}
				else if(j==9) { //9로 시작하는 계단 수
					Dp[i][j]=Dp[i-1][8]%mod;
				}
				else { //2 ~ 8 로 시작하는 계단 수
					Dp[i][j]=(Dp[i-1][j-1]%mod+Dp[i-1][j+1]%mod)%mod;
				}
			}
		}
		int sum =0;
		for(int i=1;i<=9;i++) {// i는 1부터 시작! 0으로 시작하는 경우의 수 까지 더해주면 안됨!!
			sum+=Dp[N][i]; //N자리 1~9로 시작하는 경우의 수를 다 합하면 됨.
            			  
			sum%=mod;
		}
		System.out.println(sum%mod);
	}
}