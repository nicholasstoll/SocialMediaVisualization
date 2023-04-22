/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Group 116
 * @version 2023.04.19
 *          Test class for Influencer data
 *
 */
public class InfluencerDataTest extends TestCase {

    private InfluencerData test;

    /**
     * set up method for influencer data
     */
    public void setUp() {
        Influencer testInfluencer = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260);

        test = new InfluencerData(testInfluencer);

    }


    /**
     * test method for get influencer data name. Should return the username of
     * the influnecer data
     * based on the influencer in the parameter
     */
    public void testGetInfluencerChannelName() {

        assertEquals("riceyjones", test.getInfluencerChannelName());
    }


    /**
     * test method for get data should return a linked List of the influencer
     * data
     */
    public void testGetData() {

        LinkedList<Influencer> something = new LinkedList<Influencer>();
        something.add(new Influencer("January", "rhysj", "riceyjones", "USA",
            "sports", 200, 10, 1000, 15, 260));

        assertTrue(something.equals(test.getData()));
    }


    /**
     * method to return the traditional engagement rate for a particular month
     */
    public void testGetTraditionalEngagementForMonth() {
        Exception exception = null;
        try {
            test.getTraditionalEngagementForMonth("February");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        exception = null;
        try {
            test.getTraditionalEngagementForMonth("");

        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        Influencer data = test.getData().get(0);
        assertEquals(data.getTraditionalEngagementRate(), test
            .getTraditionalEngagementForMonth("January"), 0.001);
        test.addMonthlyEntry(new Influencer("February", "rhysj", "riceyjones",
            "USA", "sports", 200, 10, 1000, 15, 260));

        data = test.getData().get(1);
        assertEquals(data.getTraditionalEngagementRate(), test
            .getTraditionalEngagementForMonth("February"), 0.001);

    }


    /**
     * method to return the reach engagement rate for a particular month
     */
    public void testGetReachEngagementForMonth() {
        Exception exception = null;
        try {
            test.getReachEngagementForMonth("February");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        exception = null;
        try {
            test.getReachEngagementForMonth("");

        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        Influencer data = test.getData().get(0);
        assertEquals(data.getReachEngagementRate(), test
            .getReachEngagementForMonth("January"), 0.001);
        test.addMonthlyEntry(new Influencer("February", "rhysj", "riceyjones",
            "USA", "sports", 200, 10, 1000, 15, 260));

        data = test.getData().get(1);
        assertEquals(data.getReachEngagementRate(), test
            .getReachEngagementForMonth("February"), 0.001);

    }


    /**
     * test method to add a monthly influencer to the influencer data
     */
    public void testAddMonthlyEntry() {
        assertFalse(test.addMonthlyEntry(null));
        assertFalse(test.addMonthlyEntry(new Influencer("January", "rhysj",
            "ricey", "USA", "sports", 200, 10, 1000, 15, 260)));
        assertFalse(test.addMonthlyEntry(new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1500, 15, 260)));
        assertTrue(test.addMonthlyEntry(new Influencer("February", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260)));
    }


    /**
     * test method to return an influencer for a particular month
     */
    public void testGetInfluencerForMonth() {
        InfluencerData data = new InfluencerData(new Influencer("February",
            "rhysj", "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260));
        data.getData().clear();
        Exception exception = null;
        try {
            data.getInfluencerForMonth("February");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        assertNull(test.getInfluencerForMonth("February"));
        Influencer testInfluencer = new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260);
        assertEquals(testInfluencer, test.getInfluencerForMonth("January"));
    }


    /**
     * test method to get the total traditional engagement rate for the whole
     * influencer data
     */
    public void testGetTotalTraditionalEngagement() {
        InfluencerData data = new InfluencerData(new Influencer("February",
            "rhysj", "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260));
        data.getData().clear();
        Exception exception = null;
        try {
            data.getTotalTraditionalEngagement();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        test.addMonthlyEntry(new Influencer("February", "rhysj", "riceyjones",
            "USA", "sports", 200, 10, 1000, 15, 260));
        int comments = test.getInfluencerForMonth("January").getCommentsCount() + test.getInfluencerForMonth("February").getCommentsCount();
        int likes = test.getInfluencerForMonth("January").getLikes() + test.getInfluencerForMonth("February").getLikes();
        int followers = test.getInfluencerForMonth("January").getFollowersCount() + test.getInfluencerForMonth("February").getFollowersCount();
        double counter = (((double)comments + likes) / followers) * 100;
        assertEquals(counter, test.getTotalTraditionalEngagement(), 0.001);
    }


    /**
     * test method to get the total reach engagement rate for the influnecer
     * data
     */
    public void testGetTotalReachEngagement() {
        InfluencerData data = new InfluencerData(new Influencer("February",
            "rhysj", "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260));
        data.getData().clear();
        Exception exception = null;
        try {
            data.getTotalReachEngagement();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        test.addMonthlyEntry(new Influencer("February", "rhysj", "riceyjones",
            "USA", "sports", 200, 10, 1000, 15, 260));
        
        int comments = test.getInfluencerForMonth("January").getCommentsCount() + test.getInfluencerForMonth("February").getCommentsCount();
        int likes = test.getInfluencerForMonth("January").getLikes() + test.getInfluencerForMonth("February").getLikes();
        int views = test.getInfluencerForMonth("January").getViews() + test.getInfluencerForMonth("February").getViews();
        double counter = (((double)comments + likes) / views) * 100;
        assertEquals(counter, test.getTotalReachEngagement(), 0.001);
    }

}
