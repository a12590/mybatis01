package cn.itcast.javaee.mybatis.app10;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.session.SqlSession;
import cn.itcast.javaee.mybatis.util.MybatisUtil;

/**
 * 持久层 
 * @author AdminTC
 */
public class StudentDao {
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
	 * 无条件分页
	 * @param start 表示在mysql中从第几条记录的索引号开始显示，索引从0开始
	 * @param size 表示在mysql中最多显示几条记录
	 */
	public List<Student> findAllWithFy(int start,int size) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("pstart",start);
			map.put("psize",size);
			return sqlSession.selectList(Student.class.getName()+".findAllWithFy",map);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	/**
	 * 有条件分页
	 */
	public List<Student> findAllByNameWithFy(String name,int start,int size) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			Map<String,Object> map = new LinkedHashMap<String, Object>();
			map.put("pname","%"+name+"%");
			map.put("pstart",start);
			map.put("psize",size);			
			return sqlSession.selectList(Student.class.getName()+".findAllByNameWithFy",map);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		StudentDao dao = new StudentDao();
		
		//for(int i=1;i<=10;i++){
		//	dao.add(new Student(i,"哈哈",7000D));
		//}
		
		System.out.println("--------------------第一页");
		List<Student> studentList1 = dao.findAllByNameWithFy("哈",0,3);
		for(Student s : studentList1){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		System.out.println("--------------------第二页");
		List<Student> studentList2 = dao.findAllByNameWithFy("哈",3,3);
		for(Student s : studentList2){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		System.out.println("--------------------第三页");
		List<Student> studentList3 = dao.findAllByNameWithFy("哈",6,3);
		for(Student s : studentList3){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
		
	}
}










