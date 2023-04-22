/**
 * 
 */
package prj5;

import student.TestCase;

/**
 * @author Group 116
 * @version 2023.04.20
 *          Test class for statistics calculator
 *
 */
public class StatsiticsCalculatorTest extends TestCase {

    private StatisticsCalculator test;
    private InfluencerData data;
    private InfluencerData moreData;
    private InfluencerData someData;
    LinkedList<InfluencerData> something;

    /**
     * set up method for statistics calculator
     * 
     */
    public void setUp() {
        data = new InfluencerData(new Influencer("January", "rhysj",
            "riceyjones", "USA", "sports", 200, 10, 1000, 15, 260));
        moreData = new InfluencerData(new Influencer("January", "ansela",
            "ansel.ajayi", "USA", "politics", 100, 20, 1000, 20, 260));
        someData = new InfluencerData(new Influencer("January", "drewm",
            "drew.monsour", "USA", "tech", 100, 20, 1000, 25, 200));
        data.addMonthlyEntry(new Influencer("February", "rhysj", "riceyjones",
            "USA", "politics", 200, 20, 1000, 25, 250));
        moreData.addMonthlyEntry(new Influencer("February", "ansela",
            "ansel.ajayi", "USA", "politics", 100, 25, 1500, 25, 270));
        someData.addMonthlyEntry(new Influencer("February", "drewm",
            "drew.monsour", "USA", "tech", 250, 25, 1000, 40, 200));
        data.addMonthlyEntry(new Influencer("March", "rhysj", "riceyjones",
            "USA", "sports", 200, 10, 1000, 15, 260));
        moreData.addMonthlyEntry(new Influencer("March", "ansela",
            "ansel.ajayi", "USA", "politics", 100, 20, 1000, 20, 250));
        someData.addMonthlyEntry(new Influencer("March", "drewm",
            "drew.monsour", "USA", "tech", 200, 25, 1000, 40, 200));
        something = new LinkedList<InfluencerData>();
        something.add(data);
        something.add(moreData);
        something.add(someData);
        test = new StatisticsCalculator(something);
    }


    /**
     * test method to return all of the data in the satatistics Calculator
     */
    public void testGetAllData() {
        assertEquals(3, test.getAllData().size());
    }


    /**
     * tests method to get data for a particular influencer
     */
    public void testGetDataForInfluencer() {
        Exception exception = null;
        try {
            test.getDataForInfluencer("jimmy.john");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        assertEquals("riceyjones", test.getDataForInfluencer("riceyjones")
            .getInfluencerChannelName());
    }


    /**
     * test method to get the total traditional engagement for a particular
     * influencer
     */
    public void testGetTotalTraditionalEngagementForInfluencer() {
        Exception exception = null;
        try {
            test.getTotalTraditionalEngagementForInfluencer("jimmy.john");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        double engagement = data.getTotalTraditionalEngagement();
        assertEquals(engagement, test
            .getTotalTraditionalEngagementForInfluencer("riceyjones"), 0.001);
    }


    /**
     * test method to get the total reach engagement for a particular influencer
     */
    public void testGetTotalReachEngagement() {
        Exception exception = null;
        try {
            test.getTotalReachEngagementForInfluencer("jimmy.john");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        double engagement = data.getTotalReachEngagement();
        assertEquals(engagement, test.getTotalReachEngagementForInfluencer(
            "riceyjones"), 0.001);
    }


    /**
     * test method to sort the influencers by traditional engagement for a
     * particular month
     * 
     */
    public void testSortByTraditionalEngagementForMonth() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByTraditonalEngagementForMonth("January");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(someData);
        something.add(moreData);
        something.add(data);

        LinkedList<Influencer> uhh = new LinkedList<Influencer>();
        uhh.add(new Influencer("January", "rhysj", "riceyjones", "USA",
            "sports", 200, 10, 1000, 15, 260));
        uhh.add(new Influencer("January", "drewm", "drew.monsour", "USA",
            "tech", 100, 20, 1000, 25, 200));
        uhh.add(new Influencer("January", "ansela", "ansel.ajayi", "USA",
            "politics", 100, 20, 1000, 20, 260));

        assertEquals(uhh, test.sortByTraditonalEngagementForMonth("January"));

    }


    /**
     * test method to sort the influencers by reach for a particular month
     */
    public void testSortByReachEngagementForMonth() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByReachEngagementForMonth("January");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(someData);
        something.add(moreData);
        something.add(data);

        LinkedList<Influencer> sortedList = test.sortByReachEngagementForMonth(
            "February");
        assertEquals(3, sortedList.size());
        assertEquals("drewm", sortedList.get(0).getUsername());
        assertEquals("rhysj", sortedList.get(1).getUsername());
        assertEquals("ansela", sortedList.get(2).getUsername());
    }


    /**
     * test method for sort by name for month
     */
    public void tetSortByChannelNameForMonth() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByChannelNameForMonth("January");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(someData);
        something.add(moreData);
        something.add(data);
        LinkedList<Influencer> sortedList = test.sortByChannelNameForMonth(
            "January");
        assertEquals("ansela", sortedList.get(0).getUsername());
        assertEquals("drewm", sortedList.get(1).getUsername());
        assertEquals("rhysj", sortedList.get(2).getUsername());
    }


    public void testSortByTraditionalEngagement() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByTraditionalEngagement();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(someData);
        something.add(moreData);
        something.add(data);
        LinkedList<InfluencerData> sortedData = test
            .sortByTraditionalEngagement();

        // Check that the sorted data has the correct order
        assertEquals(someData, sortedData.get(0));
        assertEquals(data, sortedData.get(1));
        assertEquals(moreData, sortedData.get(2));
    }


    /**
     * test method to sort by reach engagement for all months
     */
    public void testSortByReachEngagement() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByReachEngagement();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(moreData);
        something.add(someData);
        something.add(data);

        LinkedList<InfluencerData> sortedData = test.sortByReachEngagement();
        assertEquals(someData, sortedData.get(0));
        assertEquals(data, sortedData.get(1));
        assertEquals(moreData, sortedData.get(2));
        // order is somedata, data, moreData
    }


    /**
     * test method for sort by channel name for all influencer data
     */
    public void testSortByChannelName() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByChannelName();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(moreData);
        something.add(someData);
        something.add(data);
        LinkedList<InfluencerData> sortedData = test.sortByChannelName();
        assertEquals(someData, sortedData.get(1));
        assertEquals(data, sortedData.get(2));
        assertEquals(moreData, sortedData.get(0));
    }
}
