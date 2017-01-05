package dodatniRazredi;

public class MD5 {

	public static String kodirajMD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(kodirajMD5("Smart.Road"));
		//12d4228ed9d5da59315d870a37fb3b92
	}
	
}
