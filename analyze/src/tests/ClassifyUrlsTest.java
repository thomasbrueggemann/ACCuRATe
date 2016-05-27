package tests;

import analysis.urls.ClassifyUrls;

public class ClassifyUrlsTest {

	@SuppressWarnings("unused")
	public ClassifyUrlsTest() {

		ClassifyUrls urls = new ClassifyUrls();
		urls.train();
		Object result = urls.classify("facebook.com");
		if (result != null) {
			System.out.println(result.toString());
		}
	}
}
