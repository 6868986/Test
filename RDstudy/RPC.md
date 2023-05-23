### RPC

#### RPC简介

RPC，Remote Procedure Call，远程过程调用，是一种编程模型。

解决分布式系统中服务之间的调用问题；

使远程调用像本地调用一样，调用者感知不到底层网络编程的细节，更加专注于业务逻辑。就像建在小河上的桥一样连接着河的两岸，如果没有小桥，我们需要通过划船、绕道等其他方式才能到达对面，但是有了小桥之后，我们就能像在路面上一样行走到达对面，并且跟在路面上行走的体验没有区别。

作为RD，追求的是一个高性能高可用的RPC框架。

#### RPC通信过程

<img src="https://upload-images.jianshu.io/upload_images/7143349-9e00bb104b9e3867.png?imageMogr2/auto-orient/strip|imageView2/2/format/webp" alt="img" style="zoom:150%;" />

Client端：

- Application是RPC的调用方；
- Client Stub相当于代理对象，也就是客户端的serviceImpl，其实内部是通过rpc方式来进行远程调用的代理对象proxy；
- Client Run-time Library，则是实现远程调用的工具包，比如jdk的Socket；
- Transport通过底层网络实现实现数据的传输。

这个过程中最重要的就是序列化和反序列化 => 数据传输的数据包必须是二进制的，将Java对象序列化为二进制格式传输

#### RPC&Restful

二者并不是一个维度的概念，RPC设计的范围更广。RPC是面向过程，Restful是面向方法。

#### RPC的实现

代理模式+Spring IoC：通过Spring注入serviceImpl对象，注入时，如果扫描到对象加了@Reference注解 => 注入+proxy，则会在工厂中生成一个代理对象。这个proxy的内部就是通过RPC进行远程调用的。

- 一个服务有多个实例，如何获取这些实例的地址socket => 注册中心
- 如何确定选择哪个实例 => 负载均衡策略
- 每次调用都需要去注册中心查实例列表效率低 => 缓存
- 客户端发起调用后继续处理自己的事 => 异步调用
- 服务端接口的版本控制
- 服务端接受调用的线程池
- ......

#### RPC demo

https://github.com/6868986/Test/tree/dev/src/main/java/org/example/Study/RPC

缺点：

- 需要自己手动写proxy对象用来发起RPC调用很不方便

  思想：要求所有的远程调用都遵循一套模板。把远程调用的信息放到一个Request对象里面，发给Server端，Server端解析之后就知道要调用的是哪个RPC接口、以及入参的类型、入参的值。

  => 实现代理对象通用化 => 协议

- 集成spring

  通过spring的IOC来创建代理对象

  Dubbo：Dubbo通过和Spring的集成，在Spring容器初始化的时候，如果扫描到对象加了@Reference注解，那么就给这个对象生成一个代理对象，这个代理对象会负责远程通讯，然后将代理对象放进容器中。因此代码运行时用到的对象其实是spring工厂中的代理对象。

  http://dubbo.apache.org/books/dubbo-user-book/

  http://dubbo.apache.org/books/dubbo-dev-book/

- 长连接、短连接

  可以保持若干个长连接，然后每次有rpc请求时，把请求放到任务队列中，然后由线程池去消费执行；

  不能每次调用RPC接口时都去开启一个Socket建立连接；

- server线程池同时处理多个RPC请求

- 服务注册中心

- 负载均衡

- server结果缓存

- 版本控制

- 异步调用

- 优雅停机

#### Socket与网卡

#### RPC协议

- 为啥需要一套通信协议

  RPC远程调用过程中涉及到正反序列化以及解编码，且网络当中只能传输二进制的数据

  request => 转化为二进制数据 => 写入本地socket中 => 经网卡发送到网络 => TCP通道（数据包）

  client发送的二进制request数据会进入TCP数据包，可能一个request请求数据被拆分成好几个数据包，也可能合并其他的request请求数据；对于server端而言，从TCP通道中接收到的很多二进制数据，为了辨识出完整的request请求，因此需要一套协议来对数据进行分割。

  类比文章+标点

- 协议的设计

  想法：用一个固定长度（eg：4byte）保存整个request请求的大小，然后用一个可变长度保存request的数据

  => 消息头+消息体

  - 消息头
    1. 确定消息的边界
    2. 序列化方式
    3. 消息ID、类型
    4. 协议类型、版本
    5. ......
  - 消息体
    1. 请求的接口方法
    2. 请求的业务参数
    3. 请求的扩展属性

  存在的问题：定长的协议头导致不可扩展 => 协议头里面不能加新的参数

  **思考**：为啥新参数不能加在变长度的消息体里

  总结：协议头固定部分 + 协议头扩展部分 + 协议体

- RPC协议如何实现请求与响应关联的呢

































