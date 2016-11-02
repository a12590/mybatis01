package cn.itcast.javaee.mybatis.app14;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * 持久层 
 * @author AdminTC
 */
public class StudentDao {
	/**
	 * 插入学生
	 */
	public void dynaInsert(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("studentNamespace.dynaInsert",student);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		StudentDao dao = new StudentDao();
		//dao.dynaInsert(new Student(1,"哈哈",7000D));//insert into 表名(*,*,*) values(?,?,?)
		//dao.dynaInsert(new Student(2,"哈哈",null));//insert into 表名(*,*) values(?,?)
		//dao.dynaInsert(new Student(3,null,7000D));//insert into 表名(*,*) values(?,?)
		dao.dynaInsert(new Student(4,null,null));//insert into 表名(*) values(?)
	}
}










