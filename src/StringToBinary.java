 

public class StringToBinary{
	
	public static String stringToBinary(String s) {
		char[] c = new char[s.length() * 8];
		char[] cc= s.toCharArray();
		for (int i=0; i<cc.length ; i++) {
			int temp = (int)cc[i];
			c[8*i + 7] =(char)( temp%2 + (int)'0'); temp/=2;
			c[8*i + 6] =(char)( temp%2 + (int)'0'); temp/=2;
			c[8*i + 5] =(char)( temp%2 + (int)'0'); temp/=2;
			c[8*i + 4] =(char)( temp%2 + (int)'0'); temp/=2;
			c[8*i + 3] =(char)( temp%2 + (int)'0'); temp/=2;
			c[8*i + 2] =(char)( temp%2 + (int)'0'); temp/=2;
			c[8*i + 1] =(char)( temp%2 + (int)'0'); temp/=2;
			c[8*i + 0] =(char)( temp%2 + (int)'0'); temp/=2;
		}
		return new String(c);
	} 
	
	public static String binaryToString(String s) {
		char[] c = s.toCharArray();
		char[] cc = new char[s.length() / 8];
		for (int i=0; i<c.length ; i+=8) {
			int temp = 0;
			if (c[i] == '1') temp+= 1;
			temp*= 2;
			if (c[i +1] == '1') temp+= 1;
			temp*= 2;
			if (c[i+2] == '1') temp+= 1;
			temp*= 2;
			if (c[i+3] == '1') temp+= 1;
			temp*= 2;
			if (c[i+4] == '1') temp+= 1;
			temp*= 2;
			if (c[i+5] == '1') temp+= 1;
			temp*= 2;
			if (c[i+6] == '1') temp+= 1;
			temp*= 2;
			if (c[i+7] == '1') temp+= 1;
			
			cc[i/8] = (char) temp;
		}
		return new String(cc);
	}
}
