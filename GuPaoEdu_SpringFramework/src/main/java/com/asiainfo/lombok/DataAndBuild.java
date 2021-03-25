package com.asiainfo.lombok;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

/**
 * @Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor，注意不包含@NoArgsConstructor和@AllArgsConstructor
 *
 * @author zhangzhiwang
 * @date 2021年3月3日 下午11:13:24
 */
@Data
@Builder// 使创建对象可以使用链式的方式来设置属性，用到的是建造者模式
public class DataAndBuild {
	private static final int GENDER = 1;
	private static int number1;
	private final int NUMBER2 = 1;
	private int age;
	protected String name;
	@NonNull
	public Date time;
	
	public static void main(String[] args) {
		DataAndBuild dataAndBuild = DataAndBuild.builder()
				.age(19)
				.name("zhangsan")
				.time(new Date())
				.build();
		System.out.println(dataAndBuild);
	}
}
