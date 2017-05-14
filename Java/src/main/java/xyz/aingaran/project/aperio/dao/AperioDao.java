package xyz.aingaran.project.aperio.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;

import xyz.aingaran.project.aperio.dao.impl.AperioDaoImpl;

/**
 * @author Aingaran Elango
 * @category DAO Interface
 * This is an interface for AperioDao
 * @see AperioDaoImpl
 */
public interface AperioDao {
	
	public SqlSessionFactory getSqlSessionFactory();
	public boolean insert(String queryId, List<?> domainList);

}
