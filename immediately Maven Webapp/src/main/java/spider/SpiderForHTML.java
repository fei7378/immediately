package spider;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class SpiderForHTML {
	public static void main(String[] args) {
		// http://www.bishijie.com/shendu_3130
		// ReadConntent(3167);
		ReadP("https://m.jinse.com/bitcoin/209672.html");
	}

	public static String ReadP(String url) {
		String text = null;
		try {
			Document document = Jsoup.connect(url).get();
			// System.out.println(document.body().getElementsByTag("p"));
			// System.out.println(document.body().getElementsByTag("p"));

			text = document.body().getElementsByTag("p") + "";
			// System.out.println(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

	public static String ReadConntent(int url) {
		String text = null;
		try {
			Document document = Jsoup.connect("http://www.bishijie.com/shendu_" + url).get();
			// System.out.println(document.body().getElementsByClass("content"));
			text = document.body().getElementsByClass("content") + "";

		} catch (IOException e) {
			e.printStackTrace();
		}
		return text;
	}

}
