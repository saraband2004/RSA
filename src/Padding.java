

interface PaddingScheme{
	public String padding(String s, int length) ;
	public String unpadding(String s) ;
}




public class Padding implements PaddingScheme {
	public String padding(String s, int length) {
		StringBuilder sb = new StringBuilder(s);
		//if (s.length() >= length) return null;
		sb.append('1');
		while (sb.length() < length) {
			sb.append('0');
		}
		return new String(sb);
	}
	
	public String unpadding(String s) {
		StringBuilder sb = new StringBuilder(s);
		while(sb.charAt(sb.length() - 1) =='0') {
			sb.deleteCharAt(sb.length() - 1);
		}
		sb.deleteCharAt(sb.length() - 1);
		return new String(sb);
	}
}
