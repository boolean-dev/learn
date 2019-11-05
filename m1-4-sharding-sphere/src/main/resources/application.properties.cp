
#数据源名称，多数据源以逗号分隔
spring.shardingsphere.datasource.names= ds0,ds1

#数据库连接池类名称
spring.shardingsphere.datasource.ds0.type= com.zaxxer.hikari.HikariDataSource
#数据库驱动类名
spring.shardingsphere.datasource.ds0.driver-class-name= com.mysql.jdbc.Driver
#数据库url连接
spring.shardingsphere.datasource.ds0.url= jdbc:mysql://127.0.0.1:3306/db_user1?characterEncoding=utf-8
#数据库用户名
spring.shardingsphere.datasource.ds0.username= root
#数据库密码
spring.shardingsphere.datasource.ds0.password=123456
#数据库连接池的其它属性
#spring.shardingsphere.datasource.ds0.xxx=

spring.shardingsphere.datasource.ds1.type= com.zaxxer.hikari.HikariDataSource
#数据库驱动类名
spring.shardingsphere.datasource.ds1.driver-class-name= com.mysql.jdbc.Driver
#数据库url连接
spring.shardingsphere.datasource.ds1.url= jdbc:mysql://127.0.0.1:3306/db_user2?characterEncoding=utf-8
#数据库用户名
spring.shardingsphere.datasource.ds1.username= root
#数据库密码
spring.shardingsphere.datasource.ds1.password=123456

#由数据源名 + 表名组成，以小数点分隔。多个表以逗号分隔，支持inline表达式。缺省表示使用已知数据源与逻辑表名称生成数据节点。用于广播表（即每个库中都需要一个同样的表用于关联查询，多为字典表）或只分库不分表且所有库的表结构完全一致的情况
spring.shardingsphere.sharding.tables.tb_user.actual-data-nodes= ds$->{id % 2}

#分库策略，缺省表示使用默认分库策略，以下的分片策略只能选其一

#用于单分片键的标准分片场景
#分片列名称
spring.shardingsphere.sharding.tables.tb_user.database-strategy.standard.sharding-column=id
#精确分片算法类名称，用于=和IN。该类需实现PreciseShardingAlgorithm接口并提供无参数的构造器
#spring.shardingsphere.sharding.tables.<logic-table-name>.database-strategy.standard.precise-algorithm-class-name=
#范围分片算法类名称，用于BETWEEN，可选。该类需实现RangeShardingAlgorithm接口并提供无参数的构造器
#spring.shardingsphere.sharding.tables.<logic-table-name>.database-strategy.standard.range-algorithm-class-name=

#用于多分片键的复合分片场景
#spring.shardingsphere.sharding.tables.<logic-table-name>.database-strategy.complex.sharding-columns= #分片列名称，多个列以逗号分隔
#spring.shardingsphere.sharding.tables.<logic-table-name>.database-strategy.complex.algorithm-class-name= #复合分片算法类名称。该类需实现ComplexKeysShardingAlgorithm接口并提供无参数的构造器

#行表达式分片策略
#spring.shardingsphere.sharding.tables.<logic-table-name>.database-strategy.inline.sharding-column= #分片列名称
#spring.shardingsphere.sharding.tables.<logic-table-name>.database-strategy.inline.algorithm-expression= #分片算法行表达式，需符合groovy语法

#Hint分片策略
#Hint分片算法类名称。该类需实现HintShardingAlgorithm接口并提供无参数的构造器
#spring.shardingsphere.sharding.tables.tb_user.database-strategy.hint.algorithm-class-name=

#分表策略，同分库策略
#省略
#spring.shardingsphere.sharding.tables.tb_user.table-strategy.xxx=

#自增列名称，缺省表示不使用自增主键生成器
spring.shardingsphere.sharding.tables.<logic-table-name>.key-generator.column=
#自增列值生成器类型，缺省表示使用默认自增列值生成器。可使用用户自定义的列值生成器或选择内置类型：SNOWFLAKE/UUID/LEAF_SEGMENT
spring.shardingsphere.sharding.tables.<logic-table-name>.key-generator.type=
#属性配置, 注意：使用SNOWFLAKE算法，需要配置worker.id与max.tolerate.time.difference.milliseconds属性
spring.shardingsphere.sharding.tables.<logic-table-name>.key-generator.props.<property-name>=

spring.shardingsphere.sharding.binding-tables[0]= #绑定表规则列表
spring.shardingsphere.sharding.binding-tables[1]= #绑定表规则列表
spring.shardingsphere.sharding.binding-tables[x]= #绑定表规则列表

spring.shardingsphere.sharding.broadcast-tables[0]= #广播表规则列表
spring.shardingsphere.sharding.broadcast-tables[1]= #广播表规则列表
spring.shardingsphere.sharding.broadcast-tables[x]= #广播表规则列表

spring.shardingsphere.sharding.default-data-source-name= #未配置分片规则的表将通过默认数据源定位
spring.shardingsphere.sharding.default-database-strategy.xxx= #默认数据库分片策略，同分库策略
spring.shardingsphere.sharding.default-table-strategy.xxx= #默认表分片策略，同分表策略
spring.shardingsphere.sharding.default-key-generator.type= #默认自增列值生成器类型，缺省将使用org.apache.shardingsphere.core.keygen.generator.impl.SnowflakeKeyGenerator。可使用用户自定义的列值生成器或选择内置类型：SNOWFLAKE/UUID/LEAF_SEGMENT
spring.shardingsphere.sharding.default-key-generator.props.<property-name>= #自增列值生成器属性配置, 比如SNOWFLAKE算法的worker.id与max.tolerate.time.difference.milliseconds

#spring.shardingsphere.sharding.master-slave-rules.<master-slave-data-source-name>.master-data-source-name= #详见读写分离部分
#spring.shardingsphere.sharding.master-slave-rules.<master-slave-data-source-name>.slave-data-source-names[0]= #详见读写分离部分
#spring.shardingsphere.sharding.master-slave-rules.<master-slave-data-source-name>.slave-data-source-names[1]= #详见读写分离部分
#spring.shardingsphere.sharding.master-slave-rules.<master-slave-data-source-name>.slave-data-source-names[x]= #详见读写分离部分
#spring.shardingsphere.sharding.master-slave-rules.<master-slave-data-source-name>.load-balance-algorithm-class-name= #详见读写分离部分
#spring.shardingsphere.sharding.master-slave-rules.<master-slave-data-source-name>.load-balance-algorithm-type= #详见读写分离部分

#是否开启SQL显示，默认值: false
spring.shardingsphere.props.sql.show= true
#工作线程数量，默认值: CPU核数
#spring.shardingsphere.props.executor.size=