/**
 * 
 */
package prj5;

import java.util.Arrays;
import student.TestCase;

/**
 * @author Group116
 * 
 * @version 2023.17.04
 * 
 *          Test case for influencer class
 *
 */
public class InfluencerTest extends TestCase {

    private Influencer test;

    /**
     * set up method for influencer
     */
    public void setUp() {
        test = new Influencer("January", "rhysj", "riceyjones", "USA", "sports",
            200, 10, 1000, 15, 260);

    }


    /**
     * test for compareTo
     */
    public void testCompareTo() {
        Influencer same = new Influencer("January", "rhysj22", "riceyjones",
            "USA", "sports", 200, 10, 1000, 15, 260);
        Influencer testGreaterMonth = new Influencer("February", "rhysj",
            "whatsnew", "USA", "sports", 200, 10, 1000, 15, 260);

        assertEquals(0, test.compareTo(same));
        assertTrue(testGreaterMonth.compareTo(test) > 0);
        assertTrue(test.compareTo(testGreaterMonth) < 0);
        String[] something = new String[] { "this", "something", "else" };
        Arrays.sort(something);
        System.out.print(something[0]);
    }


    /**
     * test for get month
     */
    public void testGetMonth() {
        assertEquals("January", test.getMonth());
    }


    /**
     * tests for getUsername
     */
    public void testUsername() {
        assertEquals("rhysj", test.getUsername());
    }


    /**
     * tests for channel name
     */
    public void testGetChannelName() {
        assertEquals("riceyjones", test.getChannelName());
    }


    /**
     * test for get country
     */
    public void testGetCountry() {
        assertEquals("USA", test.getCountry());
    }


    /**
     * test for get main topic
     */
    public void testGetMainTopic() {
        assertEquals("sports", test.getMainTopic());
    }


    /**
     * test for get likes
     */
    public void testGetLikes() {
        assertEquals(200, test.getLikes());
    }


    /**
     * test for get post count
     */
    public void testGetPostCount() {
        assertEquals(10, test.getPostCount());
    }


    /**
     * test for get followercount
     */
    public void testGetFollowersCount() {
        assertEquals(1000, test.getFollowersCount());
    }


    /**
     * test for get comments count
     */
    public void testGetCommentsCount() {
        assertEquals(15, test.getCommentsCount());
    }


    /**
     * test for get views
     */
    public void testGetViews() {
        assertEquals(260, test.getViews());
    }


    /**
     * test for equals object
     */
    public void testEquals() {
        Influencer nullObject = null;
        Influencer testSame = test;
        Object testDifObject = new Object();

        Influencer testDifMonth = new Influencer("February", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260);
        Influencer testDifUser = new Influencer("January", "rhysj22",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260);
        Influencer testDifChannel = new Influencer("January", "rhysj", "ricey",
            "USA", "sports", 200, 10, 1000, 15, 260);
        Influencer testDifCountry = new Influencer("January", "rhysj",
            "riceyjones", "EU", "sports", 200, 10, 1000, 15, 260);
        Influencer testDifTopic = new Influencer("January", "rhysj",
            "riceyjones", "USA", "science", 200, 10, 1000, 15, 260);
        Influencer testDifLikes = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 250, 10, 1000, 15, 260);
        Influencer testDifPostCount = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 12, 1000, 15, 260);
        Influencer testDifFollowers = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1500, 15, 260);
        Influencer testDifComments = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 20, 260);
        Influencer testDifViews = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 300);
        Influencer testEquals = new Influencer("January", "rhysj", "riceyjones",
            "USA", "sports", 200, 10, 1000, 15, 260);

        assertTrue(test.equals(testSame));
        assertTrue(test.equals(testEquals));

        assertFalse(test.equals(nullObject));
        assertFalse(test.equals(testDifObject));
        assertFalse(test.equals(testDifMonth));
        assertFalse(test.equals(testDifUser));
        assertFalse(test.equals(testDifChannel));
        assertFalse(test.equals(testDifCountry));
        assertFalse(test.equals(testDifTopic));
        assertFalse(test.equals(testDifLikes));
        assertFalse(test.equals(testDifPostCount));
        assertFalse(test.equals(testDifFollowers));
        assertFalse(test.equals(testDifComments));
        assertFalse(test.equals(testDifViews));

    }


    /**
     * test for get engagement rate. Returns the traditional engagement rate of
     * the individual
     */
    public void testGetTraditionalEngagement() {
        Influencer zero = new Influencer("", "", "", "", "", 200, 30, 0, 30,
            100);
        assertEquals(0.0, zero.getTraditionalEngagementRate(), 0.001);
        double sum = ((double)215 / 1000) * 100;

        assertEquals(sum, test.getTraditionalEngagementRate(), 0.001);
    }


    /**
     * test for get reach engagement rate
     */
    public void testGetReachEngagementRate() {
        Influencer zero = new Influencer("", "", "", "", "", 200, 30, 200, 30,
            0);
        assertEquals(0.0, zero.getReachEngagementRate(), 0.001);
        double sum = ((double)215 / 260) * 100;

        assertEquals(sum, test.getReachEngagementRate(), 0.05);
    }


    /**
     * test for comparing Traditional engagement
     */
    public void testCompareTraditionalEngagement() {
        // ("January", "rhysj", "riceyjones", "USA", "sports",
        // 200, 10, 1000, 15, 260);
        Influencer sameEngagement = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260);
        Influencer greaterEngagement = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 100, 260);

        System.out.print(test.getTraditionalEngagementRate());
        System.out.print(greaterEngagement.getTraditionalEngagementRate());
        assertEquals(-1, greaterEngagement.compareTraditionalEngagement(test));
        assertEquals(1, test.compareTraditionalEngagement(greaterEngagement));
        assertEquals(0, test.compareTraditionalEngagement(sameEngagement));

    }


    /**
     * test for comparing reach engagement
     */
    public void testCompareReachEngagement() {
        Influencer sameEngagement = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260);
        Influencer greaterEngagement = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 100, 260);

        System.out.print(test.getReachEngagementRate());
        System.out.print(greaterEngagement.getReachEngagementRate());
        assertEquals(-1, greaterEngagement.compareReachEngagement(test));
        assertEquals(1, test.compareReachEngagement(greaterEngagement));
        assertEquals(0, test.compareReachEngagement(sameEngagement));
    }


    /**
     * test for to string
     */
    public void testToString() {
        String name =
            "January rhysj(riceyjones) Country:USA Topic:sports Likes:200 " +
                "Posts:10 Followers:1000 " +
                    "Total Comments:15 Total Views:260";
        assertEquals(name, test.toString());
    }
}
