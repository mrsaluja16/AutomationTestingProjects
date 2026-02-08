package java.Encryption.Decryption;

import org.apache.commons.codec.binary.Base64;

public class Base64EncryptionDecryption {
	
	public static void main(String [] args) {
		new Base64EncryptionDecryption().encryptData("Ranjit");
		new Base64EncryptionDecryption().decryptData("UmFuaml0");
		
	}
	
	public String encryptData(String data) {
		System.out.println("Printing Original value : "+data);
		String val = encryptOrDecryptVal(data, "Encrypt");
		System.out.println("Printing Encrypted data : "+val);
		return val;
	}

	
	public String decryptData(String data) {
		//System.out.println("Printing Original value : "+data);
		String val = encryptOrDecryptVal(data, "Decrypt");
		System.out.println("Printing Decrypted data : "+val);
		return val;
	}
	
	private String encryptOrDecryptVal(String data, String encOrDec) {
		String val = "";
		if(encOrDec.equals("Encrypt")) {
			byte[] byteData = Base64.encodeBase64(data.getBytes());
			val = new String(byteData);
		}
		if(encOrDec.equals("Decrypt")) {
			byte[] byteData = Base64.decodeBase64(data.getBytes());
			val = new String(byteData);
		}
		return val;
	}
}
