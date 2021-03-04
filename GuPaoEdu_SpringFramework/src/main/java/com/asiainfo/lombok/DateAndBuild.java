package com.asiainfo.lombok;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

/**
 * @Data = @Getter + @Setter + @ToString + @EqualsAndHashCode + @RequiredArgsConstructor，注意不包含@NoArgsConstructor和@AllArgsConstructor
 *
 * @author zhangzhiwang
 * @date 2021年3月3日 下午11:13:24
 */
@Data
public class DateAndBuild {
	private static final int GENDER = 1;
	private static int number1;
	private final int NUMBER2 = 1;
	private int age;
	protected String name;
	public Date time;
}
