package com.asiainfo.p6_2020.designPatterns.adapter.interfaceAdapter;

/**
 * 接口适配器</p>
 * 接口适配器和前两种适配器的使用场景不一样，前两种适配器的使用场景是当新需求和原有功能差别不大时，利用原有的功能来适应新需求；而接口适配器主要是减少实现类所需实现接口的数量，所以应用场景不一样。</p>
 * 这就类似于接口隔离原则，实现类不应该依赖其所不需要的接口。如果一个接口的方法有好多，但是实现类只需要实现其中的部分方法，其他方法在实现类里面只能置空或者抛异常，客户端调用的时候会有疑惑。
 *
 * @author zhangzhiwang
 * @date Mar 25, 2020 9:31:59 AM
 */
public class InterfaceAdapterTest {

}
