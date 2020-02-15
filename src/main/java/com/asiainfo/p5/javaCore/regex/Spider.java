package com.asiainfo.p5.javaCore.regex;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 爬虫
 *
 * @author zhangzhiwang
 * @date Feb 15, 2020 9:25:11 PM
 */
public class Spider {
	public static void main(String[] args) throws Exception {
		String keyWorld = "咕泡";
		int pageNum = 1;
		int endPage = 10;
		int pageSize = 10;
		for(int i = pageNum; i <= endPage; i++) {
			System.out.println("------------第" + i + "页--------------");
			String url = "https://www.baidu.com/s?wd=" + keyWorld + "&pn=" + ((i - 1) * pageSize) + "&ie=utf-8&usm=1&rsv_idx=1&rsv_pq=8e370c2e00074da9&rsv_t=e8c958wFEv6uvCDpQYE79qOKS%2BP%2FDpSw3njsDYmzQW5VqRINOYN5mCPSj5A";
			Connection connect = Jsoup.connect(url);
			connect.header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.106 Safari/537.36")
			.header("Host", "www.baidu.com")
			.header("Referer", "https://www.baidu.com/")
			.header("Cookie", "BAIDUID=6238037A1771CD78D254F0A1C514FA17:FG=1; BIDUPSID=6238037A1771CD78D254F0A1C514FA17; PSTM=1526984452; BD_UPN=123253; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; ispeed_lsm=2; delPer=0; BD_HOME=0; BD_CK_SAM=1; PSINO=2; H_PS_PSSID=30746_1444_21108_18559_26350; H_PS_645EC=e213PDQf9bhXO39cQYQ6MiN58qV6tIvBHkHVh7AD17gAz%2BecZCCBk%2FNFikM");
			
			Document document = connect.get();
			String content = document.toString();
			
			Pattern titlePattern = Pattern.compile("<div\\s+class=\"(result|result-op)\\s+c-container\\s+[\\d\\D]*?<a[\\d\\D]*?>([\\d\\D]*?)</a>", Pattern.COMMENTS | Pattern.DOTALL | Pattern.MULTILINE);
			Matcher titleMatcher = titlePattern.matcher(content);
			
			Pattern linkPattern = Pattern.compile("<div\\s+class=\"(result|result-op)\\s+c-container\\s+[\\d\\D]*?<a[\\d\\D]*?href=\"([\\d\\D]*?)\"", Pattern.COMMENTS | Pattern.DOTALL | Pattern.MULTILINE);
			Matcher linkMatcher = linkPattern.matcher(content);
			
			Pattern profPattern = Pattern.compile("<div\\s+class=\"(result|result-op)\\s+c-container\\s+[\\d\\D]*?c-abstract\">([\\d\\D]*?)</div>", Pattern.COMMENTS | Pattern.DOTALL | Pattern.MULTILINE);
			Matcher profMatcher = profPattern.matcher(content);
			
			// 可以优化到一个while循环里，这里就不做优化了
			while(titleMatcher.find()) {
				System.out.println("标题：" + titleMatcher.group(2).replaceAll("<em>|</em>", ""));
			}
			while(profMatcher.find()) {
				System.out.println("简介：" + profMatcher.group(2).replaceAll("<em>|</em>", ""));
			}
			while(linkMatcher.find()) {
				System.out.println("链接：" + linkMatcher.group(2));
			}
			
			Thread.sleep(1000);// 防止访问过于频繁而被目标网站屏蔽
		}
	}
}
