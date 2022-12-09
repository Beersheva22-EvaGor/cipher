package telran.cipher;

import java.util.Arrays;

public class BaseCipher {

	private String key;

	private static final int valueMin = 33;
	private static final int valueMax = 126;

	private static final int lengthMin = 2;
	private static final int lengthMax = 93;

	public BaseCipher(int length) {
		// creates the key as String of the random values of ASCII codes from 33 to 126
		key = "";
		int lengthReal = length;
		if (length < lengthMin) {
			lengthReal = lengthMin;
		}
		if (length > lengthMax) {
			lengthReal = lengthMax;
		}
		int[] temparr = new int[valueMax - valueMin + 1];
		int i = 0;
		while (i < lengthReal) {
			int tempnum = getRandomNumber(valueMin, valueMax);
			if (temparr[tempnum - valueMin] != 1) {
				key += (char) tempnum;
				temparr[tempnum - valueMin] = 1;
				i++;
			}
		}
	}

	public String cipher(int number) {
		StringBuilder res = new StringBuilder("");		
		int base = key.length();
		while (number > base) {
			res.insert(0,key.charAt(number % base));
			number = number / base;
		}
		res.insert(0,key.charAt(number));
		return res.toString();
	}

	public int decipher(String cipher) {
		int res = 0;
		int base = key.length();
		int cipherlength = cipher.length();
		int index =0;
		while (index<cipherlength) {
			res += Math.pow(base, index)*key.indexOf(cipher.charAt(cipherlength-index-1));
			index++;
		}
		return res;
	}

	private static int getRandomNumber(long min, long max) {
		return (int) (min + Math.random() * (max - min + 1));
	}

}
