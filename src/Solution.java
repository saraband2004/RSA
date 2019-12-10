import java.io.*; 
import java.util.*; 
import java.lang.*;
import java.math.BigInteger; 


public class Solution {
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
			
		RSAsystem s = new RSAsystem(new BigPrimesFactory());
		BigInteger publicKey = new BigInteger("1111111111111", 2);
		System.out.println(Padding.unpadding(Padding.padding("a12341asdf", 15)));
		System.out.println((StringToBinary.stringToBinary("0123")));
		System.out.println(StringToBinary.binaryToString(StringToBinary.stringToBinary("abcdefg")));
		
		s.publicKeyGenerator();
		System.out.println(s.publicKey);
	}

}
