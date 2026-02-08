package java.Encryption.Decryption;



public class CustomEncryptionDecryptionExample 
{
	public static void main(String [] args) {
		new CustomEncryptionDecryptionExample().getEncryptedData("RanjitSingh");
		new CustomEncryptionDecryptionExample().getDecryptedData("Yhuqp{Zpuno");
	}
	
	public String getEncryptedData(String data) {
		System.out.println("Originall Value is : "+data);
		String val = encryptOrDecryptVal(data, "Encrypt");
		System.out.println("Encrypted Value is : "+val);
		return val;
	}
	
	public String getDecryptedData(String data) {
		//System.out.println("Original Value is : "+data);
		String val = encryptOrDecryptVal(data, "Decrypt");
		System.out.println("Decrypted Value is : "+val);
		return val;
	}
	
	private String encryptOrDecryptVal(String data, String encOrDec) {
		int key = 7;
		String encrypt = "";
		String decrypt = "";
		String valueReturned = "";
		
		if(encOrDec.equals("Encrypt")) {
			for(int i=0; i<data.length(); i++) {
				char ch = data.charAt(i);
				ch += key;
				encrypt = encrypt+ch;
			}
			valueReturned = encrypt;
		}
		
		if(encOrDec.equals("Decrypt")) {
				for(int i=0; i<data.length(); i++) {
					char ch = data.charAt(i);
					ch -= key;
					decrypt = decrypt+ch;
				}
				valueReturned = decrypt;
			}
		
		return valueReturned;
	}
	
	
	
}
