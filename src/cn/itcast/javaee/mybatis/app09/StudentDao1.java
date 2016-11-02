package cn.itcast.javaee.mybatis.app09;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * 持久层 
 * @author AdminTC
 */
public class StudentDao1 {
	/**
	 * 增加学生
	 */
	public void add(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert(Student.class.getName()+".add",student);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * 根据ID查询学生 
	 */
	public Student findById(int id) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			Student student = sqlSession.selectOne(Student.class.getName()+".findById",id);
			sqlSession.commit();
			return student;
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * 查询所有学生 
	 */
	public List<Student> findAll() throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			return sqlSession.selectList(Student.class.getName()+".findAll");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * 更新学生 
	 */
	public void update(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.update(Student.class.getName()+".update",student);
			sqlSession.commit();
		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * 删除学生 
	 */
	public void delete(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.delete(Student.class.getName()+".delete",student);
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
		StudentDao1 dao = new StudentDao1();
		//dao.add(new Student(1,"哈哈",7000D));
		//dao.add(new Student(2,"呵呵",8000D));
		//dao.add(new Student(3,"班长",9000D));
		//dao.add(new Student(4,"键状高",10000D));
		//Student student = dao.findById(4);
		//List<Student> studentList = dao.findAll();
		//for(Student student : studentList){
		//	System.out.print(student.getId()+":"+student.getName()+":"+student.getSal());
		//	System.out.println();
		//}
		//Student student = dao.findById(3);
		//student.setName("靓班长");
		//dao.update(student);
		
		Student student = dao.findById(3);
		System.out.print(student.getId()+":"+student.getName()+":"+student.getSal());
		
		//dao.delete(student);
	}
}










