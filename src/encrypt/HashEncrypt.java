package encrypt;

public class HashEncrypt {
	/**
	 * encrypt the given parameter using SHA-1 algorithm
	 * @param x
	 * @return the encrypted 
	 * @throws Exception
	 */
	public static String encrypt (final String x) throws Exception{
		return byteArrayToHexString(computeHash(x));
	}
	
	/*
	 * @source : http://www.rgagnon.com/javadetails/java-0400.html
	 */
	public static byte[] computeHash(final String x)   throws Exception {
		java.security.MessageDigest d =null;
		d = java.security.MessageDigest.getInstance("SHA-1");
		d.reset();
		d.update(x.getBytes());
		return  d.digest();
	}
	
	/*
	 * @source : http://www.rgagnon.com/javadetails/java-0400.html
	 */
	public static String byteArrayToHexString(byte[] b){ 
		StringBuffer sb = new StringBuffer(b.length * 2); 
		for (int i = 0; i < b.length; i++){
			int v = b[i] & 0xff;
			if (v < 16) {
				sb.append('0');
			}
			sb.append(Integer.toHexString(v));
		} 
		return sb.toString().toUpperCase();
		
	}
}
