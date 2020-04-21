package com.asiainfo.p6_2020.designPatterns.memento;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 备忘录管理者角色——草稿箱
 *
 * @author zhangzhiwang
 * @date Apr 21, 2020 1:06:12 PM
 */
public class DraftBox {
	private static Map<Date, Draft> map = new HashMap<Date, Draft>();
	
	/**
	 * 将草稿加入草稿箱
	 * 
	 * @param date
	 * @param draft
	 * @author zhangzhiwang
	 * @date Apr 21, 2020 1:09:28 PM
	 */
	public static void putDraft(Date date, Draft draft) {
		map.put(date, draft);
	}
	
	/**
	 * 获取草稿
	 * 
	 * @param date
	 * @return
	 * @author zhangzhiwang
	 * @date Apr 21, 2020 1:11:18 PM
	 */
	public static Draft getDraft(Date date) {
		return map.get(date);
	}
}