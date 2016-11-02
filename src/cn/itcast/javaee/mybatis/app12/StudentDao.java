package cn.itcast.javaee.mybatis.app12;

import java.util.HashMap;
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
	 * 有条件更新学生
	 */
	public void dynaUpdate(Integer id,String name,Double sal) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
				
			Map<String,Object> map = new HashMap<String, Object>();
			map.put("pid",id);
			map.put("pname",name);
			map.put("psal",sal);
			sqlSession.update("studentNamespace.dynaUpdate",map);
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
		//关注SQL的变化
		//dao.dynaUpdate(1,null,9000D);//update students set sal=? where id=?
		//dao.dynaUpdate(1,"笨笨",null);//update students set name=? where id=?
		dao.dynaUpdate(1,"笨笨",10000D);//update students set name=? and sal=? where id=?
	}
}










