/**
 * 
 */
package com.kishore.anant.messenger.service;

import java.util.List;

import javax.inject.Inject;

import com.kishore.anant.messenger.entity.Comment;
import com.kishore.anant.messenger.entity.Wine;
import com.kishore.anant.messenger.exception.DaoException;

/**
 * @author i351596
 *
 */
public class CommentService {
	
	@Inject
	private WineService wineService = new WineService();
	
	/**
	 * 
	 */
	public CommentService() {
	}
	
	public Wine createComment(String wineId, Comment comment) throws DaoException
	{
		Wine wine = wineService.fetchWine(wineId);
		if(wine != null)
		{
			List<Comment> comments = wine.getComments();
			comments.add(comment);
			return wineService.updateWine(wineId, wine);
		}
		return null;
	}

	public Comment getComment(String wineId, String commentId) throws DaoException 
	{
		Wine wine = wineService.fetchWine(wineId);
		if(wine != null)
		{
			List<Comment> comments = wine.getComments();
			for(Comment comment : comments)
			{
				if(comment.getId().equalsIgnoreCase(commentId))
					return comment;
			}
		}
		return null;
	}

	public List<Comment> getAllComments(String wineId) throws DaoException 
	{
		Wine wine = wineService.fetchWine(wineId);
		if(wine != null)
		{
			return wine.getComments();
		}
		return null;
	}
	

}
