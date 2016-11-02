import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;

public class Derp {
	public static void main(String[] arg){
		try {
			//Read in password
			String password = arg[0];
			System.out.println("The password: " + password);
			//Covert password to sha1 hash
			byte[] shaHash = sha1(password);
			//open exe file
			RandomAccessFile exe = new RandomAccessFile("/home/hams/Desktop/assignment3/Task4/Part3/32007122.program2.exe", "rw");
			//go to offset where password is stored
			int offset = 0x0001E012; 
			exe.seek(offset);
			//replace 20 bytes, aka 40 chars of hash
			exe.write(shaHash);
			//save and close file
			exe.close();
			System.out.println("Password Changed!");
		} catch(IOException e) {
			System.out.println(e);
		}
		
	}

	static byte[] sha1(String input) {
		try {
			MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        	byte[] result = mDigest.digest(input.getBytes());
        	
        	return result;
		} catch(NoSuchAlgorithmException e) {
			System.out.println(e);
		}
        return null;
    }
}
