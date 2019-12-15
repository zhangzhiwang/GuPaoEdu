package com.asiainfo.p5.javaCore.annotation;

import java.lang.annotation.Annotation;

/**
 * MyAnnotation是一个注解类，首先它使用@interface作为类的声明，其次它隐含地继承了Annotation接口，可以使用javap -c MyAnnotation.class来查看它的父接口
 *
 * @author zhangzhiwang
 * @date 2019年12月14日 下午9:35:37
 */
public @interface MyAnnotation {

}
