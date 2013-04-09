1、核心容器：核心容器提供 Spring 框架的基本功能。核心容器的主要组件是 BeanFactory，它是工厂模式的实现。BeanFactory 使用控制反转 （IOC） 模式将应用程序的配置和依赖性规范与实际的应用程序代码分开。 

2、Spring 上下文：Spring 上下文是一个配置文件，向 Spring 框架提供上下文信息。Spring 上下文包括企业服务，例如 JNDI、EJB、电子邮件、国际化、校验和调度功能。 

3、Spring AOP：通过配置管理特性，Spring AOP 模块直接将面向方面的编程功能集成到了 Spring 框架中。所以，可以很容易地使 Spring 框架管理的任何对象支持 AOP。Spring AOP 模块为基于 Spring 的应用程序中的对象提供了事务管理服务。通过使用 Spring AOP，不用依赖 EJB 组件，就可以将声明性事务管理集成到应用程序中。 

4、Spring DAO：JDBC DAO 抽象层提供了有意义的异常层次结构，可用该结构来管理异常处理和不同数据库供应商抛出的错误消息。异常层次结构简化了错误处理，并且极大地降低了需要编写的异常代码数量（例如打开和关闭连接）。Spring DAO 的面向 JDBC 的异常遵从通用的 DAO 异常层次结构。 

5、Spring ORM：Spring 框架插入了若干个 ORM 框架，从而提供了 ORM 的对象关系工具，其中包括 JDO、Hibernate 和 iBatis SQL Map。所有这些都遵从 Spring 的通用事务和 DAO 异常层次结构。 

6、Spring Web 模块：Web 上下文模块建立在应用程序上下文模块之上，为基于 Web 的应用程序提供了上下文。所以，Spring 框架支持与 Jakarta Struts 的集成。Web 模块还简化了处理多部分请求以及将请求参数绑定到域对象的工作。 

7、Spring MVC 框架：MVC 框架是一个全功能的构建 Web 应用程序的 MVC 实现。通过策略接口，MVC 框架变成为高度可配置的，MVC 容纳了大量视图技术，其中包括 JSP、Velocity、Tiles、iText 和 POI。Spring 框架的功能可以用在任何 J2EE 服务器中，大多数功能也适用于不受管理的环境。Spring 的核心要点是：支持不绑定到特定 J2EE 服务的可重用业务和数据访问对象。毫无疑问，这样的对象可以在不同J2EE 环境（Web 或EJB）、独立应用程序、测试环境之间重用。


spring jar包结构

aspectj目录下是在Spring框架下使用aspectj的源代码和测试程序文件。Aspectj是java最早的提供AOP的应用框架。

dist 目录下是Spring 的发布包，关于发布包下面会详细进行说明。

docs 目录下是相关的文档，包括有Spring api 的javadoc、reference 参考指南、Spring的标签库使用文件及Spring MVC 的MVC-step-by-step 讲解与示例。都是很好的文档，值得好好研究一下。

lib 目录下是Spring 所依赖的第三方开源包。

mock 目录下是Spring 辅助应用测试的Mock 源程序。

samples 目录下是Spring 的示例源程序及简单的webapp 示例框架的示例配置，值得好好学习的有jpetstore 及petclinic，当然其它的countries、imagedb、tiles-example 也可以好好参考一下。

src 目录下是Spring 的源程序。

test 目录下Spring 的单元测试源程序。

tiger 目录下是针对在Spring框架中使用java 1.5的源程序及测试程序。Tiger是jdk 1.5版本的开发代号。

接下来详细说说dist 目录下jar 包的相关内容。了解这些内容有助于我们减小发布包的大小，同时也可以增加对Spring架构的了解。

spring.jar 是包含有完整发布模块的单个jar 包。但是不包括mock.jar, aspects.jar, spring-portlet.jar, and spring-hibernate2.jar。

spring-src.zip就是所有的源代码压缩包。

除了spring.jar 文件，Spring 还包括有其它21 个独立的jar 包，各自包含着对应的Spring组件，用户可以根据自己的需要来选择组合自己的jar 包，而不必引入整个spring.jar 的所有类文件。

spring-core.jar

这个jar 文件包含Spring 框架基本的核心工具类。Spring 其它组件要都要使用到这个包里的类，是其它组件的基本核心，当然你也可以在自己的应用系统中使用这些工具类。

外部依赖Commons Logging， (Log4J)。

spring-beans.jar

这个jar 文件是所有应用都要用到的，它包含访问配置文件、创建和管理bean 以及进行Inversion of Control / Dependency Injection（IoC/DI）操作相关的所有类。如果应用只需基本的IoC/DI 支持，引入spring-core.jar 及spring-beans.jar 文件就可以了。

外部依赖spring-core，(CGLIB)。

spring-aop.jar

这个jar 文件包含在应用中使用Spring 的AOP 特性时所需的类和源码级元数据支持。使用基于AOP 的Spring特性，如声明型事务管理（Declarative Transaction Management），也要在应用里包含这个jar包。

外部依赖spring-core， (spring-beans，AOP Alliance， CGLIB，Commons Attributes)。

spring-context.jar

这个jar 文件为Spring 核心提供了大量扩展。可以找到使用Spring ApplicationContext特性时所需的全部类，JDNI 所需的全部类，instrumentation组件以及校验Validation 方面的相关类。

外部依赖spring-beans, (spring-aop)。

spring-dao.jar

这个jar 文件包含Spring DAO、Spring Transaction 进行数据访问的所有类。为了使用声明型事务支持，还需在自己的应用里包含spring-aop.jar。

外部依赖spring-core，(spring-aop， spring-context， JTA API)。

spring-jdbc.jar

这个jar 文件包含对Spring 对JDBC 数据访问进行封装的所有类。

外部依赖spring-beans，spring-dao。

spring-support.jar

这个jar 文件包含支持UI模版（Velocity，FreeMarker，JasperReports），邮件服务，脚本服务(JRuby)，缓存Cache（EHCache），任务计划Scheduling（uartz）方面的类。

外部依赖spring-context, (spring-jdbc, Velocity, FreeMarker, JasperReports, BSH, Groovy, JRuby, Quartz, EHCache)

spring-web.jar

这个jar 文件包含Web 应用开发时，用到Spring 框架时所需的核心类，包括自动载入Web Application Context 特性的类、Struts 与JSF 集成类、文件上传的支持类、Filter 类和大量工具辅助类。

外部依赖spring-context, Servlet API, (JSP API, JSTL, Commons FileUpload, COS)。

spring-webmvc.jar

这个jar 文件包含Spring MVC 框架相关的所有类。包括框架的Servlets，Web MVC框架，控制器和视图支持。当然，如果你的应用使用了独立的MVC 框架，则无需这个JAR 文件里的任何类。

外部依赖spring-web, (spring-support，Tiles，iText，POI)。

spring-portlet.jar

spring自己实现的一个类似Spring MVC的框架。包括一个MVC框架和控制器。

外部依赖spring-web， Portlet API，(spring-webmvc)。

spring-struts.jar

Struts框架支持，可以更方便更容易的集成Struts框架。

外部依赖spring-web，Struts。

spring-remoting.jar

这个jar 文件包含支持EJB、远程调用Remoting（RMI、Hessian、Burlap、Http Invoker、JAX-RPC）方面的类。

外部依赖spring-aop， (spring-context，spring-web，Hessian，Burlap，JAX-RPC，EJB API)。

spring-jmx.jar

这个jar包提供了对JMX 1.0/1.2的支持类。

外部依赖spring-beans，spring-aop， JMX API。

spring-jms.jar

这个jar包提供了对JMS 1.0.2/1.1的支持类。

外部依赖spring-beans，spring-dao，JMS API。

spring-jca.jar

对JCA 1.0的支持。

外部依赖spring-beans，spring-dao， JCA API。

spring-jdo.jar

对JDO 1.0/2.0的支持。

外部依赖spring-jdbc， JDO API， (spring-web)。

spring-jpa.jar

对JPA 1.0的支持。

外部依赖spring-jdbc， JPA API， (spring-web)。

spring-hibernate3.jar

对Hibernate 3.0/3.1/3.2的支持。

外部依赖spring-jdbc，Hibernate3，(spring-web)。

spring-toplink.jar

对TopLink框架的支持。

外部依赖spring-jdbc，TopLink。

spring-ibatis.jar

对iBATIS SQL Maps的支持。

外部依赖spring-jdbc，iBATIS SQL Maps。

另外的两个包。

spring-mock.jar

这个jar 文件包含Spring 一整套mock 类来辅助应用的测试。Spring 测试套件使用了其中大量mock 类，这样测试就更加简单。模拟HttpServletRequest 和HttpServletResponse 类在Web 应用单元测试是很方便的。并且提供了对JUnit的支持。

外部依赖spring-core。

spring-aspects.jar

提供对AspectJ的支持，以便可以方便的将面向方面的功能集成进IDE中，比如Eclipse AJDT。

外部依赖。

WEAVER JARS (dist/weavers)说明。

spring-agent.jar

Spring的InstrumentationSavingAgent (为InstrumentationLoadTimeWeaver)，一个设备代理包，可以参考JDK1.5的Instrumentation功能获得更多信息。

外部依赖none (for use at JVM startup: "-javaagent:spring-agent.jar")。

spring-tomcat-weaver.jar

扩展Tomcat的ClassLoader，使其可以使用instrumentation（设备）类。

外部依赖none (for deployment into Tomcat's "server/lib" directory)。

如果需要使用JSP语言作为Spring's web MVC tags的参数，则需要JSP 2.0的支持。或者选择Jakarta的JSTL (standard.jar)。

如何选择这些发布包，决定选用哪些发布包其实相当简单。如果你正在构建Web 应用并将全程使用Spring，那么最好就使用单个全部的spring.jar 文件；如果你的应用仅仅用到简单的Inversion of Control / Dependency Injection（IoC/DI）容器，那么只需spring-core.jar与spring-beans.jar 即可；如果你对发布的大小要求很高，那么就得精挑细选了，只取包含自己所需特性的jar 文件了。采用独立的发布包你可以避免包含自己的应用不需要的全部类。

当然你可以采用其它的一些工具来设法令整个应用包变小，节省空间的重点在于准确地找出自己所需的Spring 依赖类，然后合并所需的类与包就可以了。Eclispe 有个插件叫ClassPathHelper 可以帮你找找所依赖的类


Spring包依赖说明:
1)      spring-core.jar需commons-collections.jar，spring-core.jar是以下其它各个的基本。
2)      spring-beans.jar需spring-core.jar，cglib-nodep-2.1_3.jar
3)      spring-aop.jar需spring-core.jar，spring-beans.jar，cglib-nodep-2.1_3.jar，aopalliance.jar
4)      spring-context.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，commons-collections.jar，aopalliance.jar
5)      spring-dao.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring-context.jar
6)      spring-jdbc.jar需spring-core.jar，spring-beans.jar，spring-dao.jar
7)      spring-web.jar需spring-core.jar，spring-beans.jar，spring-context.jar
8)      spring-webmvc.jar需spring-core.jar/spring-beans.jar/spring-context.jar/spring-web.jar
9)      spring -hibernate.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring- dao.jar，spring-jdbc.jar，spring-orm.jar，spring-web.jar，spring-webmvc.jar
10) spring-orm.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring-dao.jar，spring-jdbc.jar，spring-web.jar，spring-webmvc.jar
11) spring -remoting.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring- dao.jar，spring-context.jar，spring-web.jar，spring-webmvc.jar
12) spring-support.jar需spring-core.jar，spring-beans.jar，spring-aop.jar，spring-dao.jar，spring-context.jar，spring-jdbc.jar
13) spring-mock.jar需spring-core.jar，spring-beans.jar，spring-dao.jar，spring-context.jar，spring-jdbc.jar 
