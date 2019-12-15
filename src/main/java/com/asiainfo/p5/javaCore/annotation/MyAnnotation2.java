package com.asiainfo.p5.javaCore.annotation;

import java.lang.annotation.Annotation;

/**
 * MyAnnotation2不是一个注解类，虽然注解类必须是Annotation的子接口，但是Annotation的子接口不一定是注解，因为还有一个限制条件是注解类的声明必须使用@interface，所以本类不会被识别为注解类
 *
 * @author zhangzhiwang
 * @date 2019年12月14日 下午9:35:37
 */
public interface MyAnnotation2 extends Annotation {

}
