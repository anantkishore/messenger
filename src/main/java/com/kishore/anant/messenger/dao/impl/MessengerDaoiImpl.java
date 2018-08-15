/**
 * 
 */
package com.kishore.anant.messenger.dao.impl;

import org.bson.Document;

import com.kishore.anant.messenger.dao.MessengerDao;
import com.kishore.anant.messenger.entity.Message;
import com.kishore.anant.messenger.exception.DaoException;
import com.kishore.anant.messenger.utility.ProcessEntityToDoc;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * @author i351596
 *
 */
public class MessengerDaoiImpl implements MessengerDao {

	private static volatile MessengerDaoiImpl messengerDaoImpl;

	private static MongoDatabase database;

	private static MongoCollection<Document> collection;

	/**
	 * 
	 */
	private MessengerDaoiImpl() {

	}

	public static MessengerDaoiImpl getMessengerDaoiImpl() {
		if (messengerDaoImpl == null) {
			synchronized (MessengerDaoiImpl.class) {
				if (messengerDaoImpl == null) {
					return new MessengerDaoiImpl();
				}
			}
		}
		return messengerDaoImpl;
	}

	static {
		@SuppressWarnings("resource")
		MongoClient mongoClient = new MongoClient();
		database = mongoClient.getDatabase("schlumberger1");
	}

	static {
		collection = database.getCollection("wine_connoisseur");
	}

	private static MongoCollection<Document> getCollection(String collectionName) {
		return MessengerDaoiImpl.database.getCollection(collectionName);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kishore.anant.messenger.dao.MessengerDao#save(java.lang.Object)
	 */
	@Override
	public void save(Object o, String collectionName) throws DaoException {

		if (o instanceof Message) {
			Message msg = (Message) o;
			Document doc = ProcessEntityToDoc.getDocument(msg);
			MessengerDaoiImpl.getCollection(collectionName).insertOne(doc);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kishore.anant.messenger.dao.MessengerDao#update(java.lang.Object)
	 */
	@Override
	public void update(Object o) throws DaoException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kishore.anant.messenger.dao.MessengerDao#delete(java.lang.Object)
	 */
	@Override
	public void delete(Object o) throws DaoException {

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.kishore.anant.messenger.dao.MessengerDao#get(java.lang.Object)
	 */
	@Override
	public void get(Object o) throws DaoException {

	}

	@Override
	public void save(Object o) throws DaoException {
		

	}

}
