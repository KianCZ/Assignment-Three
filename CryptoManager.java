/*
 * Class: CMSC203 CRN 36406
 Program: Assignment 3
 Instructor: Farnaz Eivazi
 Summary of Description: Encrypts and decrypts text using two different methods
 Due Date: 3/23/2022
 Integrity Pledge: I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Kian Charkhabi
 */
public class CryptoManager {
	
	private static final char LOWER_BOUND = ' ';
	private static final char UPPER_BOUND = '_';
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		for(int i=0;i<plainText.length();i++) {
			if(plainText.charAt(i)>UPPER_BOUND||LOWER_BOUND>plainText.charAt(i)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String ns="";
		char t;
		int tn;
		for(int i=0;i<plainText.length();i++) {
			t=(char) (plainText.charAt(i)+key);
			tn=t;
			while(tn>UPPER_BOUND){
				tn=tn-RANGE;
			}
			t=(char) tn;
			ns+=t;
		}
		return ns;
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String ns="";
		int kyp=0,tn;
		for(int i=0;i<plainText.length();i++) {
			tn=plainText.charAt(i)+bellasoStr.charAt(kyp);
			while(tn>UPPER_BOUND) {
				tn-=RANGE;
			}
			ns+=(char) tn;
			kyp++;
			if(kyp>=bellasoStr.length()) {
				kyp=0;
			}
		}
		return ns;
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String ns="";
		char t;
		int tn,r;
		for(int i=0;i<encryptedText.length();i++) {
			r=key;
			while(r>RANGE) {
				r-=RANGE;
			}
			t=(char) (encryptedText.charAt(i)-r);
			tn=t;
			while(tn<LOWER_BOUND){
				tn=tn+RANGE;
			}
			t=(char) tn;
			ns+=t;
		}
		return ns;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String ns="";
		int kyp=0,tn;
		for(int i=0;i<encryptedText.length();i++) {
			tn=encryptedText.charAt(i)-bellasoStr.charAt(kyp);
			while(tn<LOWER_BOUND) {
				tn+=RANGE;
			}
			ns+=(char) tn;
			kyp++;
			if(kyp>=bellasoStr.length()) {
				kyp=0;
			}
		}
		return ns;
	}
}
