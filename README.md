To use MongoDB with Java and Maven, here's a full guide that explains how to set up Maven, add the MongoDB driver, and run Java code to connect to MongoDB, insert data, and execute aggregation pipelines.

### Step 1: Set Up Maven Project

1. **Create a Maven project** if you haven’t already. You can do this through your IDE (like IntelliJ IDEA or Eclipse) or manually by creating the project structure.

### Step 2: Add Dependencies to `pom.xml`

To work with MongoDB in Java, you need the MongoDB Java driver. Add the dependency to the `pom.xml` of your Maven project:

You can check for the latest version of the MongoDB Java driver on Maven Central: [MongoDB Java Driver](https://mvnrepository.com/artifact/org.mongodb/mongodb-driver-sync).

### Step 3: Java Code to Connect to MongoDB and Perform Operations

#### Example 1: **Ingest Data into MongoDB**

This Java code demonstrates how to connect to MongoDB and insert documents into a collection.

#### Example 2: **MongoDB Aggregation Pipeline**

This Java code demonstrates how to use an aggregation pipeline to filter and sort documents in MongoDB.

### Step 4: Build and Run the Project

1. **Build the Project** using Maven:
   Open the terminal in your project’s root directory and run:
   ```bash
   mvn clean install
   ```

2. **Run the Java Application**:
   You can run the Java application from your IDE (e.g., IntelliJ IDEA) or from the terminal using the following command:
   ```bash
   mvn exec:java -Dexec.mainClass="MongoDBIngestData"  # For data ingestion
   mvn exec:java -Dexec.mainClass="MongoDBAggregation"  # For aggregation
   ```

### Step 5: Verify Data in MongoDB

1. **Launch MongoDB Shell**:
   Open a terminal and run the following command to enter the MongoDB shell:
   ```bash
   mongo
   ```

2. **Verify Data**:
   In the MongoDB shell, switch to the `testdb` database and view the `people` collection:
   ```bash
   use testdb
   db.people.find().pretty()
   ```

   You should see the documents you inserted earlier.

### Conclusion

By following these steps, you've created a Maven project, added MongoDB dependencies, written Java code to ingest data, and performed an aggregation operation. This is a foundational setup for working with MongoDB in Java using Maven.

Let me know if you need further assistance!
