package com.asiainfo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * swagger是一个API框架，是一个在线API文档并且可以同步更新，避免了程序员手工维护接口文档的工作，该框架也支持在线接口调用
 * spring集成swagger步骤：
 * 1、引入相关依赖：springfox-swagger2、springfox-swagger-ui
 * 2、编写配置类代码（本类就是swagger的配置类），配置类可以是一个空类，这样swagger就采用默认的配置，但一般会在里面写代码定义bean来覆盖默认的配置
 * 3、在Spring的配置文件中编写swagger的配置（对springfox-swagger-ui.jar中静态资源的访问）
 * 	  注意：如果启动之后访问swagger-ui.html页面之后报../configuration/ui 404，要在组件扫描的时候base-package属性加上“springfox”
 * 4、使用swagger
 * 
 * @author zhangzhiwang
 * @date 2021年3月4日 下午2:54:18
 */
@Configuration
@EnableSwagger2// 启用swagger
public class SwaggerConfig {
	/**
	 * 覆盖swagger的默认配置
	 *
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年3月4日 下午4:48:35
	 */
	@Bean
	public Docket docket1() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfo("title:swagger测试", 
				"description:描述信息", "version:1.0.0", "urn:tos", new Contact("张志旺", "www.oracle.com", "934109401@qq.com"), 
				"license:某个license", "http://www.apache.org/licenses/LICENSE-2.0"))
				.groupName("groupA") // 定义组名
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.asiainfo.controller1"))// 该组所扫描的包路径，即该包下面的所有api都会被分到groupA组
				.build();
	}
	
	/**
	 * API分组，就是定义多个Docket bean，每个Docket bean定义一个组并指定该组的扫描路径
	 *
	 * @return
	 * @author zhangzhiwang
	 * @date 2021年3月4日 下午4:51:21
	 */
	@Bean
	public Docket docket2() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfo("title:swagger测试", 
				"description:描述信息", "version:1.0.0", "urn:tos", new Contact("张志旺", "www.oracle.com", "934109401@qq.com"), 
				"license:某个license", "http://www.apache.org/licenses/LICENSE-2.0"))
				.groupName("groupB") // 定义组名，组名必须是英文否则会出问题
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.asiainfo.controller2"))// 该组所扫描的包路径，即该包下面的所有api都会被分到groupA组
				.build();
	}
	
	@Bean
	public Docket docket3() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(new ApiInfo("title:swagger测试", 
						"description:描述信息", "version:1.0.0", "urn:tos", new Contact("张志旺", "www.oracle.com", "934109401@qq.com"), 
						"license:某个license", "http://www.apache.org/licenses/LICENSE-2.0"))
				.groupName("groupC") // 定义组名
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.asiainfo.controller3"))// 该组所扫描的包路径，即该包下面的所有api都会被分到groupA组
				.build();
	}
}