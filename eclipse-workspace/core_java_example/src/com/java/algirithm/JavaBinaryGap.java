package com.java.algirithm;

public class JavaBinaryGap {

	public String convertToBinary(int N) {
		int a = 0;
		String bin = "";
		while (N > 0) {
			a = N % 2;
			bin = a + "" + bin;
			N = N / 2;
		}
		System.out.println(bin);
		return bin;
	}
	public int getBinGap(int i, String b) {
		int c = 0;
		boolean of = false;
		for (int j = i; j < b.length(); j++) {
			if (b.charAt(j) == '1') {
				of = true;
				break;
			}
			c++;
		}
		if (of) {
			return c;
		}
		return 0;
	}
	
	public int getMaxBinaryGap(int N) {
		String bin = convertToBinary(N);
		int maxBinGap = 0;

		for (int i = 0; i < bin.length(); i++) {
			// System.out.println("i :" + i);
			if (bin.charAt(i) == '1') {
				int m = getBinGap(++i, bin);
				// System.out.println(m);
				if (m > maxBinGap) {
					maxBinGap = m;
				}
				i += m - 1;
			}

		}
		return maxBinGap;
	}

	public static void main(String args[]) {

		JavaBinaryGap jbg = new JavaBinaryGap();
		int binaryGap = jbg.getMaxBinaryGap(558900);
		System.out.println("Max Gap :" + binaryGap);

	}

}
