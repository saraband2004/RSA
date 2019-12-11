import java.io.*; 
import java.util.*; 
import java.lang.*;
import java.math.BigInteger; 


public class Test {
 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.print("aaa");
			
		
		
		Padding pad = new Padding();
		Encode encoder = new Encode(pad);
		RSAsystem rsa = new RSAsystem(new BigPrimesFactory(), pad);
		
		String[] str= rsa.publicKeyGenerator();
	//	System.out.println(str[0]+"\n" +str[1]);
		String RSA = str[0];
		String key = str[1];
		
		String encry_message = encoder.encode("abBdefghijkl\n12567()*%#$@^&*~`\'\" 	\n-_+=a", RSA, key);
		System.out.println(encry_message);
	
		BigInteger bg = new BigInteger (encry_message);
	//	System.out.println(rsa.rsaFunction(bg, rsa.privateKey));
		System.out.println(rsa.decode(encry_message));
	}
}
