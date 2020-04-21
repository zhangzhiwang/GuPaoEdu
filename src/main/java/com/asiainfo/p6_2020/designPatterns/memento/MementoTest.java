package com.asiainfo.p6_2020.designPatterns.memento;

import java.util.Date;

/**
 * 备忘录模式——记录对象的状态以便需要时恢复到该状态</p>
 * 备忘录模式的三个角色：</p>
 * 1、备忘录创建者角色</p>
 * 2、备忘录角色</p>
 * 3、备忘录管理者角色
 *
 * @author zhangzhiwang
 * @date Apr 21, 2020 12:52:57 PM
 */
public class MementoTest {
	public static void main(String[] args) {
		/**
		 * 场景：网页文本编辑器的草稿功能。三个角色：备忘录创建者角色——文本编辑器、备忘录角色——草稿、备忘录管理者角色——草稿箱（草稿箱里面存放着历史草稿）
		 */
		
		Editor editor = new Editor("MyTitle", "MyContent");
		System.out.println("editor = " + editor);
		
		// 保存草稿
		System.out.println("保存草稿...");
		Date date1 = new Date();
		Draft draft1 = editor.saveDraft(date1, editor);
		System.out.println("draft1 = " + draft1);
		System.out.println("草稿保存完毕！");
		
		// 修改编辑器内容
		System.out.println("第一次修改编辑器内容...");
		editor.setTitle("MyTitle_edit_1");
		editor.setContent("MyContent_edit_1");
		System.out.println("editor_edit_1 = " + editor);
		System.out.println("保存草稿...");
		Date date2 = new Date();
		Draft draft2 = editor.saveDraft(date2, editor);
		System.out.println("draft2 = " + draft2);
		System.out.println("草稿保存完毕！");
		
		// 获取第二次保存的草稿
		Draft d2 = DraftBox.getDraft(date2);
		System.out.println("获取第二次保存的草稿，d2 = " + d2);
		Draft d1 = DraftBox.getDraft(date1);
		System.out.println("获取第一次保存的草稿，d1 = " + d1);
		
		// 修改编辑器内容
		System.out.println("继续修改编辑器内容...");
		editor.setTitle("MyTitle_edit_2");
		editor.setContent("MyContent_edit_2");
		System.out.println("现在编辑器的内容为：editor = " + editor);
		
		// 将编辑器的内容恢复到第一次草稿的内容
		editor.setTitle(d1.getTitle());
		editor.setContent(d1.getContent());
		System.out.println("将编辑器的内容恢复到第一次草稿的内容，editor = " + editor);
		
		// 将编辑器的内容恢复到第二次草稿的内容
		editor.setTitle(d2.getTitle());
		editor.setContent(d2.getContent());
		System.out.println("将编辑器的内容恢复到第一次草稿的内容，editor = " + editor);
	}
}
