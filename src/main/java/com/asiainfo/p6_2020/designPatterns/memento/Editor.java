package com.asiainfo.p6_2020.designPatterns.memento;

import java.util.Date;

/**
 * 备忘录创建者角色——文本编辑器
 *
 * @author zhangzhiwang
 * @date Apr 21, 2020 12:59:49 PM
 */
public class Editor {
	private String title;
	private String content;

	public Editor(String title, String content) {
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

	/**
	 * 保存草稿
	 * 
	 * @param editor
	 * @author zhangzhiwang
	 * @date Apr 21, 2020 1:01:18 PM
	 */
	public Draft saveDraft(Date date, Editor editor) {
		 Draft draft = new Draft(editor.getTitle(), editor.getContent());
		 System.out.println("加入草稿箱...");
		 DraftBox.putDraft(date, draft);
		 return draft;
	}

	/**
	 * 撤销到某一草稿
	 * 
	 * @author zhangzhiwang
	 * @date Apr 21, 2020 1:12:22 PM
	 */
	public void undoToDraft(Draft draft) {
		this.title = draft.getTitle();
		this.content = draft.getContent();
	}

	@Override
	public String toString() {
		return "Editor [title=" + title + ", context=" + content + "]";
	}

}
