## 研发知识学习

- **.gitignore文件是什么**

  .gitignore文件是一个用于Git版本控制系统的特殊文件，用于指定Git版本控制系统中哪些文件和目录应该被忽略，以避免将不必要的文件添加到版本控制系统中。 

  该文件中列出的文件和目录将不会被Git跟踪和提交。一般情况下，.gitignore文件会列出一些临时文件、日志文件、编译生成的文件、与系统环境相关的文件等等，确保这些文件不会被意外添加到版本库中，从而保持版本库的干净和安全。 

  .gitignore文件通常位于Git仓库的根目录，但你也可以在任意的子目录中添加一个.gitignore文件，以覆盖更普遍的文件忽略规则。

- **.gitignore写法**

  .gitignore文件应该按照规则编写。一个规则占一行，每个规则表示一个文件或目录需要被忽略。常用的规则格式如下：

  - 以`#`开头的行为注释，会被Git忽略。
  - 可以使用`*`符号匹配任意字符，比如`*.txt`可以匹配一类以".txt"结尾的文件。
  - 如果路径以`/`结尾，表示只忽略目录，不忽略同名的文件。比如`/foo/`表示忽略根目录下的`foo/`目录，但不包括`foo.txt`。
  - 如果路径以`/`开头，表示从项目根目录下开始匹配，比如`/*.txt`表示忽略根目录下的所有`.txt`文件。
  - 如果路径中包含`/`，表示忽略嵌套的目录，比如`foo/bar/`表示忽略`foo`目录下的`bar`目录。
  - 可以在行末添加`/`表示路径表示一个目录，而不是文件。比如`foo/`表示忽略所有同名目录，但不包括同名的文件。
  - 可以在行末添加`!`表示反选，即不被忽略，比如`!foo/bar/`表示不忽略`foo`目录下的`bar`目录。

  一个.gitignore文件可以包含多个规则，例如：

  ```
  # 忽略所有Build产生的文件
  build/
  
  # 不忽略libs下的foo目录
  !libs/foo
  
  # 忽略所有log文件
  *.log
   
  # 不忽略根目录下的log.txt文件
  !/log.txt
  
  # 忽略所有生成的jar包
  *.jar
  ```

- **POM**

1. `<dependencyManagement>` 

   <dependencyManagement>是 Maven POM（Project Object Model）的元素之一，它允许用户集中管理项目中使用的所有依赖项的版本号。`<dependencyManagement>` 元素只定义需要使用的依赖项和相应的版本，它并不实际引入这些依赖项。

   当 Maven 处理依赖项时，它会首先查找 `<dependencyManagement>`，并使用它来管理项目中所有依赖项的版本。这使得用户可以管理和维护项目中的所有依赖项版本，而不必在每个依赖项中指定版本号，提高了项目的可维护性。

2. `<profiles>` 

   <profiles>是 Maven POM（Project Object Model）的元素之一，它允许用户为不同的构建环境定义特定的构建配置。一个项目可能需要在不同的构建环境中使用不同的依赖项、插件或构建配置。Maven 允许用户使用 `<profiles>` 元素来定义不同的构建配置。

   在 `<profiles>` 元素中，用户可以定义一组 `<activation>` 规则，用于检测在该构建环境下该 `<profile>` 应该启用的条件。当这些条件被满足时，该 `<profile>` 中定义的所有配置都将被应用。

3. `<build>` 

   <build>是 Maven POM（Project Object Model）的元素之一，它是 Maven 构建的核心元素之一，用于定义项目的构建配置。`<build>` 元素包含了一系列子元素，如 `<plugins>`、`<pluginManagement>`、`<resources>`、`<testResources>`、`<extensions>` 等，这些子元素定义了项目的依赖、插件、构建输出目录、Maven 执行插件的配置等。

   通常，在 POM 文件中定义的构建配置只应该包含与构建相关的元素。以下是一些经常用到的子元素：

   - `<plugins>`：声明了 Maven 插件的配置和使用，这是使用 Maven 构建应用程序所必须的。如下示例：

     ```
     <plugins>
       <plugin>
         <groupId>org.apache.maven.plugins</groupId>
         <artifactId>maven-compiler-plugin</artifactId>
         <version>3.8.0</version>
         <configuration>
           <source>1.8</source>
           <target>1.8</target>
         </configuration>
       </plugin>

       <plugin>
         <groupId>org.springframework.boot</groupId>
         <artifactId>spring-boot-maven-plugin</artifactId>
         <version>2.4.4</version>
       </plugin>
     </plugins>
     ```

   - `<pluginManagement>`：这个元素用来管理 `<plugins>` 元素中配置的 Maven 插件。如下示例：

     ```
     <build>
       <pluginManagement>
         <plugins>
           <plugin>
             <groupId>org.apache.maven.plugins</groupId>
             <artifactId>maven-compiler-plugin</artifactId>
             <version>3.8.0</version>
             <configuration>
               <source>1.8</source>
               <target>1.8</target>
             </configuration>
           </plugin>

           <plugin>
             <groupId>org.springframework.boot</groupId>
             <artifactId>spring-boot-maven-plugin</artifactId>
             <version>2.4.4</version>
           </plugin>
         </plugins>
       </pluginManagement>
     </build>
     ```

   - `<resources>`：定义了项目的资源目录，该目录下的所有资源将被编译到输出目录中。如下示例：

     ```
     <resources>
       <resource>
         <directory>src/main/resources</directory>
         <filtering>true</filtering>
         <includes>
           <include>**/*.xml</include>
           <include>**/*.json</include>
         </includes>
       </resource>
     </resources>
     ```

   - `<testResources>`：与 `<resources>` 元素类似，但是它会编译到测试输出目录中。如下示例：

     ```
     <testResources>
       <testResource>
         <directory>src/test/resources</directory>
         <filtering>true</filtering>
         <includes>
           <include>**/*.xml</include>
         </includes>
       </testResource>
     </testResources>
     ```

   - `<extensions>`：定义了 Maven 扩展的配置。如下示例：

     ```
     <extensions>
       <extension>
         <groupId>com.oracle.database.jdbc</groupId>
         <artifactId>ojdbc8</artifactId>
         <version>12.2.0.1</version>
       </extension>
     </extensions>
     ```

   在 Maven POM 中，`<build>` 元素是一个可选项。如果没有明确声明一个 `<build>` 元素，Maven 会使用默认值进行构建。此时，Maven 会使用默认的构建输出目录（`target` 目录），默认的编译目标版本（JDK 1.5），默认的源文件目录等。

- **stream流**

  在使用Stream之前，首先需要获取一个Stream对象，Stream对象可以通过将一个Collection接口中的数据流式化由顺序转为流来获取。

  简单获取方式：

  1. 通过集合对象获取：

  ```java
  List<String> list = Arrays.asList("a", "b", "c");
  Stream<String> stream1 = list.stream();
  ```

  2. 通过Arrays 中的静态方法获取数组对象来获取：

  ```java
  String[] strArray = new String[]{"a", "b", "c"};
  Stream<String> stream2 = Arrays.stream(strArray);
  ```

  3. 通过Stream中的静态方法 of 方法获取：

  ```java
  Stream<String> stream3 = Stream.of("a", "b", "c");
  ```

  获取到Stream对象后就可以开始对流数据实现简单的操作：

  1. forEach：遍历流中的元素

  ```java
  stream.forEach(System.out::println); //输出流中的所有元素
  ```

  2. filter：按照条件过滤

  ```java
  stream.filter(ele -> ele.startsWith("a")).forEach(System.out::println); //输出流中以"a"开始的所有元素
  ```

  3. map：将流中的每一个元素按照指定方式进行转换

  ```java
  stream.map(ele -> ele.toUpperCase()).forEach(System.out::println); //将流中的每个字母都转为大写字母输出
  ```

  4. limit：只获取流中的前n个元素

  ```java
  stream.limit(2).forEach(System.out::println); //只输出流中的前两个元素
  ```

  5. sorted：对流中的元素进行排序

  ```java
  stream.sorted().forEach(System.out::println); //对流中的元素进行自然排序
  ```

  6. distinct：去重

  ```java
  stream.distinct().forEach(System.out::println); //去除流中的重复元素
  ```

  除了以上这些常用的方法之外，Stream还提供了很多其他的方法。需要根据具体的业务需求来选择正确的方法进行操作。

  注意：每次调用Terminal Operations（输出类操作）都会走遍历整个流的流程。

  1. filter：过滤
  2. map：映射
  3. limit：限制返回个数
  4. skip：跳过指定数量的元素
  5. sorted：排序
  6. distinct：去重
  7. foreach：遍历
  8. count：计数
  9. collect：归约（将Stream中的数据转换为一个集合或者计算结果）

  总之，使用Stream可以通过简单的操作来处理集合中的数据，并且Stream API提供了大量方法支持多种操作，需要根据具体的业务需求来选择正确的方法进行操作。

- **CI/CD**

  CI/CD是指持续集成/持续交付（Continuous Integration/Continuous Delivery）。

  持续集成是指软件开发团队通过对代码变更的频繁性进行自动化测试，以尽早发现和解决问题，从而缩短开发周期并提高软件质量。

  持续交付则是指将经过持续集成和自动化测试后的软件交付给应用程序部署团队进行部署和验证。通过持续交付，软件开发团队可以更快地将新功能和改进的代码交付给最终用户，从而提高软件交付的速度和质量。

  CI/CD的关键是自动化。自动化可以帮助软件开发团队快速检测到问题并加快修复速度，提高软件质量，同时可以实现快速而稳定的软件部署，减少重复工作和减少出错率。

  现在有很多CI/CD工具可以帮助开发团队实现自动化流程，如Jenkins、Travis CI、CircleCI等等。这些工具可以轻松集成版本控制、构建工具、自动化测试、部署工具等流程，从而全方位的提升软件开发和部署的效率，并提高应用程序的可靠性和可用性。

  - **Redis Cluster**

    1. 集群方案

      - 客户端Proxy分片

        优：不使用第三方中间件，实现方法和代码可以自己掌控并且可随时调整。这种分片性能比代理式更好(因为少了分发环节)，分发压力在客户端，无服务端压力增加

        缺：不能平滑地水平扩容，扩容/缩容时，必须手动调整分片程序，出现故障不能自动转移，难以运维

      - 代理层分片

        优：运维成本低。业务方不用关心后端 Redis 实例，跟操作单点 Redis 实例一样。***Proxy*** 的逻辑和存储的逻辑是隔离的

        缺：代理层多了一次转发，性能有所损耗；进行扩容/缩容时候，部分数据可能会失效，需要手动进行迁移，对运维要求较高，而且难以做到平滑的扩缩容；出现故障，不能自动转移，运维性很差。Codis 做了诸多改进，相比于  [***Twemproxy***](https://github.com/twitter/twemproxy) 可用性和性能都好得多

      - redis cluster

        优：无中心节点，数据按照 ***slot*** 存储分布在多个 Redis 实例上，平滑的进行扩容/缩容节点，自动故障转移（节点之间通过 Gossip 协议交换状态信息,进行投票机制完成 ***slave*** 到 ***master*** 角色的提升）降低运维成本，提高了系统的可扩展性和高可用性

        缺：开源版本缺乏监控管理，原生客户端太过简陋，***failover*** 节点的检测过慢，维护 ***Membership*** 的 ***Gossip*** 消息协议开销大，无法根据统计区分冷热数据

    2. 哈希槽内部实现

       clusterNode:{

       ​		int[ ] slots;

       }

       **重要：**

       Redis 集群中每个节点都会维护集群中所有节点的 ***clusterNode*** 结构体，其中的 ***slots*** 属性是个二进制位数组，长度为 2048 bytes，共包含 16384 个 ***bit*** 位，节点可以根据某个 ***bit*** 的 0/1 值判断对应的 ***slot*** 是否由当前节点处理。每个节点通过 ***clusterStats*** 结构体来保存从自身视角看去的集群状态，其中 ***nodes*** 属性是一个保存节点名称和 ***clusterNode*** 指针的字典，而 ***slots*** 数组是一个记录哪个 ***slot*** 属于哪个 ***clusterNode*** 结构体的数组。

       clusterStats中的nodes属性 => KV字典

       k => 集群中的节点名称

       v => 节点的clusterNode指针

       slots => clusterNode结构中的二进制位数组，用来描述该节点所维护的slot是哪些

       线上集群因为扩容和缩容操作，经常需要迁移 ***slot*** 对数据进行重新分片，原生的 Redis Cluster 可以借助 [***redis-trib***](http://download.redis.io/redis-stable/src/redis-trib.rb) 工具进行迁移；

       ***slot*** 在迁移过程有两个状态，在迁出节点会对该 ***slot*** 标记为 ***MIGRATING***，在迁入节点会对该 ***slot*** 标记为 ***IMPORTING。***当该 ***slot*** 内的 ***Key*** 都迁移完毕之后，新的 ***slot*** 归属信息都进过消息协议进行传播，最终集群中所有节点都会知道该 ***slot*** 已经迁移到了目标节点，并更新自身保存的 slot 和节点间的映射关系。

    3. MOVED & ASK

       ***MOVED*** 意为这个 ***slot*** 的负责已经永久转交给另一个节点，因此可以直接把请求准发给现在负责该 ***slot*** 的节点。

       在 ***slot*** 迁移过程中，会出现属于该 ***slot*** 的一部分 Key 已经迁移到目的地节点，而另一部分 Key 还在源节点，那如果这时收到了关于这个 ***slot*** 的请求，那么源节点会先在自己的数据库里查找是否有这个 Key，查到的话说明还未迁移那么直接返回结果，查询失败的话就说明 Key 已经迁移到目的地节点，那么就向客户端返回一个 ***ASK*** 错误，指引客户端转向目的地节点查询该 Key。

       这两个错误在实际线上环境中出现频率很高，那么定制化的客户端如何处理这二者呢？如果客户端每次都随机连接一个节点然后利用 ***MOVED*** 或者 ***ASK*** 来重定向其实是很低效的，所以一般客户端会在启动时通过解析 ***CLUSTER NODES*** 或者 ***CLUSTER SLOTS*** 命令返回的结果得到 ***slot*** 和节点的映射关系**缓存在本地**，一旦遇到 ***MOVED*** 或者 ***ASK*** 错误时会再次调用命令刷新本地路由（因为线上集群一旦出现 ***MOVED*** 或者是 ***ASK*** 往往是因为扩容分片导致数据迁移，涉及到许多 ***slot*** 的重新分配而非单个，因此需要整体刷新一次），这样集群稳定时可以直接通过本地路由表迅速找到需要连接的节点。

    4. 故障转移Failover

      - Epoch：Redis Cluster 使用了类似于 ***Raft*** 算法 ***term***（任期）的概念称为 ***epoch***（纪元），用来给事件增加版本号。Redis 集群中的纪元主要是两种：***currentEpoch*** 和 ***configEpoch***。

        1. currentEpoch:记录集群状态变更的递增版本号

           集群节点创建时，不管是 ***master*** 还是 ***slave***，都置 ***currentEpoch*** 为 0。当前节点接收到来自其他节点的包时，如果发送者的 ***currentEpoch***（消息头部会包含发送者的 ***currentEpoch***）大于当前节点的***currentEpoch***，那么当前节点会更新 ***currentEpoch*** 为发送者的 ***currentEpoch***。因此，集群中所有节点的 ***currentEpoch*** 最终会达成一致，相当于对集群状态的认知达成了一致。

           作用：集群节点创建时，不管是 ***master*** 还是 ***slave***，都置 ***currentEpoch*** 为 0。当前节点接收到来自其他节点的包时，如果发送者的 ***currentEpoch***（消息头部会包含发送者的 ***currentEpoch***）大于当前节点的***currentEpoch***，那么当前节点会更新 ***currentEpoch*** 为发送者的 ***currentEpoch***。因此，集群中所有节点的 ***currentEpoch*** 最终会达成一致，相当于对集群状态的认知达成了一致。

        2. configEpoch：这是一个集群节点配置相关的概念，每个集群节点都有自己独一无二的 configepoch。所谓的节点配置，实际上是指节点所负责的槽位信息。

           每一个 ***master*** 在向其他节点发送包时，都会附带其 ***configEpoch*** 信息，以及一份表示它所负责的 ***slots*** 信息。而 ***slave*** 向其他节点发送包时，其包中的 ***configEpoch*** 和负责槽位信息，是其 ***master*** 的 ***configEpoch*** 和负责的 ***slot*** 信息。节点收到包之后，就会根据包中的 ***configEpoch*** 和负责的 ***slots*** 信息，记录到相应节点属性中。

           作用： ***configEpoch*** 主要用于**解决不同的节点的配置发生冲突的情况**。举个例子就明白了：节点A 宣称负责 ***slot 1***，其向外发送的包中，包含了自己的 ***configEpoch*** 和负责的 ***slots*** 信息。节点 C 收到 A 发来的包后，发现自己当前没有记录 ***slot 1*** 的负责节点（也就是 server.cluster->slots[1] 为 NULL），就会将 A 置为 ***slot 1*** 的负责节点（server.cluster->slots[1] = A），并记录节点 A 的 ***configEpoch***。后来，节点 C 又收到了 B 发来的包，它也宣称负责 ***slot 1***，此时，如何判断 ***slot 1*** 到底由谁负责呢？

           这就是 ***configEpoch*** 起作用的时候了，C 在 B 发来的包中，发现它的 ***configEpoch***，要比 A 的大，说明 B 是更新的配置。因此，就将 ***slot 1*** 的负责节点设置为 B（server.cluster->slots[1] = B）。在 ***slave*** 发起选举，获得足够多的选票之后，成功当选时，也就是 ***slave*** 试图替代其已经下线的旧 ***master***，成为新的 ***master*** 时，会增加它自己的 ***configEpoch***，使其成为当前所有集群节点的 ***configEpoch*** 中的最大值。这样，该 ***slave*** 成为 ***master*** 后，就会向所有节点发送广播包，强制其他节点更新相关 ***slots*** 的负责节点为自己。

      - 自动Failover
  
          - 当一个 ***slave*** 发现自己正在复制的 ***master*** 进入了已下线（***FAIL***）状态时，***slave*** 将开始对已下线状态的 ***master*** 进行故障转移，以下是故障转移执行的步骤
          - 该下线的 ***master*** 下所有 ***slave*** 中，会有一个 ***slave*** 被选中。具体的选举流程为：slave 自增它的 ***currentEpoch*** 值，然后向其他 ***masters*** 请求投票，每个 ***slave*** 都向集群其他节点广播一条 CLUSTERMSG_TYPE_FAILOVER_AUTH_REQUEST 消息用于拉票，集群中具有投票权的 ***master*** 收到消息后，如果在当前选举纪元中没有投过票，就会向第一个发送来消息的 ***slave*** 返回 CLUSTERMSG_TYPE_FAILOVER_AUTH_ACK 消息，表示投票给该 ***slave***。某个 ***slave*** 如果在一段时间内收到了大部分 ***master*** 的投票，则表示选举成功。
          - 被选中的 ***slave*** 会执行 SLAVEOF no one 命令，成为新的 ***master***
          - 新的 ***master*** 会撤销所有对已下线 ***master*** 的 ***slot*** 指派，并将这些 ***slot*** 全部指派给自己
          - 新的 ***master*** 向集群广播一条 ***PONG*** 消息，这条 ***PONG*** 消息可以让集群中的其他节点立即知道自己已经由 ***slave*** 变成了 ***master*** ，并且这个 ***master*** 已经接管了原本由已下线节点负责处理的 ***slot***
          - 新的 ***master*** 开始接收和自己负责处理的 ***slot*** 有关的命令请求，故障转移完成
  
      - 手动Failover
  
        Redis 集群支持手动故障转移，也就是向 ***slave*** 发送 CLUSTER FAILOVER 命令，使其在 master 未下线的情况下，发起故障转移流程，升级为新的 ***master*** ，而原来的 ***master*** 降级为 ***slave***。
  
        为了不丢失数据，向 ***slave*** 发送 CLUSTER FAILOVER 命令后，流程如下：
  
        1. ***slave*** 收到命令后，向 ***master*** 发送 CLUSTERMSG_TYPE_MFSTART 命令
        2. ***master*** 收到该命令后，会将其所有客户端置于阻塞状态，也就是在 10s 的时间内，不再处理客户端发来的命令，并且在其发送的心跳包中，会带有 CLUSTERMSG_FLAG0_PAUSED 标记
        3. ***slave*** 收到 ***master*** 发来的，带 CLUSTERMSG_FLAG0_PAUSED 标记的心跳包后，从中获取 ***master*** 当前的复制偏移量，***slave*** 等到自己的复制偏移量达到该值后，才会开始执行故障转移流程：发起选举、统计选票、赢得选举、升级为 ***master*** 并更新配置
  
        CLUSTER FAILOVER 命令支持两个选项：***FORCE*** 和 ***TAKEOVER***。使用这两个选项，可以改变上述的流程。
  
        如果有 ***FORCE*** 选项，则 ***slave*** 不会与 ***master*** 进行交互，***master*** 也不会阻塞其客户端，而是 ***slave*** 立即开始故障转移流程：发起选举、统计选票、赢得选举、升级为 ***master*** 并更新配置。
  
        如果有 ***TAKEOVER*** 选项，则更加简单直接，***slave*** 不再发起选举，而是直接将自己升级为 ***master*** ，接手原 ***master*** 的 ***slot***，增加自己的 ***configEpoch*** 后更新配置。
  
        因此，使用 ***FORCE*** 和 ***TAKEOVER*** 选项，***master*** 可以已经下线；而不使用任何选项，只发送 CLUSTER FAILOVER 命令的话，***master*** 必须在线。

    5. Redis集群中的消息

     搭建 Redis Cluster 时，首先通过 CLUSTER MEET 命令将所有的节点加入到一个集群中，但是并没有在所有节点两两之间都执行 CLUSTER MEET 命令，因为节点之间使用 ***Gossip*** 协议进行工作。***Gossip*** 翻译过来就是流言，类似与病毒传播一样，只要一个人感染，如果时间足够，那么和被感染的人在一起的所有人都会被感染，因此随着时间推移，集群内的所有节点都会互相知道对方的存在。

     在 Redis 集群中，节点信息是如何传播的呢？答案是通过发送 PING 或 PONG 消息时，会包含节点信息，然后进行传播的。先介绍一下 Redis Cluster 中，消息是如何抽象的。一个消息对象可以是 ***PING、PONG、MEET***，也可以是 ***PUBLISH、FAIL*** 等。他们都是 clusterMsg 类型的结构，该类型主要由消息包头部和消息数据组成。

    - 消息包头部包含签名、消息总大小、版本和发送消息节点的信息。
    - 消息数据则是一个联合体 union clusterMsgData，联合体中又有不同的结构体来构建不同的消息。

     ***PING、PONG、MEET*** 属于一类，是 clusterMsgDataGossip 类型的数组，可以存放多个节点的信息，

     ```
     /* Initially we don't know our "name", but we'll find it once we connect
      * to the first node, using the getsockname() function. Then we'll use this
      * address for all the next messages. */
     typedef struct {
         // 节点名字
         char nodename[CLUSTER_NAMELEN];
         // 最近一次发送PING的时间戳
         uint32_t ping_sent;
         // 最近一次接收PONG的时间戳
         uint32_t pong_received;
         // 节点的IP地址
         char ip[NET_IP_STR_LEN];  /* IP address last time it was seen */
         // 节点的端口号
         uint16_t port;              /* port last time it was seen */
         // 节点的标识
         uint16_t flags;             /* node->flags copy */
         // 未使用
         uint16_t notused1;          /* Some room for future improvements. */
         uint32_t notused2;
     } clusterMsgDataGossip;
   
     ```

     每次发送 ***MEET、PING、PONG*** 消息时，发送者都从自己的已知节点列表中随机选出两个节点（可以是主节点或者从节点），并将这两个被选中节点的信息分别保存到两个结构中。当接收者收到消息时，接收者会访问消息正文中的两个结构，并根据自己是否认识 clusterMsgDataGossip 结构中记录的被选中节点进行操作：

    1. 如果被选中节点不存在于接收者的已知节点列表，那么说明接收者是第一次接触到被选中节点，接收者将根据结构中记录的IP地址和端口号等信息，与被选择节点进行握手。
    2. 如果被选中节点已经存在于接收者的已知节点列表，那么说明接收者之前已经与被选中节点进行过接触，接收者将根据 clusterMsgDataGossip 结构记录的信息，对被选中节点对应的 clusterNode 结构进行更新。

     有了消息之后，如何选择发送消息的目标节点呢？虽然 ***PING PONG*** 发送的频率越高就可以越实时得到其它节点的状态数据，但 ***Gossip*** 消息体积较大，高频发送接收会加重网络带宽和消耗 CPU 的计算能力，因此每次 Redis 集群都会有目的性地选择一些节点；但节点选择过少又会影响故障判断的速度，Redis 集群的 ***Gossip*** 协议选择这样的解决方案：

  6. 集群数据一致性

博客：

https://www.cnblogs.com/leeSmall/p/8414687.html

https://www.cnblogs.com/gqtcgq/p/7247042.html

https://cristian.regolo.cc/2015/09/05/life-in-a-redis-cluster.html




- **Redis HA**






















































