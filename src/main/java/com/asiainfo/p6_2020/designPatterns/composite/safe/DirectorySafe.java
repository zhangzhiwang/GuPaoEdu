package com.asiainfo.p6_2020.designPatterns.composite.safe;

import java.util.ArrayList;
import java.util.List;

/**
 * 目录
 *
 * @author zhangzhiwang
 * @date Mar 22, 2020 4:20:18 PM
 */
public class DirectorySafe extends FileSystemSafe {
	private List<FileSystemSafe> list = new ArrayList<>();

	public DirectorySafe(String name, int level) {
		super(level);
		this.name = name;
	}

	public void addChild(FileSystemSafe fs) {
		list.add(fs);
	}

	public void list() {
		for (FileSystemSafe fs : list) {
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
