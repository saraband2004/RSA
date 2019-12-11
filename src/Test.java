import java.io.*; 
import java.util.*; 
import java.lang.*;
import java.math.BigInteger; 


public class Test {
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
		int sum = 0;	
		for (int i=0; i<1000; i++) {
		
		Padding pad = new Padding();
		Encode encoder = new Encode(pad);
		RSAsystem rsa = new RSAsystem(new BigPrimesFactory(), pad);
		
		String[] str= rsa.publicKeyGenerator();
	//	System.out.println(str[0]+"\n" +str[1]);
		String RSA = str[0];
		String key = str[1];
		
		String origin = "The quick brown fox jumps over the lazy dog";
		String encry_message = encoder.encode(origin, RSA, key);
		//System.out.println(encry_message);
	
		BigInteger bg = new BigInteger (encry_message);

		if (rsa.decode(encry_message).compareTo(origin)!=0) sum++;
		
		}
		System.out.println(sum);
	}
}
