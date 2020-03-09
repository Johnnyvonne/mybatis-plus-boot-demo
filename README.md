# mybatis-plus-boot-demo
## 使用方式
### 使用全局配置
mybatis-plus:  
  global-config:  
    db-config:  
      id-type: assign_id  
      capital-mode: true
### 主键
设置主键
### insert、update和remove
保存和更新使用mp api，继承IService
- 支持批量保存或更新  
- update支持动态条件，支持批量更新，支持自定义set字段
- remove支持动态条件，支持批量删除

### 查询
mp api查询支持动态条件，继承IService
- mp不支持entity声明式联表查询，所以单表查询可以使用mp api，但是不能自定义resultMap（只能在Table上指定一个）
- 如果需要联表查询，或自定义ResultMap，则最好使用xml
- 分页查询，如果自定义ResultMap需要使用xml，否则可以使用IService，支持动态条件

### 打包配置assembly
配置pom.xml plugins添加资源文件，否则打包后不会添加资源文件

### 公共字段自动填充
created_time，updated_time，deleted

### 支持RabbitMQ可靠消息分布式事务
### 动态数据源
1. dynamic-datasource-spring-boot-starter  
支持多数据库，主从库，不支持分布式事务
2. spring提供原生的 AbstractRoutingDataSource

### 支持动态表名

### 支持枚举
继承IEnum方式最灵活，注意JSON解析
### 逻辑删除
使用全局配置，entity可以不指定@TableLogic。逻辑删除字段要在建表语句指定默认值，或者使用公共字段填充  
mp api查询和更新会自动加上逻辑删除条件，手写sql需要自己添加删除条件。
### 乐观锁
需要注入Config bean
### 多租户
在多个客户共享表的情况下，实现多租户，效果是不用在sql语句中添加where tenant_id = ?  
缺点：特殊情况可能不灵活；如果更换持久化框架，无法兼容。
### typeHandler
根据情况使用，可设置javaType和JdbcType转换规则