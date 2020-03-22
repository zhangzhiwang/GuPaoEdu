package com.asiainfo.p6_2020.designPatterns.composite.transparent;

import java.util.ArrayList;
import java.util.List;

/**
 * 目录
 *
 * @author zhangzhiwang
 * @date Mar 22, 2020 4:20:18 PM
 */
public class Directory extends FileSystem {
	private List<FileSystem> list = new ArrayList<>();

	public Directory(String name, int level) {
		super(level);
		this.name = name;
	}

	@Override
	public void addChild(FileSystem fs) {
		list.add(fs);
	}

	@Override
	public void list() {
		for (FileSystem fs : list) {
			if (level == 0) {// 假设只有三级目录
				System.out.println(fs.getName());
			} else if (level == 1) {
				System.out.println("\t|+++" + fs.getName());
			} else if (level == 2) {
				System.out.println("\t\t|------" + fs.getName());
			}
		}
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void rename(String newName) {
		name = newName;
	}

	@Override
	public int getSize() {
		return list.size();
	}
}
