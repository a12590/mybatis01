package cn.itcast.javaee.mybatis.app13;

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
	 * 根据ID批量删除学生(数组版本)
	 */
	public void dynaDeleteArray(int... ids) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.delete("studentNamespace.dynaDeleteArray",ids);
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
	 * 根据ID批量删除学生(集合版本)
	 */
	public void dynaDeleteList(List<Integer> ids) throws Exception{
		SqlSession sqlSession = null;
		try{
			sqlSession = MybatisUtil.getSqlSession();
			sqlSession.delete("studentNamespace.dynaDeleteList",ids);
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
		//dao.dynaDeleteArray(new int[]{1,3,5,7,77});
		//dao.dynaDeleteArray(1,3,5,7,77);
		//dao.dynaDeleteArray(2,4,444);
		
		List<Integer> ids = new ArrayList<Integer>();
		ids.add(6);
		ids.add(8);
		ids.add(9);
		dao.dynaDeleteList(ids);
	}
}










