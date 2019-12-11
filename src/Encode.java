import java.math.BigInteger;

public class Encode {
	public BigInteger rsaFunction(BigInteger message, BigInteger key, BigInteger RSA) {
		BigInteger result = message.modPow(key, RSA);
		return result;
	}
	
	PaddingScheme pad;
	public Encode (PaddingScheme pad) {
		this.pad = pad;
	}
	public String encode(String message_s, String RSA_s, String publicKey_s) {
		BigInteger RSA= new BigInteger(RSA_s);
		BigInteger publicKey = new BigInteger(publicKey_s);
		String message_b = StringToBinary.stringToBinary(message_s);
		String message_b_p= pad.padding(message_b, 70);
		BigInteger message = new BigInteger(message_b_p,2);
		
		System.out.println(message_s+"\n"+message_b+"\n"+message_b_p+"\n"+message);
		
		BigInteger res = rsaFunction(message, publicKey, RSA);
		return res.toString();
	}
}
