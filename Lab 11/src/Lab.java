import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;



/*
 *
 *
 *CS 2003 Lab 11
 *@author Kasey Mills
 *
 */

public class Lab {

	public void fileDelete() throws IOException {

		Path p1 = Paths.get("D:\\University of Tulsa\\FA 2017 Algorthims\\Lab\\Lab11\\Backup\\SPEED\\SPEED_20171102_1of10.txt");
		
		File curDir = new File("D:\\University of Tulsa\\FA 2017 Algorthims\\Lab\\Lab11\\Backup\\SPEED");
		File[] filesList = curDir.listFiles();

		PathMatcher match = FileSystems.getDefault().getPathMatcher("glob:*.txt*");

		for (int i = 0; i < filesList.length; i++) {
			if (match.matches(Paths.get(filesList[i].getPath()).getFileName()))
				System.out.println("Remaining: " + Paths.get(filesList[i].getPath()));
			else {
				System.out.println("Deleted: " + Paths.get(filesList[i].getPath()));
				Files.delete(Paths.get(filesList[i].getPath()));
			}

		}
	}

	public void fileCheck() {
		File curDir = new File("D:\\University of Tulsa\\FA 2017 Algorthims\\Lab\\Lab11\\Backup\\APOLLO");
		File[] filesList = curDir.listFiles();
		Path filename = Paths.get(filesList[0].getPath()).getFileName();
		System.out.println(filesList.length + "file");
	}

	public static void main(String[] args) throws IOException {
		Lab file = new Lab();
		file.fileDelete();
		file.fileCheck();

	}

}
