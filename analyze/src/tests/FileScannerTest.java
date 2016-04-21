package tests;

import static com.google.common.truth.Truth.assertThat;

import java.io.FileNotFoundException;
import java.util.LinkedList;

import analysis.FileScanner;
import analysis.Snippet;

public class FileScannerTest {

	public FileScannerTest() {
		FileScanner sc = new FileScanner("tests/allfine/com/frjsh/allfine/sense/allfine.java");
		LinkedList<Snippet> results = null;
		try {
			results = sc.scan("super");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		assertThat(results).isNotEmpty();
	}

}
