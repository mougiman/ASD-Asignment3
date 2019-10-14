/*
 * Author: Georges Bou Ghantous
 *
 * This class provides the methods to establish connection between ASD-Demo-app
 * and MongoDBLab cloud Database. The data is saved dynamically on mLab cloud database as
 * as JSON format.
 */
package asd.demo.model.dao;

import asd.demo.model.Item;
import java.net.UnknownHostException;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import java.util.*;
import asd.demo.model.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import org.bson.conversions.Bson;

public class MongoDBConnector {

    //Create Connection to Collections in DB
    MongoDatabase shopDB = getMongoDB();
    MongoCollection<Document> dbItems = shopDB.getCollection("Item");
    MongoCollection<Document> users = shopDB.getCollection("Users");
    MongoCollection<Document> reviews = shopDB.getCollection("Review");
    MongoCollection<Document> ratings = shopDB.getCollection("Rating");
    MongoCollection<Document> WL = shopDB.getCollection("WatchList");
    MongoCollection<Document> orders = shopDB.getCollection("Order");
    MongoCollection<Document> buyLogs = shopDB.getCollection("Order");

    public MongoDatabase getMongoDB() {
        if (shopDB == null) {
            //MongoClientURI uri = new MongoClientURI("mongodb://mougiosalex%40gmail.com:Mougios_13@ds115411.mlab.com:15411/heroku_dmxfzlt3");
            //MongoClientURI uri = new MongoClientURI("mongodb://alex:password1@ds115411.mlab.com:15411/heroku_dmxfzlt3");
            //MongoClientURI uri = new MongoClientURI("mongodb://user:asdpassword1@cluster0-shard-00-00-gmu5w.gcp.mongodb.net:27017,cluster0-shard-00-01-gmu5w.gcp.mongodb.net:27017,cluster0-shard-00-02-gmu5w.gcp.mongodb.net:27017/test?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin&retryWrites=true&w=majority");
            MongoClientURI uri = new MongoClientURI("mongodb://weize:Holyshit1.@asd-assignment-shard-00-00-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-01-5im26.gcp.mongodb.net:27017,asd-assignment-shard-00-02-5im26.gcp.mongodb.net:27017/test?ssl=true&replicaSet=ASD-Assignment-shard-0&authSource=admin&retryWrites=true&w=majority");
            MongoClient client = new MongoClient(uri);
            MongoDatabase db = client.getDatabase("ASD");
            return db;
        }
        return shopDB;
    }

    //Add Auction item to Item Collection
    public void addAucItem(String id, String name, String datelisted, int quantity, Double price, String desc, String category, String sellerId, String expdate, String img, boolean ifAuc) {
        Document document = new Document("id", id).
                append("name", name).
                append("dateListed", datelisted).
                append("stock", quantity).
                append("price", price).
                append("desc", desc).
                append("category", category).
                append("sellerId", sellerId).
                append("expdate", expdate).
                append("ifAuc", true).
                append("image", img);
        dbItems.insertOne(document);
    }

    //Add item to Item Collection
    public void addItem(String id, String name, String datelisted, int quantity, Double price, String desc, String category, String sellerId, String expdate, Boolean ifAuc, String img) {
        Document document = new Document("id", id).
                append("name", name).
                append("dateListed", datelisted).
                append("stock", quantity).
                append("price", price).
                append("desc", desc).
                append("category", category).
                append("expdate", expdate).
                append("sellerId", sellerId).
                append("image", img).
                append("ifAuc", ifAuc);
        dbItems.insertOne(document);
    }

    //Add Review item to Review Collection
    public void addReview(String id, String ItemID, String UserID, String Desc, String Title, String DateListed) {
        Document document = new Document("id", id).
                append("UserID", UserID).
                append("Desc", Desc).
                append("Title", Title).
                append("DateListed", DateListed).
                append("ItemID", ItemID);
        reviews.insertOne(document);
    }

    public void addRating(Rating rated) {
        Document document = new Document("id", rated.getID()).
                append("rated", rated.getSellerID()).
                append("rater", rated.getUserID()).
                append("score", rated.getScore()).
                append("Desc", rated.getDesc()).
                append("Title", rated.getTitle()).
                append("DateListed", rated.getDateListed());
        ratings.insertOne(document);
    }

    //Get all items from Item Collection
    public ItemList getItemList() {
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        ItemList items = new ItemList();
        Item item = new Item();
        for (Document document : documents) {
            item = new Item("" + document.get("id"), "" + document.get("name"), "" + document.get("dateListed"), Integer.parseInt("" + document.get("stock")),/* Integer.parseInt("" + document.get("soldQuantity")),*/ Double.parseDouble("" + document.get("price")), "" + document.get("desc"), "" + document.get("category"), "" + document.get("sellerId"), "" + document.get("expdate"), Boolean.parseBoolean("" + document.get("ifAuc")), "" + document.get("image"));
            items.addItem(item);
        }
        return items;
    }

    //Get Item with matching id submitted
    public Item getitem(String id) {
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        Item item = new Item();
        for (Document document : documents) {
            String itemId = "" + document.get("id");
            if (itemId.equals(id)) {
                item = new Item("" + document.get("id"), "" + document.get("name"), "" + document.get("dateListed"), Integer.parseInt("" + document.get("stock")),/* Integer.parseInt("" + document.get("soldQuantity")),*/ Double.parseDouble("" + document.get("price")), "" + document.get("desc"), "" + document.get("category"), "" + document.get("sellerId"), "" + document.get("expdate"), Boolean.parseBoolean("" + document.get("ifAuc")), "" + document.get("image"));
            }
        }
        return item;
    }

    //Get Item Reviews that match the Item id given
    public ArrayList<Review> getItemReviews(String id) {
        List<Document> documents = (List<Document>) reviews.find().into(new ArrayList<Document>());
        ArrayList<Review> reviews = new ArrayList<Review>();
        for (Document document : documents) {
            String itemId = "" + document.get("ItemID");
            if (itemId.equals(id)) {
                Review review = new Review();
                review = new Review("" + document.get("id"), "" + document.get("ItemID"), "" + document.get("UserID"), "" + document.get("Desc"), "" + document.get("Title"), "" + document.get("DateListed"));
                reviews.add(review);
            }
        }
        return reviews;
    }

    //Not implemented yet, gets ratings with ids matching the user id given
    public ArrayList<Rating> getUserRatings(String id) {
        List<Document> documents = (List<Document>) ratings.find().into(new ArrayList<Document>());
        ArrayList<Rating> ratings = new ArrayList<Rating>();
        for (Document document : documents) {
            String sellerId = "" + document.get("rated");
            if (sellerId.equals(id)) {
                Rating rating = new Rating();
                rating = new Rating("" + document.get("id"), "" + document.get("rated"), "" + document.get("rater"), "" + document.get("Desc"), "" + document.get("Title"), "" + document.get("DateListed"), "" + document.get("score"));
                ratings.add(rating);
            }
        }
        return ratings;
    }

    //Gets the name of the user, whose id is given
    public String getusername(String id) {
        List<Document> documents = (List<Document>) users.find().into(new ArrayList<Document>());
        String name = "";
        for (Document document : documents) {
            String userid = "" + document.get("id");
            if (userid.equals(id)) {
                name = "" + document.get("name");
            }
        }
        return name;
    }

    //Unit Test, shows all items
    public void showitems(ItemList items) {
        for (Item item : items.getList()) {
            System.out.println(item.getName());
        }
    }

    //Unit Test, shows all users
    public void showusers() {
        List<Document> documents = (List<Document>) users.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String name = "" + document.get("name");
            System.out.println(name);
        }
    }

    //Unit Test, shows a item whose id is 01
    public void showaitem() {
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String itemId = "" + document.get("id");
            if (itemId.equals("01")) {
                System.out.println("Name: " + document.get("name"));
                System.out.println("Desc: " + document.get("desc"));
                System.out.println("Price: " + document.get("price"));
            }
        }
    }

    //Shows dummy item after it being listed
    public void showadummyitem(String id) {
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String itemId = "" + document.get("id");
            if (itemId.equals(id)) {
                System.out.println("Name: " + document.get("name"));
                System.out.println("Desc: " + document.get("desc"));
                System.out.println("Price: " + document.get("price"));
            }
        }
    }

    public void showadummyuser(String id) {
        List<Document> documents = (List<Document>) users.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String itemId = "" + document.get("id");
            if (itemId.equals(id)) {
                System.out.println("Name: " + document.get("name"));
                System.out.println("Desc: " + document.get("email"));
                System.out.println("Phone: " + document.get("phone"));
            }
        }
    }

    public void showtoys() {
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        for (Document doc : documents) {
            String name = (String) (doc.get("category"));
            if (name.contains("toys")) {
                System.out.println("Name: " + doc.get("name"));
            }
        }
    }

    public void showPuzzle() {
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        for (Document doc : documents) {
            String name = (String) (doc.get("name"));
            if (name.contains("Puzzle")) {
                System.out.println("Name: " + doc.get("name"));
            }
        }
    }

    public void showauser(String id, Users users) {
        for (User user : users.getList()) {
            if (user.getID().equals(id)) {
                System.out.println("ID: " + user.getID());
                System.out.println("Name: " + user.getName());
                System.out.println("IsAdmin: " + user.getIsAdmin());
            }
        }
    }

    public void showUserExists() {
        List<Document> documents = (List<Document>) users.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String id = "" + document.get("id");
            if (id.equals("11111111")) {
                System.out.println("Default User exists");
            }
        }
    }

    public void showUsersinfo() {
        List<Document> documents = (List<Document>) users.find().into(new ArrayList<Document>());
        for (Document doc : documents) {
            System.out.println("ID: " + doc.get("id"));
            System.out.println("Name: " + doc.get("name"));
            System.out.println("Email: " + doc.get("email"));
            System.out.println("Password: " + doc.get("password"));
            System.out.println("Phone: " + doc.get("phone"));
            System.out.println("IsAdmin: " + doc.get("isAdmin"));
            System.out.println("");
        }
    }

    public void showAucitems(ItemList items) {
        for (Item item : items.getList()) {
            if (item.ifAuc()) {
                System.out.println(item.getName());
            }
        }
    }

    public void showAucitemsbid(ItemList items) {
        for (Item item : items.getList()) {
            if (item.ifAuc()) {
                System.out.println(item.getName() + ":" + item.getPrice());
            }
        }
    }

    public void showreviews(ArrayList<Review> reviews) {
        for (Review review : reviews) {
            System.out.println(review.getTitle());
        }
    }

    public ArrayList<Review> getAllReviews() {
        List<Document> documents = (List<Document>) reviews.find().into(new ArrayList<Document>());
        ArrayList<Review> reviews = new ArrayList<Review>();
        for (Document document : documents) {
            Review review = new Review();
            review = new Review("" + document.get("id"), "" + document.get("ItemID"), "" + document.get("UserID"), "" + document.get("Desc"), "" + document.get("Title"), "" + document.get("DateListed"));
            reviews.add(review);
        }
        return reviews;
    }
    //Search items by keyword from Item Collection

    public ItemList searchItemList(String query) {
        ItemList searchList = new ItemList();
        for (Document doc : dbItems.find()) {
            String name = (String) (doc.get("name"));
            if (name.contains(query)) {
                Item item = new Item((String) doc.get("id"), (String) doc.get("name"),
                        (String) doc.get("dateListed"), (int) doc.get("stock"),
                        (double) doc.get("price"), (String) doc.get("desc"),
                        (String) doc.get("category"), (String) doc.get("sellerId"),
                        (String) doc.get("expdate"), (boolean) doc.get("ifAuc"), (String) doc.get("image"));
                searchList.addItem(item);
            }
        }
        return searchList;
    }
    //Search items by category from Item Collection

    public ItemList searchCategory(String query) {
        ItemList searchList = new ItemList();
        for (Document doc : dbItems.find()) {
            String name = (String) (doc.get("category"));
            if (name.equals(query)) {
                Item item = new Item((String) doc.get("id"), (String) doc.get("name"),
                        (String) doc.get("dateListed"), (int) doc.get("stock"),
                        (double) doc.get("price"), (String) doc.get("desc"),
                        (String) doc.get("category"), (String) doc.get("sellerId"),
                        (String) doc.get("expdate"), (boolean) doc.get("ifAuc"), (String) doc.get("image"));
                searchList.addItem(item);
            }
        }
        return searchList;
    }

    // Add users to User Collection
    public void add(User user) {
        List<Document> users = new ArrayList<>();
        users.add(new Document("Username", user.getEmail())
                .append("password", user.getPassword())
                .append("name", user.getName())
                .append("phone", user.getPhone())
                .append("isAdmin", user.getIsAdmin()));
        MongoCollection<Document> userlist = shopDB.getCollection("Users");
        userlist.insertMany(users);
    }
    //Get users from Users Collection

    public User getUser(String ID) {
        for (Document doc : users.find()) {
            String id = (String) (doc.get("id"));
            System.out.print(id + "------" + ID);
            if (id.equals(ID)) {
                return (new User((String) doc.get("id"), (String) doc.get("name"), (String) doc.get("email"), (String) doc.get("password"), (String) doc.get("phone"), (boolean) doc.get("isAdmin")));
            }
        }
        return null;
    }
    //Get users list from Users Collection

    public Users getUserList() {
        Users userList = new Users();
        User user = new User();
        for (Document doc : users.find()) {
            user = new User((String) doc.get("id"), (String) doc.get("name"), (String) doc.get("email"), (String) doc.get("password"), (String) doc.get("phone"), (boolean) doc.get("isAdmin"));
            userList.addUser(user);
        }
        return userList;
    }

    // Add users to User Collection
    public void addUser(String id, String name, String email, String password, String phone) {
        Document document = new Document("id", id).
                append("name", name).
                append("email", email).
                append("password", password).
                append("phone", phone);
        users.insertOne(document);
    }
	
	 // Add a user to the database
    public void addAUser(String id, String name, String email, String password, String phone, boolean isAdmin) {
        Document document = new Document("id", id).
                append("name", name).
                append("email", email).
                append("password", password).
                append("phone", phone).
                append("isAdmin", isAdmin);
        users.insertOne(document);
    }

    //Get Item with  matching sellerID
    public ArrayList<Item> getItemList(String id) {
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        ArrayList<Item> items = new ArrayList<Item>();
        for (Document document : documents) {
            String sellerid = "" + document.get("sellerId");
            if (sellerid.equals(id)) {
                Item item = new Item();
                item = new Item("" + document.get("id"), "" + document.get("name"), "" + document.get("dateListed"), Integer.parseInt("" + document.get("stock")),/* Integer.parseInt("" + document.get("soldQuantity")),*/ Double.parseDouble("" + document.get("price")), "" + document.get("desc"), "" + document.get("category"), "" + document.get("sellerId"), "" + document.get("expdate"), Boolean.parseBoolean("" + document.get("ifAuc")), "" + document.get("image"));
                items.add(item);
            }
        }
        return items;
    }

    /**
     *
     * @return
     */
    public Users loadUsers() {
        Users users = new Users();

        MongoCollection<Document> userlist = shopDB
                .getCollection("Users");
        for (Document doc : userlist.find()) {
            User user = new User((String) doc.get("Id"),
                    (String) doc.get("Name"),
                    (String) doc.get("Username"),
                    (String) doc.get("Password"), (String) doc.get("Phone"), (Boolean) doc.get("isAdmin"));
            users.addUser(user);
        }
        return users;
    }
    //Get Items  from Item Collection

    public Item getItem(String ID) {
        for (Document doc : dbItems.find()) {
            String id = (String) (doc.get("id"));
            System.out.print(id + "------" + ID);
            if (id.equals(ID)) {
                Item item = new Item((String) doc.get("id"), (String) doc.get("name"),
                        (String) doc.get("dateListed"), (int) doc.get("stock"),
                        (double) doc.get("price"), (String) doc.get("desc"),
                        (String) doc.get("category"), (String) doc.get("sellerId"),
                        (String) doc.get("expdate"), (boolean) doc.get("ifAuc"), (String) doc.get("image"));
                return item;

            }
        }
        return null;
    }

    public User userExists(String email, String password) {
        MongoCollection<Document> userlist = shopDB.getCollection("Users");
        Document doc = userlist.find(and(eq("email", email), eq("password", password))).first();
        User user = null;
        if (doc == null) {
            Document docForCheckPwd = userlist.find(eq("email", email)).first();
            if (docForCheckPwd != null) {
                user = new User((String) docForCheckPwd.get("id"), (String) docForCheckPwd.get("name"), (String) docForCheckPwd.get("email"), null, (String) docForCheckPwd.get("phone"), (Boolean) docForCheckPwd.get("isAdmin"));
            }
        } else {
            user = new User((String) doc.get("id"), (String) doc.get("name"), (String) doc.get("email"), (String) doc.get("password"), (String) doc.get("phone"), (Boolean) doc.get("isAdmin"));
        }

        return user;
    }
	
	//Deletes a item from database
    public void deleteItem(String id){
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String itemId = "" + document.get("id");
            if (itemId.equals(id)) {
                dbItems.deleteOne(document);
            }
        }
    }
    
    //Deletes a user from database
    public void deleteUser(String id){
        List<Document> documents = (List<Document>) users.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String itemId = "" + document.get("id");
            if (itemId.equals(id)) {
                users.deleteOne(document);
            }
        }
    }

    public void changePrice(String itemId, double price) {
        Bson filter = Filters.eq("id", itemId);
        Document document = new Document("$set", new Document("price", price));
        dbItems.updateOne(filter, document);
    }

    public double getUserScore(String id) {
        double score = 0;
        double count = 0;
        List<Document> documents = (List<Document>) ratings.find().into(new ArrayList<Document>());
        for (Document document : documents) {
            String ratedid = "" + document.get("rated");
            if (ratedid.equals(id)) {
                Rating rating = new Rating();
                rating = new Rating("" + document.get("id"), "" + document.get("rated"), "" + document.get("rater"), "" + document.get("Desc"), "" + document.get("Title"), "" + document.get("DateListed"), "" + document.get("score"));
                score += Double.parseDouble(rating.getScore());
                count++;
            }
        }
        score = score / count;
        return score;
    }
        //This is completely broken and dumb, each order should have its own id
    public void saveBuyOrder(Item item, String payType, String address, String userID) {
        Document document = new Document("itemID", item.getID()).
                append("price", item.getPrice()).
                append("userID", userID).
                append("dateListed", item.getDateListed()).
                append("address", address).
                append("method", payType);
        buyLogs.insertOne(document);
    }

    public void addWatchlist(String UID, String PID) {
        Document document = new Document("UserID", UID).
                append("ProductID", PID);
        WL.insertOne(document);
    }

    public void removeWL(String UID, String PID) {
        Document document = new Document("UserID", UID).
                append("ProductID", PID);
        WL.deleteOne(document);

    }

    public boolean check(String UID, String ID) {
        for (Document doc : WL.find()) {

            if (doc.get("ProductID").equals(ID) && doc.get("UserID").equals(UID)) {
                return true;
            }
        }
        return false;
    }

    //get order list by userId
    public ArrayList<Order> getOrderList(String id) {
        List<Document> documents = (List<Document>) orders.find().into(new ArrayList<Document>());
        ArrayList<Order> orders = new ArrayList<Order>();
        for (Document document : documents) {
            String userID = "" + document.get("userID");
            if (userID.equals(id)) {
                Order order = new Order();
                order = new Order("" + document.get("id"), "" + document.get("itemID"), "" + document.get("userID"), "" + document.get("address"), "" + document.get("dateListed"));
                orders.add(order);
            }
        }
        return orders;
    }

    //Gets the name of the item, which id is given
    public String getitemname(String id) {
        List<Document> documents = (List<Document>) dbItems.find().into(new ArrayList<Document>());
        String name = "";
        for (Document document : documents) {
            String itemID = "" + document.get("id");
            if (itemID.equals(id)) {
                name = "" + document.get("name");
            }
        }
        return name;
    }

    public ItemList getWL(String ID) {

        ItemList items = new ItemList();
        for (Document doc : dbItems.find()) {
            if (doc.get("id").equals(ID)) {

                Item item = new Item((String) doc.get("id"), (String) doc.get("name"),
                        (String) doc.get("dateListed"), (int) doc.get("stock"),
                        (double) doc.get("price"), (String) doc.get("desc"),
                        (String) doc.get("category"), (String) doc.get("sellerID"),
                        (String) doc.get("expdate"), (boolean) doc.get("ifAuc"), (String) doc.get("image"));
                items.addItem(item);

            }
        }
        return items;
    }

    public ItemList getWatchList(String UID) {
        ItemList WatchList = new ItemList();

        for (Document doc : WL.find()) {
            String id = "11111111"; //(String)(doc.get("UserID"));
            if (UID.equals(id)) {

                WatchList = getWL((String) doc.get("ProductID"));

            }
        }
        return WatchList;
    }

}
