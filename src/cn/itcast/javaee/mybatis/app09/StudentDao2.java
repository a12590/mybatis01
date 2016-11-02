package cn.itcast.javaee.mybatis.app09;

import org.apache.ibatis.session.SqlSession;
import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * 持久层 
 * @author AdminTC
 */
public class StudentDao2 {
	/**
	 * 增加学生
	 */
	public void add(Student student) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.insert("studentNamespace.add",student);
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
			Student student = sqlSession.selectOne("studentNamespace.findById",id);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		StudentDao2 dao = new StudentDao2();
		//dao.add(new Student(1,"班长",7000D));
		Student student = dao.findById(1);
		if(student == null){
			System.out.println("YES");
		}
		System.out.println(student.getId()+":"+student.getName()+":"+student.getSal());
	}
}










