package com.asiainfo.p6_2020.designPatterns.composite.safe;

/**
 * 文件系统的抽象，任何组成部分（目录或者文件）都是它的实现类
 *
 * @author zhangzhiwang
 * @date Mar 22, 2020 4:12:04 PM
 */
public abstract class FileSystemSafe {
	protected int level;
	protected String name;
	
	public FileSystemSafe(int level) {
		super();
		this.level = level;
	}

	public String getName() {
		throw new UnsupportedOperationException("不支持获取名称");
	};

	public void rename(String newName) {
		throw new UnsupportedOperationException("不支持重命名");
	};

	public int getSize() {
		throw new UnsupportedOperationException("不支持获取大小");
	};
}
