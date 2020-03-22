package com.asiainfo.p6_2020.designPatterns.composite.transparent;

/**
 * 文件系统的抽象，任何组成部分（目录或者文件）都是它的实现类
 *
 * @author zhangzhiwang
 * @date Mar 22, 2020 4:12:04 PM
 */
public abstract class FileSystem {
	protected int level;
	protected String name;
	
	public FileSystem(int level) {
		super();
		this.level = level;
	}

	public void addChild(FileSystem fs) {
		throw new UnsupportedOperationException("不支持添加子节点");
	};

	public void list() {
		throw new UnsupportedOperationException("不支列出子目录或文件");
	};

	public String getName() {
		throw new UnsupportedOperationException("不支持获取名称");
	};

	public String getExtName() {
		throw new UnsupportedOperationException("不支持获取扩展名");
	};

	public void rename(String newName) {
		throw new UnsupportedOperationException("不支持重命名");
	};

	public int getSize() {
		throw new UnsupportedOperationException("不支持获取大小");
	};
}
