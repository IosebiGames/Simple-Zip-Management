package main;

public class Main {
	public static void main(String[] args) {
		ZipManager zm = new ZipManager("ZipFile.zip");
        zm.add("/path/content.txt");
		zm.extractZip("content.txt", "/src/destination");
		
		// Parameters:
		// createZip(content file)
		// extractZip(content file path inside of zip, destination of package where content file should be extracted)
		// ex: creteZip("/src/MyFile.txt");
		// ex: extractZip("MyFile.txt", "/src/destionation");
        // in this case you can relay on file Path system in IDE as long as you are not working on something big.
	}
}
