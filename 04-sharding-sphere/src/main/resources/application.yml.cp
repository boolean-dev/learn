
sharding:
  jdbc:
    datasource:
      names: ds0,ds1
    #第一个数据库
    ds0:
      type: com.zaxxer.hikari.HikariDataSource
      driver-class-name: com.mysql.jdbc.Driver
      jdbc-url: jdbc:mysql://127.0.0.1:3306/db_user1?characterEncoding=utf-8
      username: root
      password: 123456
    #第二个数据库
    ds0:
      type: com.zaxxer.hikari.HikariDataSource
      driver-class-name: com.mysql.jdbc.Driver
      jdbc-url: jdbc:mysql://127.0.0.1:3306/db_user2?characterEncoding=utf-8
      username: root
      password: 123456
    config:
      sharding:
        default-database-strategy:
          inline:
            sharding-column: id
            algorithm-expression: ds$->{id % 2}
        tables:
          tb_user:
            actual-data-nodes: ds$->{0..1}.user_$->{0..1}
            table-strategy:
              inline:
                sharding-column: age
                algorithm-expression: user_$->{age % 2}
        tables:
          user:
            key-generator-column-name: id
    props:
      sql.show: true
spring:
  main:
    allow-bean-definition-overriding: true