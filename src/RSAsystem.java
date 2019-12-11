import java.math.BigInteger;
import java.util.Random;

class RSAsystem{
	
	public BigInteger RSA;
	public BigInteger publicKey;
	public BigInteger lambda;
	private BigInteger RSA1;
	private BigInteger RSA2;
	private BigInteger privateKey;
	public PaddingScheme pad;
	
	public BigInteger rsaFunction(BigInteger message, BigInteger key) {
		BigInteger result = message.modPow(key, RSA);
		return result;
	}
	
	public RSAsystem(BigPrimes bp, PaddingScheme pad) {
		String [] str = bp.getPrimes();
		this.pad = pad;
		RSA1 = new BigInteger(str[0]);
		RSA2 = new BigInteger(str[1]);
		
		RSA = RSA1.multiply(RSA2);
		lambda = ((RSA1.add(new BigInteger("-1"))).multiply(RSA2.add(new BigInteger("-1")))).divide((RSA1.add(new BigInteger("-1"))).gcd(RSA2.add(new BigInteger("-1"))));
	}
	
	public boolean publicKeyVerify(BigInteger key) {
		if (lambda.gcd(key).compareTo(BigInteger.valueOf(1))==0){
			return true;
		}
		return false;
	}
	public BigInteger random() {
		int len = RSA.toString(2).length();
		String s = "1";
		Random rng = new Random();
		while ( -- len > 2) {
			if (rng.nextInt(2) == 0) {
				s = "0"+ s;
			}
			else s = "1" + s;			
		}
		return new BigInteger(s, 2);
	}
	
	
	public String[] publicKeyGenerator() {
		publicKey = random();
		while (!publicKeyVerify(publicKey)) {
			publicKey = random();
			//System.out.println("LOL");
		}
		//System.out.println(publicKey);
		privateKeyGenerator(publicKey);
		//System.out.println(privateKey);
		return new String[] {RSA.toString(), publicKey.toString()};
	}
	
	private BigInteger privateKeyGenerator(BigInteger publicKey) {
		BigInteger key =
				publicKey.modInverse(lambda);
		this.privateKey = key;
		return key;
	}
	
	public String decode (String message_s) {
		BigInteger message = new BigInteger(message_s);
		BigInteger message_de = rsaFunction(message, privateKey);
		String str = message_de.toString(2);
		str = pad.unpadding(str);
		return StringToBinary.binaryToString(str);		
	}		
}