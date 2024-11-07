package org.example;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import java.util.Arrays;

public class MongoDBIngestData {

    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017"; // Connection URI

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("testdb"); // Database name
            MongoCollection<Document> collection = database.getCollection("people"); // Collection name

            // Ingest a single document
            Document person = new Document("name", "John Doe")
                    .append("age", 29)
                    .append("city", "New York");
            collection.insertOne(person);

            // Ingest multiple documents
            Document person1 = new Document("name", "Jane Doe")
                    .append("age", 25)
                    .append("city", "Los Angeles");
            Document person2 = new Document("name", "Alice Smith")
                    .append("age", 30)
                    .append("city", "San Francisco");

            collection.insertMany(Arrays.asList(person1, person2));

            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
