package main;

public class Main {
	public static void main(String[] args) {
		ZipManager zm = new ZipManager("ZipFile.zip");
	    zm.add("C:\\Users\\IosebiGames\\eclipse-workspace\\ZipTest\\src\\content\\myFile.txt");
        zm.setPassword(new char[] {'A', 'B','C', '1', '2', '3'});
   }
}
