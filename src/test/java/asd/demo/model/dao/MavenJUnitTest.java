/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package asd.demo.model.dao;

import asd.demo.model.Item;
import asd.demo.model.ItemList;
import asd.demo.model.Review;
import asd.demo.model.Users;
import asd.demo.model.dao.MongoDBConnector;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Random;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author mougi
 */
public class MavenJUnitTest {

    private static MongoDBConnector mdb;

    public MavenJUnitTest() {
    }

    @BeforeClass //Create an instance of MongoDBConnector using admin credentials for mLab
    public static void setUpClass() throws UnknownHostException {
        System.out.println("\n<-- Starting Unit test -->");
        mdb = new MongoDBConnector();
    }

    /*
    @Test
    public void testMongoDBConnect() throws UnknownHostException {
        Assert.assertNotNull("Cannot establish connection to MDB", mdb);
        System.out.println("\n- Connecting to MongoDB ");
    }

    @Test
    public void fetchItems() {
        ItemList items = mdb.getItemList();
        Assert.assertNotNull("Cannot fetch ASD items", items);
        System.out.println("\nFetching ASD items (Calvin)...");
        System.out.println("-------------------------------------");
        mdb.showitems(items);
    }

    @Test
    public void fetchAItem() {
        System.out.println("\nFetching ASD 1000 Piece Puzzle item (Calvin)...");
        System.out.println("-------------------------------------");
        mdb.showaitem();
    }

    @Test
    public void listDummyItem() {
        System.out.println("\nListing Dummy item (Alex)...");
        System.out.println("-------------------------------------");
        Random rand = new Random();
        int dummyId = rand.nextInt(99999999);
        mdb.addItem("" + dummyId, "Dummy Item", "0/00/0000", 0, 11.11, "A Dummy Item listed by the unit Test", "other", "11111111", "1/11/1111", Boolean.FALSE, "data:image/jpeg;base64,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");
        mdb.showadummyitem("" + dummyId);
    }



    @Test
    public void listDummyUser() {
        System.out.println("\nListing Dummy User (Chenkun)...");
        System.out.println("-------------------------------------");
        Random rand = new Random();
        int dummyId = rand.nextInt(999999);
        mdb.addUser("" + dummyId, "Dummy User", "Dummy@test.com", "dumbpassword", "000000000");
        mdb.showadummyuser("" + dummyId);
    }

    @Test
    public void fetchAucItems() {
        ItemList items = mdb.getItemList();
        Assert.assertNotNull("Cannot fetch ASD Auction items", items);
        System.out.println("\nFetching ASD Auction items (Weize)...");
        System.out.println("-------------------------------------");
        mdb.showAucitems(items);
    }

    @Test
    public void fetchAucItemsBid() {
        ItemList items = mdb.getItemList();
        Assert.assertNotNull("Cannot fetch ASD Auction items highest bid", items);
        System.out.println("\nFetching ASD Auction items highest bid (Weize)...");
        System.out.println("-------------------------------------");
        mdb.showAucitemsbid(items);
    }

    @Test
    public void fetchCategoryItems() {
        ItemList items = mdb.getItemList();
        Assert.assertNotNull("Cannot fetch ASD Toy Category items", items);
        System.out.println("\nFetching ASD Toy Category items (Changkeun)...");
        System.out.println("-------------------------------------");
        mdb.showtoys();
    }

    @Test
    public void fetchPuzzleItems() {
        ItemList items = mdb.getItemList();
        Assert.assertNotNull("Cannot fetch ASD items containing Puzzle", items);
        System.out.println("\nFetching ASD items containing Puzzle (Changkeun)...");
        System.out.println("-------------------------------------");
        mdb.showPuzzle();
    }

    @Test
    public void fetchUserExists() {
        System.out.println("Checking ASD Default user exits (Zhengyang)...");
        System.out.println("-------------------------------------");
        mdb.showUserExists();
    }

     */

    @Test
    public void fetchReviews() {
        ArrayList<Review> reviews = mdb.getAllReviews();
        Assert.assertNotNull("Cannot fetch ASD reviews", reviews);
        System.out.println("\nFetching ASD reviews (Alex)...");
        System.out.println("-------------------------------------");
        mdb.showreviews(reviews);
    }
    
    @Test
    public void fetchUserInfo() {
        System.out.println("Checking ASD users info as an admin(Calvin)...");
        System.out.println("-------------------------------------");
        mdb.showUsersinfo();
    }
    
    @Test
    public void fetchAucItemsBid() {
        ItemList items = mdb.getItemList();
        Assert.assertNotNull("Cannot fetch ASD liked items anon", items);
        System.out.println("\nFetching ASD liked items of anon (Weize)...");
        System.out.println("-------------------------------------");
        mdb.showAnonLikes();
    }
    
    
    @AfterClass
    public static void tearDownClass() {
        System.out.print("\n<-- Unit Test Finished : ");
    }
}
