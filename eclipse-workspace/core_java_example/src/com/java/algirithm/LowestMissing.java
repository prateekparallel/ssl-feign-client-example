package com.java.algirithm;

public class LowestMissing {

	public boolean find(int[] A, int n) {
	      for (int i : A ){
	        if(n == i ){
	          return true;
	        }
	      }
	     return false;
	   }


	   public int findLowest(int[] A){
	      int l = A[0];
	      for (int i : A ){
	        if(l > i ){
	          l = i;
	        }
	        System.out.println(i);
	       }
	     return l;
	   }

	    public int solution(int[] A) {
	       int l = findLowest(A);
	        for(int i = 0; i <= A.length; i++){
	        ++l;
	        if(l == 0) ++l;
	        if(find(A, l))
	        	continue;
	        else {
	        	if (i < A.length)
	        		return l;
	        	else
	        		return l++;
	        }
	        	
	       }
	       return 0;
	    }

	   

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int [] A = {-1,-2,-3,1};
	     LowestMissing sol = new LowestMissing();
	     System.out.println("Result :" + sol.solution(A));

	}

}
