package com.asiainfo.p6_2020.designPatterns.composite.transparent;

public class MyFile extends FileSystem {// 为了区分java.io.File所以将名字命名为MyFile
	public MyFile(String name, int level) {
		super(level);
		this.name = name;
	}
	
	public String getName() {
		return name;
	};

	public String getExtName() {
		int index = name.indexOf(".");
		return name.substring(index + 1);
	};

	public void rename(String newName) {
		name = newName;
	};

	public int getSize() {
		return 10;// 模拟
	};
}
