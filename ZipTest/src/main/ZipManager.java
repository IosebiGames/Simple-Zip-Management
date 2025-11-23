package main;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.File;
import java.io.IOException;

public class ZipManager {

	private ZipFile zf;
	private File f;
	
	public ZipManager(String path) {
        f = new File(path);
        zf = new ZipFile(f);
	}
	// creates a Zip file with content in it.
	public void add(String content) {
		try {
			zf.addFile(new File(content));
			try {
				zf.close();
			}catch(IOException _) {
			}
		}catch(ZipException e) {
			System.out.println("Failed to create Zip: " + e.getMessage());
		}
	}
	// extracts certain content from the Zip file into another package or destination path.
	public void extractZip(String fileName, String destination) {
	    try {
	    	zf.extractFile(fileName, destination);
	    	try {
	           zf.close(); 		
	    	}catch(IOException _) {
	       }
	      }catch(ZipException e) {
	    	 e.printStackTrace();
	    }
	}
	// removes specific content/file from the Zip file 
	public void removeFile(String path) {
		try {
			zf.removeFile(path);
		}catch(ZipException e) {
             System.out.println("Failed to remove a content from the Zip File: " + e.getMessage());			
		}
	}
	// sets Password for zip File (not working properly)
	private void setPassword(char[] c) {
	     zf.setPassword(c);
	}
}
