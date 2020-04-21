package com.asiainfo.p6_2020.designPatterns.memento;

/**
 * 备忘录角色——草稿
 *
 * @author zhangzhiwang
 * @date Apr 21, 2020 1:02:31 PM
 */
public class Draft {
	private String title;
	private String content;

	public Draft(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "Draft [title=" + title + ", content=" + content + "]";
	}

}
