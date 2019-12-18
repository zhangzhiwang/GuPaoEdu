package com.asiainfo.p5.javaCore.annotation;

import java.lang.annotation.Target;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * MyAnnotation是一个注解类，首先它使用@interface作为类的声明，其次它隐含地继承了Annotation接口，可以使用javap -c MyAnnotation.class来查看它的父接口
 *
 * @author zhangzhiwang
 * @date 2019年12月14日 下午9:35:37
 */
// 元注解——标注在注解类上的注解，且只能标注在注解类上。jdk提供了四种元注解：@Target、@Retention、@Inherited、@Documented
// @Target注解表示被修饰的注解类能标注在什么元素上，它的值是ElementType的数组，而ElementType是一个枚举。如果注解类上没有标注@Target，那么它可以标注在任何元素上。
@Target(value = {ElementType.TYPE, ElementType.METHOD, ElementType.FIELD})
/**
 *  @Retention定义注解的保留策略，也就是规定注解的声明周期，它的值至能有一个且为RetentionPolicy枚举。RetentionPolicy一共有三个枚举值，分别是SOURCE、CLASS、RUNTIME。</p>
 *  1、SOURCE表示该注解的生命周期只在源码阶段有效，被编译成class文件后该注解失效，典型的注解为@Override、@SuppressWarnings，这也就解释了为什么方法上是不是标注了@Override对程序的运行没有影响，因为在编译成class文件后该注解被去除。</p>
 *  2、CLASS表示该注解的生命周期为字节码阶段，即该注解在源码和class文件内有效，运行时失效。</p>
 *  3、RUNTIME表示该注解的生命周期为运行时有效，即该注解在源码、class文件和运行时都有效。</p>
 *  三者的作用域大小为SOURCE<CLASS<RUNTIME，如果不标注@Retention，那么默认的作用周期为RetentionPolicy.CLASS。
 */
@Retention(RetentionPolicy.RUNTIME)
// @Inherited表示被MyAnnotation标注的类的子类也拥有该注解，但是要注意：此注解只适合普通的类继承，不适用于接口的继承和接口的实现，即子接口不会拥有父接口标注了@Inherited注解的注解，实现类也不会拥有被实现接口标注了@Inherited注解的注解
@Inherited
// 标记使用的注解是否包含在生成的用户文档中
@Documented
public @interface MyAnnotation {
	String value() default "123";
}
