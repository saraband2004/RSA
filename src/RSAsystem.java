import java.math.BigInteger;
import java.util.Random;

class RSAsystem{
	
	BigInteger RSA;
	private BigInteger RSA1;
	private BigInteger RSA2;
	BigInteger publicKey;
	public BigInteger privateKey;
	public BigInteger lambda;
	
	public BigInteger rsaFunction(BigInteger message, BigInteger key) {
		BigInteger result = message.modPow(key, RSA);
		return result;
	}
	public RSAsystem(BigPrimes bp) {
		String [] str = bp.getPrimes();
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
	public BigInteger[] publicKeyGenerator() {
		publicKey = BigInteger.valueOf(new Random().nextInt(100000));
		while (!publicKeyVerify(publicKey)) {
			publicKey = BigInteger.valueOf(new Random().nextInt(100000));
			System.out.println("LOL");
		}
		return new BigInteger[] {RSA, publicKey};
	}
	public BigInteger privateKeyGenerator(BigInteger publicKey) {
		BigInteger key =
				publicKey.modInverse(lambda);
		return key;
	}
}