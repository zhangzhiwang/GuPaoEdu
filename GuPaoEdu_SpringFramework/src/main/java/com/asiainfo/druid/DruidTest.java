package com.asiainfo.druid;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 德鲁伊
 * 数据库连接池避免了程序自己去创建连接并释放链接等操作，这些和数据库连接的操作适合业务无关的，最好有专门的东西来管理这些，数据库连接池就是来管理数据库连接的。
 * 市面上目前常用的数据库连接池有三种：c3p0，dhcp，druid
 * 关于数据库连接池可以参考：https://baike.baidu.com/item/数据库连接池/1518538?fr=aladdin	https://www.cnblogs.com/cocoxu1992/p/11031908.html
 * druid又名德鲁伊，是阿里开发的一个开源数据库连接池组件，一大亮点就是可以提供监控并结合了c3p0和dhcp的优点，是目前市面上最好的数据库连接池组件
 *
 * @author zhangzhiwang
 * @date 2021年3月10日 下午1:09:01
 */
public class DruidTest {
	public static void main(String[] args) {
		// 单独使用druid
		// 1、引入druid依赖
		// 2、创建DruidDataSource
		DruidDataSource druidDataSource = new DruidDataSource();
		// 3、设置数据库链接的必要属性
		druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=UTF-8");
		druidDataSource.setUsername("root");
		druidDataSource.setPassword("zzw1234");
		
		// 4、设置数据库链接池的非必要属性
		druidDataSource.setInitialSize(5);// 连接池初始化时初始化的数据库连接数
		druidDataSource.setMinIdle(5);// 最小空闲链接
		druidDataSource.setMaxActive(30);// 最大活跃链接
		druidDataSource.setMaxWait(10000);// 最大等待时间
		/**
		 * minEvictableIdleTimeMillis:最小空闲时间，默认30分钟，如果连接池中非运行中的连接数大于minIdle，并且那部分连接的非运行时间大于minEvictableIdleTimeMillis，
		 * 则连接池会将那部分连接设置成Idle状态并关闭；也就是说如果一条连接30分钟都没有使用到，并且这种连接的数量超过了minIdle，则这些连接就会被关闭了
		 */
		druidDataSource.setMinEvictableIdleTimeMillis(400000);
		System.out.println(druidDataSource);
	}
}
