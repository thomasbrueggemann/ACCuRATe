package tests;

import analysis.urls.ClassifyUrls;

public class ClassifyUrlsTest {

	public ClassifyUrlsTest() {

		ClassifyUrls urls = new ClassifyUrls();
		urls.train();
	}
}
