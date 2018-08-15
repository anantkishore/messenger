/**
 * 
 */
package com.kishore.anant.messenger.utility;

import java.util.HashMap;
import java.util.Map;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.kishore.anant.messenger.entity.Message;
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

	public static Document getDocument(Message msg) {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put(Message.MESSAGE_ID, msg.getId());
		map.put(Message.MESSAGE_TEXT, msg.getText());
		map.put(Message.MESSAGE_CREATED_DATE, msg.getCreatedDate());
		map.put(Message.MESSAGE_AUTHOR, msg.getAuthor());

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

			return new Document(map);
		}
		return null;
	}
	
	/*public static HashMap<String, Object> getObjectMap(Wine wine) {

		if (wine != null) {
			HashMap<String, Object> map = new HashMap<String, Object>();

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

			return map;
		}
		return null;
	}*/

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
		}
		return wine;
	}

}