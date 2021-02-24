package com.asiainfo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义转换器，必须实现Converter接口，泛型<S, T>的的意思是将S类型转换成T类型，并且将自定义的转换器配置在mvc的配置文件里
 */
public class DateConverter implements Converter<String, Date>{// 将Sting类型的日期转换成Date类型
	
	@Override
	public Date convert(String source) {
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		try {
			return df.parse(source);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
