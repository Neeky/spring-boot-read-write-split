## 创建 MySQL 用户
```sql
_create user appwrite@'%' identified by 'appW@2022';
create user appread@'%' identified by 'appR@2022';

grant insert,update,delete,select on *.* to appwrite@'%';
grant select on *.* to appread@'%';_

```

---

## 建表
```sql
create table tempdb.person(id int primary key auto_increment,name varchar(32),age int);
```
---

## 配置数据源
```ini
spring.datasource.url=jdbc:mysql://centos7.local:3306/tempdb
spring.datasource.username=appwrite
spring.datasource.password=appW@2022
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
1、 url 配置项的开头为 `jdbc:mysql` 不要使用写成 jdbc 这样的话程序认识不了.

2、 url 的 database 部分不能有 `/` 作为结果，程序会把这个 `/` 看成 database 的一部分.

3、 spring.datasource.driver-class-name 要指定不然会找不到。

---