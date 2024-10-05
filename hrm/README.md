**需要完整代码可以加qq  1556708905 或者加微信 zheng0123Long**
**需要完整代码可以加qq  1556708905 或者加微信 zheng0123Long**

#人事管理系统 #java web #java #毕业设计 #课程设计 #mybatis #Springboot  #vue #mysql #源代码

## 基于Springboot+vue的人事管理系统(源代码+数据库+8000字文档)

## 一、系统介绍

本项目分为管理员与普通用户两种角色

管理员角色包含以下功能：

- 首页
  Echarts图表，个人考勤、员工基本信息
- 系统管理
  文件管理，员工管理，部门管理，部门管理
- 权限管理
  角色管理，菜单管理
- 薪资管理
  五险一金，参保城市，工资管理
- 考勤管理
  请假审批，考勤表现

用户角色包含以下功能：

- 个人信息
  修改密码，修改个人信息
- 请假管理
  请假申请

## 二、所用技术

- 前端技术栈
- Vue、Axios、ElementUI、Vue-Router、Vuex、ECharts

- 后端技术栈
- Spring Boot、JWT、MyBatis-Plus、MySQL、Hutool

## 三、环境介绍

基础环境 :IDEA/eclipse, JDK 1.8, Mysql5.7及以上,Node.js(14),Maven

所有项目以及源代码本人均调试运行无问题 可支持远程调试运行

## 四、项目截图

### 文档目录

![contents](./picture/picture21.png)

### 系统设计

#### 业务用例

![contents](./picture/picture18.png)

超级管理员拥有对所有菜单的访问权限，进行一系列的管理操作。而普通员工只能进行查看和修改个人信息，以及修改密码，请假。另外超级管理员可以为普通员工分配一些角色，进而改变员工的访问权限。

#### 功能结构

![contents](./picture/picture17.png)

本系统主要分四个模块，分别是系统管理和权限管理、薪资管理、考勤管理，系统管理主要用于日常事务管理管理，权限管理，用于控制员工的访问权限，薪资管理主要是对员工的五险一金以及社保数据的修改和添加，考勤管理主要是对员工的日常打卡进行记录和统计。

### 系统展示
#### 首页

![首页](./picture/picture1.png)

首页主要展示当前登录员工的一些基本信息，员工当前月的考勤数据，以及当日员工迟到、早退、旷工等情况。

#### 请假

![请假](./picture/picture19.png)

在请假面板中，员工可以进行请假。在左侧的请假记录中查看以往的请假记录，或对当前未被审核的申请进行撤销。

![审批](./picture/picture15.png)

管理员可以对员工的请假进行审批，比如通过或驳回。员工申请请假之后，等待管理员进行审批，如管理员审批通过，则将员工休假时间段的考勤状态设置为休假。

#### 五险一金

![五险一金](./picture/picture3.png)

![img](./picture/picture2.png)

社保模块主要展示了员工的社保情况，可以对员工的社保进行调整。

#### 工资管理

![工资管理](./picture/picture6.png)

显示员工当月的工资情况，以及当月的考勤罚款情况。可以导出员工当月的工资报表。

#### 考勤管理

![考勤管理](./picture/picture16.png)

考勤管理实现了考勤数据的批量导入与导出，以及员工考勤状态的查询和修改。

![考勤数据导入模板](https://image-qiu.oss-cn-hangzhou.aliyuncs.com/img/20220413222133.png)

通过导入员工的考勤记录表，系统就会根据员工所在部门规定的上班时间进行比对，判断员工是否迟到、早退、旷工。（这是数据导入的模板，需要按照此格式填写数据。系统只会读取上下班时间的时间部分，系统以考勤日期作为打卡日期）。

另外，介绍一下考勤规制：

* 若考勤日期对应的是周末，则不判读员工考勤状态，默认为休假。
* 若考勤日期对应的是员工请假的日期，则员工考勤状态设为休假。
* 若员工的四个打卡时间，只要有一个为空，则员工考勤状态设为旷工。
* 若员工既迟到又早退，则员工考勤状态设为旷工。
* 若员工迟到，则员工考勤状态设为迟到。
* 若员工早退，则员工考勤状态设为早退。
* 若不是以上任何情况，则员工考勤状态设为正常。
![contents](./picture/picture4.png)

![contents](./picture/picture5.png)

![contents](./picture/picture7.png)

![contents](./picture/picture8.png)

![contents](./picture/picture9.png)

![contents](./picture/picture10.png)

![contents](./picture/picture11.png)

![contents](./picture/picture12.png)

![contents](./picture/picture13.png)

![contents](./picture/picture14.png)

## 五、浏览地址

项目启动成功之后，访问http://localhost:8080/login

管理员账号：admin 密码：12345
员工账号：staff_2 密码：12345

## 六、安装教程

#### 项目配置

1. 前端

   在`.env`文件中

   ```xml
   # 修改端口号，此端口号与在application.yml中配置的端口号相同
   VUE_APP_PORT = 8888
   ```

2. 后端

   在`application.yml`中进行相关的配置

   ```xml
   # 这是后端项目的运行端口，可自行修改
   server:
     port: 8888
   
   # 修改数据源，若MySql数据库版本较低，此处应该是com.mysql.jdbc.Driver
   driver-class-name: com.mysql.cj.jdbc.Driver
   
   # 因为此项目涉及到了文件上传与下载，此路径用来存储上传的文件。
   files:
     upload:
       path: E:/project/idea/hrm/file/ # 修改为自己的路径
   ```

#### 项目启动

1. 新建数据库，将数据库文件执行

2. 克隆代码到本地，在vue-elementui-hrm目录下

   ```bash
   # 下载依赖
   npm install 
   
   # 启动
   npm run serve
   ```

3. 启动后端项目

4. 项目启动成功之后，访问http://localhost:8080/login

   账号：admin
   密码：12345

**需要完整代码可以加qq  1556708905 或者加微信 zheng0123Long**

**需要完整代码可以加qq  1556708905 或者加微信  zheng0123Long**



