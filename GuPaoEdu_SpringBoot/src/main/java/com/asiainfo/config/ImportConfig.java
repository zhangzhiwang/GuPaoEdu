package com.asiainfo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.asiainfo.entity.Order;


/**
 * 在Spring中我们将类型对象交给SpringIoC管理的方式有哪些？
 * 1、在xml配置<bean>
 * 2、使用@Component注解及其子注解（@Service、@Controller、@Repository、@Configuration等）
 * 3、使用@Configuration + @Bean
 * 4、使用@Import注解
 * 5、FactoryBean接口的getObject()方法
 *
 * @author zhangzhiwang
 * @date Nov 3, 2020 10:12:12 PM
 */
//@Configuration
//@Component
@Service
//@Import({Order.class})// 这种方式的缺点是类型数组是写死的，想动态import某些类是做不到的
// 动态import某些类的方式1：import一个ImportSelector的实现类
//@Import({MyImportSelector.class})
//动态import某些类的方式2：import一个ImportBeanDefinitionRegistrar的实现类
@Import({MyImportBeanDefinitionRegistrar.class})
public class ImportConfig {
//	@Bean
	public Order order() {
		return new Order();
	}
}
