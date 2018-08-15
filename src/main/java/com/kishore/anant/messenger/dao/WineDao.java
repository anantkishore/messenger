/**
 * 
 */
package com.kishore.anant.messenger.dao;

import java.util.List;

import com.kishore.anant.messenger.entity.Wine;
import com.kishore.anant.messenger.exception.DaoException;

/**
 * @author i351596
 *
 */
public interface WineDao {

	public Wine save(Wine wine) throws DaoException;

	public void delete(Wine wine) throws DaoException;

	Wine get(String id) throws DaoException;

	List<Wine> fetchAll() throws DaoException;

	Wine update(String id, Wine wine) throws DaoException;

	public List<Wine> fetchAll(int offset, int pageSize) throws DaoException;

	public Wine deleteWine(String id) throws DaoException;

}
