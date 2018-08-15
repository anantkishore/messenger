/**
 * 
 */
package com.kishore.anant.messenger.dao;

import com.kishore.anant.messenger.exception.DaoException;

/**
 * @author i351596
 *
 */
public interface MessengerDao {

	public void save(Object o) throws DaoException;
	public void update(Object o) throws DaoException;
	public void delete(Object o) throws DaoException;
	public void get(Object o) throws DaoException;
	void save(Object o, String collectionName) throws DaoException;
	
}
