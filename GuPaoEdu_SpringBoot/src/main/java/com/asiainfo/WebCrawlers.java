package com.asiainfo;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * （借用SpringBoot工程编写正则表达式课程的网络爬虫程序）
 *	网络爬虫
 */
public class WebCrawlers {
	public static void main(String[] args) throws IOException {
		crawl("咕泡", 3, 10);
	}
	
	public static void crawl(String keyword, int pageNum, int pageSize) throws IOException {
		String url = "https://www.baidu.com/s?wd=" + keyword + "&pn=" + ((pageNum - 1) * pageSize) +"&ie=utf-8";
		Connection connection = Jsoup.connect(url);
		// 模拟真实浏览器环境，因为有的网站会屏蔽非法的请求
		connection.header("Host", "www.baidu.com").header("Referer", "www.baidu.com").header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 11_2_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.96 Safari/537.36")
				.header("Cookie", "BAIDUID=DA6DB64C0AB356055EC5F09FDEDB15FF:FG=1; PSTM=1521875006; BIDUPSID=5D7F17C6D92E934B83209263C2AF7E0F; H_PS_PSSID=33423_33356_33272_31253_33461_33460_26350_33567; BD_UPN=123253; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; H_PS_645EC=9af3NbNIvwdPtWWV3cQl9S3RAbDcoLBby5m4i1eHrSUWaB%2BwiJuJnYY6fqE; BA_HECTOR=8020ag0k05ak212k831g1l6oq0r; delPer=0; BD_CK_SAM=1; PSINO=3; BDSVRTM=126");
		Document document = connection.get();
//		System.out.println(document);
		parseDocument(document);
	}
	
	public static void parseDocument(Document document) {
		String content = document.toString();
		Pattern pattern = Pattern.compile("<div\\s+class=\"(?:result|result-op)\\s+c-container\\s+.*?<a.*?>(?<baiduTitle>.*?)</a>", Pattern.COMMENTS | Pattern.DOTALL | Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(content);
		while(matcher.find()) {
			System.out.println(matcher.group("baiduTitle").replaceAll("(<em>)|</em>",""));
		}
	}
}
