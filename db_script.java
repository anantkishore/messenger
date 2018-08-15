/**
 * 
 */
package com.kishore.anant.MongoDB;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.opencsv.CSVReader;

/**
 * @author i351596
 *
 */
public class CreateRowWithDump {
	
	private static final String ID = "ID";
	private static final String COUNTRY = "country";
	private static final String DESCRIPTION = "description";
	private static final String DESIGNATION = "designation";
	private static final String POINTS = "points";
	private static final String PRICE = "price";
	private static final String PROVINCE = "province";
	private static final String REGION_1 = "region_1";
	private static final String REGION_2 = "region_2";
	private static final String VARIETY = "variety";
	private static final String WINERY = "winery";

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		FileReader reader = new FileReader(new File("winemag-data_first150k3ed116a.csv"));
		CSVReader csvReader = new CSVReader(reader);
		
		MongoClient mongoClient = new MongoClient();
		MongoDatabase database = mongoClient.getDatabase("messenger");
		MongoCollection<Document> collection = database.getCollection("wine_connoisseur");

		Document document = null;
		String[] line = csvReader.readNext();

		while ((line = csvReader.readNext()) != null && line.length > 9)
		{

			HashMap<String, Object> map = new HashMap<String, Object>();
			
			map.put(ID, line[0]);
			map.put(COUNTRY, line[1]);
			map.put(DESCRIPTION, line[2]);
			map.put(DESIGNATION, line[3]);
			map.put(POINTS, line[4]);
			map.put(PRICE, line[5]);
			map.put(PROVINCE, line[6]);
			map.put(REGION_1, line[7]);
			map.put(REGION_2, (line[8]));
			map.put(VARIETY, line[9]);
			map.put(WINERY, line[10]);
			
			document = new Document(map);
			collection.insertOne(document);

		}

		reader.close();
		csvReader.close();
		mongoClient.close();

	}

}
