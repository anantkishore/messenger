/**
 * 
 */
package com.kishore.anant.messenger.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.kishore.anant.messenger.entity.Comment;
import com.kishore.anant.messenger.entity.Wine;

/**
 * @author i351596
 *
 */
public class ProcessEntityToDoc {

	/**
	 * 
	 */
	public ProcessEntityToDoc() {

	}

	public static Document getDocument(Comment msg) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put(Comment.COMMENT_ID, msg.getId());
		map.put(Comment.COMMENT_TEXT, msg.getText());
		map.put(Comment.COMMENT_CREATED_DATE, msg.getCreatedDate());
		map.put(Comment.COMMENT_OWNER, msg.getAuthor());

		return new Document(map);

	}

	public static Document getDocument(Wine wine) {

		if (wine != null) {
			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put(Wine.ID, wine.getId());
			map.put(Wine.COUNTRY, wine.getCountry());
			map.put(Wine.DESCRIPTION, wine.getDescription());
			map.put(Wine.DESIGNATION, wine.getDesignation());
			map.put(Wine.POINTS, wine.getPoints());
			map.put(Wine.PRICE, wine.getPrice());
			map.put(Wine.PROVINCE, wine.getProvince());
			map.put(Wine.REGION_1, wine.getRegion_1());
			map.put(Wine.REGION_2, wine.getRegion_2());
			map.put(Wine.VARIETY, wine.getVariety());
			map.put(Wine.WINERY, wine.getWinery());
			
			List<Comment> comments = wine.getComments();
			List<Document> commentDocs = new ArrayList<>();
			if(comments != null)
			{
				for(Comment comment : comments)
				{
					HashMap<String, Object> commentMap = new HashMap<String, Object>();
					commentMap.put(Comment.COMMENT_ID, comment.getId());
					commentMap.put(Comment.COMMENT_TEXT, comment.getText());
					commentMap.put(Comment.COMMENT_CREATED_DATE, comment.getCreatedDate());
					commentMap.put(Comment.COMMENT_OWNER, comment.getAuthor());
					commentDocs.add(new Document(commentMap));
				}
			}
			map.put(Wine.COMMENTS, commentDocs);

			return new Document(map);
		}

		return null;
	}
	
	public static Document getUpdateDocument(Wine wine) {

		if (wine != null) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			
			if(wine.getCountry() != null)
				map.put(Wine.COUNTRY, wine.getCountry());
			if(wine.getDescription() != null)
				map.put(Wine.DESCRIPTION, wine.getDescription());
			if(wine.getDesignation() != null)
				map.put(Wine.DESIGNATION, wine.getDesignation());
			if(wine.getPoints() != null)
				map.put(Wine.POINTS, wine.getPoints());
			if(wine.getPrice() != null)
				map.put(Wine.PRICE, wine.getPrice());
			if(wine.getProvince() != null)
				map.put(Wine.PROVINCE, wine.getProvince());
			if(wine.getRegion_1() != null)
				map.put(Wine.REGION_1, wine.getRegion_1());
			if(wine.getRegion_2() != null)
				map.put(Wine.REGION_2, wine.getRegion_2());
			if(wine.getVariety() != null)
				map.put(Wine.VARIETY, wine.getVariety());
			if(wine.getWinery() != null)
				map.put(Wine.WINERY, wine.getWinery());
			if(wine.getComments() != null)
			{
				List<Document> commentDocs = new ArrayList<>();
				for(Comment comment : wine.getComments())
				{
					HashMap<String, Object> commentMap = new HashMap<String, Object>();
					commentMap.put(Comment.COMMENT_ID, comment.getId());
					commentMap.put(Comment.COMMENT_TEXT, comment.getText());
					commentMap.put(Comment.COMMENT_CREATED_DATE, comment.getCreatedDate());
					commentMap.put(Comment.COMMENT_OWNER, comment.getAuthor());
					commentDocs.add(new Document(commentMap));
				}
				map.put(Wine.COMMENTS, commentDocs);
				
			}

			return new Document(map);
		}
		return null;
	}
	
	public static Wine getWine(Document doc) {

		Wine wine = null;
		if (doc != null) {
			wine = new Wine();
			ObjectId oId = doc.getObjectId(Wine.OBJECT_ID);
			wine.setoID(oId.toString());
			wine.setId(doc.getString(Wine.ID));
			wine.setCountry(doc.getString(Wine.COUNTRY));
			wine.setDescription(doc.getString(Wine.DESCRIPTION));
			wine.setDesignation(doc.getString(Wine.DESIGNATION));
			wine.setPoints(doc.getString(Wine.POINTS));
			wine.setPrice(doc.getString(Wine.PRICE));
			wine.setProvince(doc.getString(Wine.PROVINCE));
			wine.setRegion_1(doc.getString(Wine.REGION_1));
			wine.setRegion_2(doc.getString(Wine.REGION_2));
			wine.setVariety(doc.getString(Wine.VARIETY));
			wine.setWinery(doc.getString(Wine.WINERY));
			setComments(wine, doc);
		}
		return wine;
	}

	private static void setComments(Wine wine, Document doc) {
		
		List<Comment> comments = new ArrayList<Comment>();
		@SuppressWarnings("unchecked")
		List<Document> commentDocs =  (List<Document>) doc.get(Wine.COMMENTS);
		if(commentDocs != null)
		{
			for(Document commentDoc : commentDocs)
			{
				if(commentDoc != null)
				{
					Comment comment = new Comment();
					comment.setId(Long.toString(commentDoc.getLong(Comment.COMMENT_ID)));
					comment.setText(commentDoc.getString(Comment.COMMENT_TEXT));
					comment.setCreatedDate(commentDoc.getDate(Comment.COMMENT_CREATED_DATE));
					comment.setAuthor(commentDoc.getString(Comment.COMMENT_OWNER));
					comments.add(comment);
				}
			}
		}
		wine.setComments(comments);
	}

}