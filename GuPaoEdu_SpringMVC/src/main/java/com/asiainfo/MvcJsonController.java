package com.asiainfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * mvc默认支持jackson，但要引入jackson的相关依赖
 *
 * @author zhangzhiwang
 * @date 2021年2月25日 下午2:23:57
 */
@RestController
@RequestMapping("json")
public class MvcJsonController {
	/**
	 * mvc默认支持jackson，会将返回的对象自动转换成json格式 如果入參是一个对象的话，比如User对象，客户端传过来的是json格式，那么要使用@RequestBody。
	 * 
	 * @RequestBody 注解表明接受请求体里面的内容，一般是json格式，mvc框架自动将请求体的json内容转换为入參对象的属性（前提是要引入相关json的jar包）。get请求事没有请求体的，所以要使用@RequestBody接受请求体的参数必须使用post来访问
	 *
	 * @param user
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年2月26日 上午11:45:10
	 */
	@PostMapping("/met1")
	public List<User> met1(@RequestBody User user) {
		List<User> userList = new ArrayList<User>();
		userList.add(user);
		userList.add(new User());
		return userList;
	}

	@PostMapping("/met2")
	public void met2(@RequestBody User user) {
		System.out.println(user);
	}
	
	/**
	 * mvc默认并没有提供数据校验的功能，需要集成第三方校验框架来使用，这里用的是hibernate的校验框架
	 * 步骤：
	 * 1、首先需要引入hibernate-validator依赖
	 * 2、在mvc配置文件进行配置
	 * 3、在入參实体类的属性中添加响应校验注解
	 * 4、在controller入參里需要校验的实体类前面加上@Validated注解
	 * 5、controller方法入參要添加BindingResult用于绑定校验结果
	 *
	 * @param user
	 * @author zhangzhiwang
	 * @date 2021年2月26日 下午4:05:47
	 */
	@PostMapping("/validateData")
	public void validateData(@RequestBody @Validated User user, BindingResult bindingResult) {
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		for(ObjectError error : allErrors) {
			System.out.println(error.getDefaultMessage());
		}
	}
	
	/**
	 * 分组校验：同一个实体类的同一个字段在不同场景下可能使用不同的校验规则，比如user.id在插入的时候校验规则是必须为空，而在修改和删除的时候校验规则是必须不为空，所在要在相关校验的注解里面告诉该校验在什么场景下适用，这个就要靠分组来实现，一个分组就是一个场景。
	 * 分组就是一个标记接口，比如ValidateGroup1/ValidateGroup2，是一个空接口。在实体类的属性校验规则上加上相关的分组，就代表只有在这些分组（场景）下适用在校验规则。在controller的入參处@Validated注解也要加上相关的分组信息，来表明要使用那些场景的校验
	 *
	 * @param user
	 * @param bindingResult
	 * @author zhangzhiwang
	 * @date 2021年2月26日 下午5:11:03
	 */
	@PostMapping("/gourpValidateData")
	public void gourpValidateData(@RequestBody @Validated(value = {ValidateGroup1.class}) User user, BindingResult bindingResult) {
		System.out.println(user);
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		for(ObjectError error : allErrors) {
			System.out.println(error.getDefaultMessage());
		}
	}
}
