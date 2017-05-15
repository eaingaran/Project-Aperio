package xyz.aingaran.project.aperio.dao.impl;

import java.util.List;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import xyz.aingaran.project.aperio.dao.AperioDao;

/**
 * @author Aingaran Elango
 * @category DAO
 * This is a Database Access Layer Class
 * implemented from {@link AperioDao}
 */
public class AperioDaoImpl implements AperioDao {

	//injected
	private SqlSessionFactory sqlSessionFactory;
	
	//not injected
	private SqlSession session;
	/**
	 * @return the sqlSessionFactory
	 */
	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	/**
	 * @param sqlSessionFactory the sqlSessionFactory to set
	 */
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}

	/**
	 * This method inserts any list of objects provided the queryId supplied is valid.
	 */
	public boolean insert(String queryId, List<?> domainList) {
		boolean isSuccess = false;
		try {
			session = sqlSessionFactory.openSession(ExecutorType.BATCH,false);
			for(Object domain : domainList) {
				session.insert(queryId,domain);
			}
			session.flushStatements();
			session.commit();
			isSuccess = true;
		} catch (Exception e) {
			isSuccess = false;
			session.rollback();
			e.printStackTrace();
		} finally {
			session.clearCache();
			session.close();
		}
		return isSuccess;
	}
}
