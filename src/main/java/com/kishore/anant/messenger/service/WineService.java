/**
 * 
 */
package com.kishore.anant.messenger.service;

import java.util.List;

import com.kishore.anant.messenger.dao.WineDao;
import com.kishore.anant.messenger.dao.impl.WineDaoImpl;
import com.kishore.anant.messenger.entity.Wine;
import com.kishore.anant.messenger.exception.DaoException;

/**
 * @author i351596
 *
 */
public class WineService {
	
	private WineDao wineDao = new WineDaoImpl();

	/**
	 * 
	 */
	public WineService() {
		
	}
	
	public List<Wine> fetchAllWine(int offset, int pageSize) throws DaoException
	{
		return wineDao.fetchAll(offset, pageSize);
	}
	
	public Wine fetchWine(String id) throws DaoException
	{
		return wineDao.get(id);
	}

	public Wine createWine(Wine wine) throws DaoException 
	{
		return wineDao.save(wine);
	}

	public Wine updateWine(String id, Wine wine) throws DaoException 
	{
		return wineDao.update(id, wine);
	}

	public List<Wine> fetchAllWine() throws DaoException {
		return wineDao.fetchAll();
	}

	public Wine deleteWine(String id) throws DaoException {
		return wineDao.deleteWine(id);
	}

}
