package telran.cipher.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.cipher.BaseCipher;

class CipherTest {

	@Test
	void baseCipherTest() {
		int number = 123;		
		BaseCipher cipherbase = new BaseCipher(2);
		String cipher = cipherbase.cipher(number);
		int decipher = cipherbase.decipher(cipher);
		System.out.println("CIPHER: \t" + cipher);
		System.out.println("DECIPHER: \t" + decipher);
		assertEquals(number, decipher);
		
		cipherbase = new BaseCipher(8);		// same number - another base
		cipher = cipherbase.cipher(number);
		decipher = cipherbase.decipher(cipher);
		assertEquals(number, decipher);
		
		// checking border conditions
		cipherbase = new BaseCipher(0);	// left border of a key length
		cipher = cipherbase.cipher(number);
		decipher = cipherbase.decipher(cipher);
		assertEquals(number, decipher);
		
		number = 1231231231;
		cipherbase = new BaseCipher(100);	// right border of a key length
		cipher = cipherbase.cipher(number);
		decipher = cipherbase.decipher(cipher);
		assertEquals(number, decipher);
		
		number = 93;
		cipherbase = new BaseCipher(93);	// Yuri's example
		cipher = cipherbase.cipher(number);
		decipher = cipherbase.decipher(cipher);
		assertEquals(number, decipher);
	}

}
