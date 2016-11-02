package cn.itcast.javaee.mybatis.app11;

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
	 * 有条件的查询所有学生
	 */
	public List<Student> findAll(Integer id,String name,Double sal) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
				
			Map<String,Object> map = new LinkedHashMap<String,Object>();
			map.put("pid",id);
			map.put("pname",name);
			map.put("psal",sal);
			
			return sqlSession.selectList("studentNamespace.findAll",map);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			MybatisUtil.closeSqlSession();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) throws Exception{
		StudentDao dao = new StudentDao();
		List<Student> studentList = dao.findAll(5,"哈哈",7000D);
		for(Student s : studentList){
			System.out.println(s.getId()+":"+s.getName()+":"+s.getSal());
		}
	}
}










