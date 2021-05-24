package com.asiainfo.jvm;

public class JVMTest {
	/**
	 * 1、jdk包含jre，jre包含jvm，jdk > jre > jvm </br>
	 * 2、javac负责将java源码编译成class文件，这个时候还没有进入jvm，java命令运行class文件的时候才会把class文件加载到jvm内存中，这时才进入到jvm里</br>
	 * 3、class文件中u是基本单位，1u=1Byte=8bit </br>
	 * 4、类加载过程：装载 -> 链接 -> 初始化 </br>
	 * 	  装载：
	 * 		  1、根据类的全限定名称将class文件以字节流的形式读取到内存中，class文件可能在文件系统也可能来源于网络等。
	 * 		  2、将class文件的静态数据存放到jvm的方法区中，并在堆中创建Class对象以作为类的唯一访问入口
	 * 	  链接：包含三个阶段：
	 * 		   验证：验证class文件的正确性
	 * 		   准备：给类静态变量分配内存并赋默认值
	 * 		   解析：将符号引用转变为直接引用，关于符号引用和直接引用：https://blog.csdn.net/weixin_41490593/article/details/95110259
	 * 	  初始化：将类静态变量赋予真正的值
	 * 5、类加载机制：双亲委派机制
	 * 	  5.1 类加载器：
	 * 		  根类加载器：所有类加载器的父类加载器，c++实现，和底层操作系统相关，应用程序无法获取根类加载器的引用，默认加载%JAVA_HOME%/jre/lib/rt.jar，rt就是runtime的缩写，里面是jdk提供的api。
	 * 					可以使用-Xbootclasspath来自定义根类加载器加载路径，其中：
	 * 					-Xbootclasspath：根类加载器完全使用设置的路径来加载class文件，而不再会去加载%JAVA_HOME%/jre/lib/rt.jar
	 * 					-Xbootclasspath/a：其中的a可以理解为“after”，根类加载器在加载完%JAVA_HOME%/jre/lib/rt.jar后会继续加载指定路径的class
	 * 					-Xbootclasspath/p：其中的p可以理解为“pre”，根类加载器先加载指定路径的class文件再在加载%JAVA_HOME%/jre/lib/rt.jar
	 * 					示例：java -Xbootclasspath/p:/Users/zhangzhiwang/Desktop/B.jar -jar A.jar
	 * 		  扩展类加载器：扩展类加载器默认加载%JAVA_HOME%/jre/lib/ext目录下的jar包，可以使用-Djava.ext.dirs=【自定义目录】来指定，父加载器是根类加载器（注意这里的“父”不是继承的意思）。
	 * 					 但是要注意如果使用了-Djava.ext.dirs来指定路径的话那么扩展类加载器就不会去加载%JAVA_HOME%/jre/lib/ext路径了，如果使用到了ext路径下的class文件就会报错，解决方案有两种：
	 * 					a)由于ext目录下的jar包很少，可以将下面的所有jar文件拷贝到-Djava.ext.dirs指定的新目录下
	 *    				b)-Djava.ext.dirs可以指定多个目录并用冒号“:”分割（linux），这样既可以指定新目录也可以将默认的ext目录加进来
	 * 		  应用类加载器：应用类加载器默认加载classpath下面的class文件，Java语言实现，一般自定义的类都由它来加载，其父类加载器是扩展类加载器。
	 * 		  自定义加载器：用户自定义的加载器一般继承自应用类加载器。
	 *    5.2 双亲委派：双亲委派的好处一个是防止类被重复加载，二是防止java核心api类被篡改。
	 *    5.3 打破双亲委派
	 *    	  需要自定义类加载器并继承ClassLoader类，重写findClass方法和loadClass方法，在findClass方法中调用ClassLoader类的defineClass方法，在loadClass方法中加入判断：指定的类有自定义加载器加载，jdk核心类还是由双亲委派机制来加载。
	 * 	  	  是否可以加载自己定义的String类？答案：不可以，即使自定义类加载器并破坏双亲委派也不可以。原因是你可以重写finalClass方法，也可以重写loadClass方法，但是defineClass方法还得用ClassLoader类的，这个方法里面做了校验：如果类全限定名是以“java”开头的就报错，
	 * 		  所以不仅不能自定义java.lang.String类，任何自定义的类的包名只要是以“java”开头的都不可以。
	 * 6、eden:s0:s1为什么是8:1:1而不是6:2:2？
	 * 	 （1）因为应用程序在运行的过程中会有大量的对象被创建，而新创建的对象都放在young区eden区里面，如果eden区太小的话会导致频繁地gc
	 * 	 （2）survivor区由于是复制算法所以有一半的空间是浪费掉的，如果survivor区的比例增大会导致浪费的空间增多，所以最佳实践是8:1:1
	 * 	 （3）由于eden区对象的特点是照生夕死，所以一次gc后存活下来的对象只是少数，所以会有少部分的对象从eden区复制到survivor区，所以suvivor区不宜设置过大，而且suvivor区采用的是复制的垃圾回收算法，空间过大复制的成本也会增加
	 * 7、一些默认值：
	 * 	 对象从新生代晋升到老年代的默认阈值是15，而且这个值是最大值，可以手动调节该阈值的大小，但是不能超过15，当发生了一次minor gc后如果survivor区没有足够的空间来存放对象就会出发担保机制，从old区借一些空间来使用.
	 * 	 为什么是15？因为在32位的机器中，对象头是以4bit来存储对象分代年龄的，而4位最大是1111，转换成十进制是15。
	 *   对象进入老年代的三种情况：？？？
	 * 8、方法区、永久代和元空间：
	 * 	  方法区：是jvm规范的东西，它规定jvm要有方法区，是抽象的规定
	 * 	  永久代：是HotSpot虚拟机1.7及以前版本对方法区的一种实现
	 * 	  元空间：是HotSpot虚拟机1.8及以后版本对方法区的一种实现
	 * 9、方法区是线程共享的内存区域，存放类的元信息、运行时常量池、常量、静态变量和即时编译后的代码，方法区溢出会抛出OOM：Metaspace
	 * 10、栈帧：包括局部变量表、操作数栈、方法返回地址（方法执行完(不论是正常执行还是发生了异常)后需要返回到方法被调用的位置，程序才能继续执行）、动态链接（指向运行时常量池，表明该栈帧属于哪个方法）
	 * 		链接就是将class常量池里面的符号引用转换为直接引用，直接引用就是具体的内存地址。链接有静态链接和动态链接，静态链接就是在编译器就能够确定调用对象的并且在运行期不会改变，在加载的链接阶段的解析步骤进行此工作，包括类静变量和方法，常量，私有变量和方法，父类的变量和方法等。
	 * 		动态链接就是在编译期确定不了而在运行期才能确定下来调用对象的情况，所以将class常量池里面的符号引用替换成调用对象的内存地址的工作放到运行期来进行，比如多态。
	 * 		之所以存在栈帧肯定是某个方法在被调用，栈帧里面存放的的就是动态链接的指针，改置针指向方法区运行时常量池里面的方法描述（可以初步理解为被调用的方法在内存中也有内存地址）
	 * 11、class文件常量池：参考：https://blog.csdn.net/hxcaifly/article/details/82887552 和 https://blog.csdn.net/hxcaifly/article/details/82887609
	 * 12、gc root有哪些？选gc root有两个原则：
	 *    第一个是正在被使用的对象不能被回收，比如栈帧的局部变量表里面指向的对象不能被回收，因为这些对象正在被使用，而栈帧又在java虚拟机栈中，类似还有本地方法栈里面所指向的对象。
	 *    第二个是长期存在的对象及其所引用的对象不能被回收，比如和类生命周期一样的对象，比如静态变量、常量所引用的对象，除非类被卸载。还有一些比如类加载器及其加载的类本身也是长期存在的对象，这些对象也不能被回收。
	 * 13、垃圾回收算法：
	 * 	 （1）为什么young区用复制算法：因为young区对象的特点是朝生夕死，大部分对象被回收，存活下来的只是少数，复制成本低。
	 *   （2）标记清除算法的弊端：会有内存碎片的产生，容易提前引起gc，我们的目的是减少gc。
	 *   （3）标识垃圾的算法有两种：引用计数法和引用链分析法
	 *   （4）垃圾收集算法有两种：复制算法、标记清除和标记压缩（整理）
	 * 14、垃圾收集器：
	 * 	 （1）垃圾收集器的种类：
	 * 		串型收集器：serial、serial old。单线程回收，stw。
	 * 		并行收集器：parNew、parllel scavenge、parallel old。并行收集器更关注吞吐量，parnew是serial的多线程版本，parllel和parnew一样但更关注吞吐量。
	 * 		并发收集器：cms。并发收集器更关注停顿时间。
	 * 		g1
	 * 	 （2）作用区域：
	 * 		用于新生代的：serial（可搭配serial old、cms）、parNew（由于和serial完全一样只不过是serial的多线程版本所以可搭配的老年代收集器也和serial一样）、parllel scavenge（可搭配parallel old和serial old）、g1
	 * 		用于老年代的：cms（可搭配serial、parNew，其中cms也可以和serial old搭配使用）、serial old（可搭配所有新生代收集器）、parallel old（只能搭配parllel scavenge）、g1
	 * 	  有关gc的一些通用参数：
	 *    -XX:+PrintGCTimeStamps：打印出从jvm启动开始到发生本次gc所经历的时间，即jvm启动后多长时间进行了本次gc，是一个时间相对量。
	 *    -XX:+PrintGCDateStamps：记录了本次gc发生的真实时间，是一个时间绝对量
	 *    gc调优的本质就是通过调各种参数的值来达到高吞吐量和低停顿时间的目的，而且调优在于“调”，所以不是一蹴而就的事情，在于一次次地调试和观察。
	 *    一般的实践中一般是出了问题才会去关注gc调优的事情，如果没有问题一般不会进行这项工作。一般会遇到哪些问题呢？常见的有：
	 *    （1）gc频繁
	 *    	  打印日志，通过工具（最好通过工具，直接看日志不够直观）找出频繁gc的原因，然后调整jvm参数，比如堆大小、新生代和老年代的比例，选择合适的垃圾收集器等。
	 *    （2）发生oom
	 *    	  dump出日志，然后用mat分析，再结合源代码看
	 *    （3）线程死锁
	 *    	  用jstack命令或者jconsole、jvisualvm等工具分析
	 * 15、jvm的参数类型：
	 * 	 （1）标准参数（-）：不随着jdk版本的变更而变化，比如：-server、-help、-cp、-classpath等
	 * 	 （2）XX参数（-XX）：包括两种：
	 * 		布尔型：-XX[+/-]<name>，表示启用或者禁用name属性，比如：-XX:+UseConcMarkSweepGC
	 * 		key/value：-XX:<name>=<value>表示name属性的值是value，比如：-XX:MaxGCPauseMillis=500
	 * 	 （3）X参数（-X）：一般是XX参数的简写版，后面没有冒号和等号直接写值，比如：-Xmx100m，相当于：-XX:MaxHeepSize=100m，-Xms100m，相当于：-XX:InitialHeapSize=100m
	 * 16、几个常见的jvm命令：
	 * 	  （1）jps，查看Java进程号。jps -l
	 *    （2）jinfo，查看jvm参数。jinfo -flags pid查看jvm所有参数，jinfo -flag UserG1GC pid查看是否启用g1收集器，jinfo -flag InitialHeapSize pid查看初始堆大小
	 * 	  （3）jstat，查看统计信息。jstat <option> pid 采样间隔 采样次数，比如jstat -gc pid 1000 10，查看某进程的gc情况，每1000ms取一次样，一共取10次。
	 * 	  （4）jstack，查看进程的堆栈信息。
	 * 	  （5）jmap，打印堆的转储快照。jmap -heap pid，将进程的对信息输出到标准输出（控制台），如果想将对的转储快照放到文件里可以使用：jmap -dump:format=b,file=heap.hprof pid。
	 * 17、常用工具：
	 * 	   可视化工具：jconsole（jdk自带）、jvisualvm（jdk自带）、MAT（官网：http://www.eclipse.org/mat/）
	 * 	   命令行工具：arthas（阿里开源的java诊断工具，以交互的方式进行操作，官网：https://arthas.aliyun.com/zh-cn/）
	 * 	   网络工具：gceasy.io（在线分析gc日志）、gcviewer（官网：https://github.com/chewiebug/GCViewer）
	 * 	   其中，mat要弄清楚几个概念：
	 *    （1）incoming/outgoing references：incoming是哪些对象引用了本对象，outgoing是本对象引用了哪些对象
	 *    （2）dominator tree：支配树视图。如果从gc root出发到达某个对象B会有N条路径，每个路径叫一个引用链，如果这N条路径中所有的路径都经过某一对象A，那么称A对象支配B对象，或者说B对象的dominator是A，如果A是离B最近的一个支配者那么A是B的直接支配者。
	 *    	  在某一个对象上右键选择Immediate Dominators可以查看该对象的直接支配者。
	 *    （3）在某一对象上右键可以看到List objects和Show objects by class，前者是以支配树视图来查看，后者是以类图的形式来查看。
	 *    （4）shallow heap和retained heap：前者是对象本身的大小，不包括他所引用对象的大小，如果是数组则是数组所有元素大小之和；后者是对象本身和其所引用（包括直接引用和间接引用）的对象的大小，然后减去作为gc root部分的内存，也就是当本对象回收后一共可以释放的内存大小。
	 *    mat实战1:类的某个方法里有一个局部变量List<User> userList，然后往里面放大量的User对象导致堆内存溢出。
	 *    	首先前提是在oom的时候dump出内存快照，然后用mat打开内存快照。打开之后点进Histogram视图，按照retained  heap倒序排序，查看占用内存比较多的可以对象，主要看看有没有项目里面自定义的类。在可疑对象上右键->Show objects by class->by incoming references，
	 *    	在打开的视图里点击对象左边的箭头看有没有调用它的类，这些类里面有没有自定义的类，然后结合代码去排查。
	 *    mat实战2:和上面的例子一样，只不过List<User> userList是类的成员属性。
	 *    	打开之后选择dominator tree视图，然后按照retained  heap倒序排序，查看占用内存比较多的可疑对象。在可疑对象上右键->path to gc roots->exclude all ... etc.references（排除所有弱软虚引用，因为这些肯定会被回收掉不会造成oom，能造成oom的是不能被回收掉的强引用），
	 *    	在新粗昂口点击对象的箭头，看看能不能找到对象的引用链里面有自定义的类，然后按照同样的方式循环地查找直到找到不是自己的类为止，然后结合代码看。
	 *    	在实际使用当中，由于不知道造成堆溢出的是哪种情况，所以这两种场景都要排查。
	 *    mat实战3:差生大量的类导致元空间溢出。
	 *    	打开之后点进Histogram视图，按照retained  heap倒序排序，查看占用内存比较多的可以对象，在可疑对象上右键->list objects->with outgoing references，在新视图的列表里的class name字段是否可以找到有用的信息。
	 *    mat实战4:模拟栈溢出。-XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath这两个参数对栈溢出不起作用，原因可能是由于StackOverflowError不是OutOfMemoryError的子类吧，也可能是栈溢出根堆没有关系，从这两个参数的名字可以看出——“Heap...”。
	 * 18、逃逸分析：有关逃逸分析比较好的文章，涉及锁消除、标量替换、栈上分配等概念：
	 * 		由于逃逸分析和即时编译JNI有关，而即时编译涉及到编译，所以要从编译开始了解。
	 * 		编译：https://www.hollischuang.com/archives/58
	 * 		深入分析Java的编译原理：http://www.hollischuang.com/archives/2322
	 * 		对象和数组并不是都在堆上分配内存的：https://www.hollischuang.com/archives/2398
	 * 		深入理解Java中的逃逸分析：https://blog.csdn.net/hollis_chuang/article/details/80922794
	 * 	  Java是解释运行的，这项工作有解释器来完成，解释就是将class文件翻译成机器识别的机器指令，这个过程肯定比机运行器直接能够直接是别的字节码要慢，为了提高效率引入JIT（即时编译）的概念。
	 *    翻译器的工作就是现将class的字节码翻译成机器吗，然后执行机器码，这个过程是逐行进行的，如果遇到了循环再次执行到本行代码的时候还是要对该行代码进行翻译，这行代码被循环执行多少次就被翻译多少次。jit技术的出现恰恰是解决这种效率问题。
	 *    在jvm运行的过程当中会检测某部分代码或者代码块是否被经常使用，如果经常被使用的话就把它标记为热点代码，对于热点代码jit编译器会进行一次编译（这个过程和前面的解释第一步一样），将class文件的代码翻译成机器识别的机器码，并将这部分代码进行一定的优化，
	 *    然后缓存起来，下次再用到的时候会从缓存里面拿，这样这部分热点代码只编译一次就可以了。那么优化的手段有哪些呢？
	 *   （1）逃逸分析
	 *    	jit编译器会分析方法的局部变量的作用范围会不会延伸到方法以外，会不会被其他对象或者线程引用到，典型的就是方法的出入參。使用参数-XX:+/-DoEscapeAnalysis来开启和关闭逃逸分析
	 *   （2）标量替换
	 *   	根据逃逸分析的结果，如果发现方法内的局部变量的作用范围不会超出方法的作用范围，如果该变量是一个对象的话，那么很可能就不在堆里面创建对象了，而是将对象进行“解剖”，使用它的的各个成员变量来代替对象本身。
	 *   	这里涉及到两个概念：
	 *      标量：不可拆分的、最小粒度的变量，比如基本类型的变量
	 *      聚合量：可以拆分为若干标量和聚合量的变量，比如复合类型的变量就是聚合量
	 *      所以标量替换就是将聚合量拆分为若干标量，从这些标量来代替聚合量，从而减少堆内存的分配
	 *   （3）栈上分配
	 *   	在逃逸分析之后发现某个局部变量的对象不会逃逸出方法，而且这个对象也不会被外部引用，那么完全没有必要在对立面去创建该对象了，因为对里面的对象是线程共享的，可以把这个对象“放到栈帧里面”，方法运行结束，栈帧被弹出自然对象被销毁，这样也为减轻对的gc压力做了贡献，因为栈帧里面压根儿就不需要gc。
	 *   	但实际上栈上分配就是标量替换的一种实现，所谓的栈上分配对象没有放到栈里面，而是把对象“打散”成若干标量所谓方法的局部变量，这些局部变量当然在栈帧里面。
	 *   （5）锁消除
	 *   	在逃逸分析之后发现被加了锁的对象只能当前线程可以访问，其他线程访问不到，这样jit编译器就将加在它身上的锁去掉。
	 */
	public static void main(String[] args) throws InterruptedException {
		ClassLoader classLoader = JVMTest.class.getClassLoader();
		System.out.println(classLoader);
		Thread.sleep(Integer.MAX_VALUE);
	}
}
