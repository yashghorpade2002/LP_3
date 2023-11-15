package DAA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci_Numbers {

	public static int fib(int n) {
		
		if(n <= 1)
			return n;
		else
			return fib(n-1) + fib(n-2);
		
	}
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n;
		System.out.println("Enter number of terms to generate: ");
		n = Integer.parseInt(br.readLine());
				
		int first = 0;
		int second = 1;
		int sum = 0;
		
		System.out.println("Fibonacci series implementation without recurrsion :");
		
		for(int i=0; i<n; i++) {
			
			System.out.println(first + " ");
			
			sum = first + second;
			first = second;
			second = sum;
			
		}
		
		System.out.println("Fibonacci series implementation with recurrsion :");

		for(int j=0; j<n; j++) {
			
			System.out.println(fib(j)+ " ");
		}
		
	}
}
