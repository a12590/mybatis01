# mybatis01
## selectKey属性！！
    <selectKey
      keyProperty="id"
      resultType="int"
      order="BEFORE"
      statementType="PREPARED">
      
      在项目中，如果通过逆向工程生成的代码是不包含selectKey属性的，这个得自己加，比如，但往数据库插入数据时，用逆向工程生成的insertAuthor，此时得不到id，需要，通过selectKey。
      <selectKey keyProperty="id" resultType="int" order="BEFORE">
        select Last_insert_id()
      </selectKey>
      <insert id="insertAuthor">
       <selectKey keyProperty="id" resultType="int" order="BEFORE">
        select Last_insert_id()
      </selectKey>
      insert into Author
        (id, username, password, email,bio, favourite_section)
      values
        (#{id}, #{username}, #{password}, #{email}, #{bio}, #{favouriteSection,jdbcType=VARCHAR})
    </insert>
    
##   安装

    如果使用 Maven 来构建项目，则需将下面的 dependency 代码置于 pom.xml 文件中：

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>x.x.x</version>
    </dependency>
## 从 XML 中构建 SqlSessionFactory   

    String resource = "org/mybatis/example/mybatis-config.xml";
    InputStream inputStream = Resources.getResourceAsStream(resource);
    sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    一样，只不过，现在的Java版本支持了Reader 方式得到
    Reader reader = Resources.getResourceAsReader("mybatis.xml");
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
# configuration XML: 包含获取数据库连接实例的数据源（DataSource）和决定事务范围和控制方式的事务管理器（TransactionManager）
# SQLSession     
     //从当前线程中获取SqlSession对象
     一般从SQLSessionFactory，不过可能考虑线程的知识等
     SqlSession session = sqlSessionFactory.openSession();
     session.selectOne，等底层的数据函数 操作delete insert update 查找所有selectList 单一selectOne 
      进一步改进，创建mapper类
      诚然这种方式能够正常工作，并且对于使用旧版本 MyBatis 的用户来说也比较熟悉，不过现在有了一种更直白的方式。使用对于给定语句能够合理描述参数和返回值的接口（比如说BlogMapper.class），你现在不但可以执行更清晰和类型安全的代码，而且还不用担心易错的字符串字面值以及强制类型转换。

      例如：

      SqlSession session = sqlSessionFactory.openSession();
      try {
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = mapper.selectBlog(101);
      } finally {
        session.close();
      }
      而mapper类只要在xml中创建即可
    <mapper namespace="org.mybatis.example.BlogMapper">
      <select id="selectBlog" resultType="Blog">
        select * from Blog where id = #{id}
      </select>
    </mapper>
      进一步使用注解方式创建mapper类的mysql
        package org.mybatis.example;
    public interface BlogMapper {
      @Select("SELECT * FROM blog WHERE id = #{id}")
      Blog selectBlog(int id);
    }


## 其中对sqlSession从当前线程中获取整理分离在Util公共包的类之中

