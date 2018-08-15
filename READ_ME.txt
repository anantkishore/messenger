

############################ Messenger App #############################
########################################################################
Step 1. Create Rows in Mongo DB database from excel file
	a.) Execute db_scripts.java file as individual java program, add dependency for mongo db driver and update resource excel file location
	b.) Verify the details in Mongo DB shell using these commands  show db, use messenger, db.collection(), db.getCollection("wine_connoisseur").findOne()

Step 2: Run the actual web service on tomcat server and hit urls for CRUD operations - http://localhost:8081/messenger/webapi/wines/16


