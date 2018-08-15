/**
 * 
 */
package com.kishore.anant.messenger.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.kishore.anant.messenger.dao.WineDao;
import com.kishore.anant.messenger.entity.Wine;
import com.kishore.anant.messenger.exception.DaoException;
import com.kishore.anant.messenger.utility.ProcessEntityToDoc;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.UpdateResult;

/**
 * @author i351596
 *
 */
public class WineDaoImpl implements WineDao {

	private static volatile WineDaoImpl wineDaoImpl;

	private static MongoDatabase database;

	private static MongoCollection<Document> collection;

	public static WineDaoImpl getWineDaoImpl() {
		if (wineDaoImpl == null) {
			synchronized (WineDaoImpl.class) {
				if (wineDaoImpl == null) {
					return new WineDaoImpl();
				}
			}
		}
		return wineDaoImpl;
	}

	static {
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient();
		database = mongoClient.getDatabase("messenger");
	}

	static {
		collection = database.getCollection("wine_connoisseur");
	}

	/**
	 * 
	 */
	public WineDaoImpl() {

	}

	@Override
	public Wine save(Wine wine) throws DaoException {

		Document doc = ProcessEntityToDoc.getDocument(wine);
		WineDaoImpl.collection.insertOne(doc);
		return wine;

	}

	@Override
	public Wine update(String id, Wine wine) throws DaoException {

		//BasicDBObject query = new BasicDBObject("_id", new ObjectId(id));

		//BasicDBObject basicDBObject = new BasicDBObject(ProcessEntityToDoc.getObjectMap(wine));

		Bson bsonFilter = Filters.eq("ID", id);
		
		UpdateResult result = WineDaoImpl.collection.updateOne(bsonFilter, new BasicDBObject().append("$set", ProcessEntityToDoc.getUpdateDocument(wine)));
		
		//WineDaoImpl.collection.updateOne(document, basicDBObject);
		return wine;

	}

	@Override
	public void delete(Wine wine) throws DaoException {

	}

	@Override
	public Wine get(String id) throws DaoException {

		Wine wine = null;

		Bson bsonFilter = Filters.eq("ID", id);
		FindIterable<Document> iterable = WineDaoImpl.collection.find(bsonFilter);

		MongoCursor<Document> cursor = iterable.iterator();

		while (cursor.hasNext()) {
			Document document = cursor.next();
			wine = ProcessEntityToDoc.getWine(document);
		}

		return wine;
	}

	@Override
	public List<Wine> fetchAll() throws DaoException {

		FindIterable<Document> iterable = WineDaoImpl.collection.find();
		List<Wine> wines = new ArrayList<>();

		iterable.limit(1000);
		MongoCursor<Document> cursor = iterable.iterator();

		while (cursor.hasNext()) {
			Document document = cursor.next();
			wines.add(ProcessEntityToDoc.getWine(document));
		}

		return wines;
	}

	@Override
	public List<Wine> fetchAll(int offset, int pageSize) throws DaoException {

		FindIterable<Document> iterable = WineDaoImpl.collection.find().skip(offset).limit(pageSize);
		List<Wine> wines = new ArrayList<>();

		//iterable.limit(1000);
		MongoCursor<Document> cursor = iterable.iterator();

		while (cursor.hasNext()) {
			Document document = cursor.next();
			wines.add(ProcessEntityToDoc.getWine(document));
		}

		return wines;
	}

	@Override
	public Wine deleteWine(String id) throws DaoException {
		
		Bson bsonFilter = Filters.eq("ID", id);
		WineDaoImpl.collection.deleteOne(bsonFilter);
		return null;
	}

}
