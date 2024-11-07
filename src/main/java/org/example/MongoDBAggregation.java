package org.example;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Arrays;

public class MongoDBAggregation {

    public static void main(String[] args) {
        String uri = "mongodb://localhost:27017"; // Connection URI

        try (MongoClient mongoClient = MongoClients.create(uri)) {
            MongoDatabase database = mongoClient.getDatabase("testdb"); // Database name
            MongoCollection<Document> collection = database.getCollection("people"); // Collection name

            // Create aggregation pipeline
            // Match people older than 25
            Document matchStage = new Document("$match", new Document("age", new Document("$gt", 25)));

            // Sort people by name in ascending order
            Document sortStage = new Document("$sort", new Document("name", 1));

            // Execute aggregation pipeline
            AggregateIterable<Document> result = collection.aggregate(Arrays.asList(matchStage, sortStage));

            // Print the results
            for (Document doc : result) {
                System.out.println(doc.toJson());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
