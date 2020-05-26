package com.java.algirithm;

public class MaxGapBetweenTwoCharacter {
	
	public static int calculateGap(String str, char c, int index) {
		int gapcount = 0;
		for(int i=index; i<str.length(); i++) {
			if(str.charAt(i) == c) {
				return gapcount;
			}
			gapcount++;
		}
		return 0;
	}
	
	public static int findMaxGapBetweenCharacter(String str, char c) {
		String lstr = str.toLowerCase();
		int maxgap = 0;
		int nx = 0;
		c = Character.toLowerCase(c);
		for(int i=0; i<lstr.length(); i++) {
			if(lstr.charAt(i) == c) {
				int mg = calculateGap(lstr,c, (i+1));
				if(mg > maxgap) {
					nx = i + 1;
					maxgap = mg;
				}				
				i+=mg;
			}
		}
		System.out.println(str.substring(nx, nx+maxgap));
		return maxgap;
	}
	
	public static int[] RotateArrayKTimes(int[] A, int K) {
		if(A.length == 0 || A.length == 1) {
			return A; 
		}
		int n = A[0];
		int m = 0;
		for(int j=0; j<K; j++) {
			for(int i=0; i < (A.length -1); i++) {
				m = A[(i+1)];
				A[(i+1)] = n;
				n = m;
			}
			A[0] = m;
		}
		return A;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		String str = "ABCDEFABABCDERFaABACDEGHYUIKLaABBCDEFEETEYRYRJUUab";
		int gap = findMaxGapBetweenCharacter(str, 'A');
		System.out.println("Gap :" + gap);
		
		int A[] = new int[] {3,8,9,7,6};
		int K = 3;
		A = RotateArrayKTimes(A,K);
		for(int i : A)
			System.out.print(i);
	}

}
