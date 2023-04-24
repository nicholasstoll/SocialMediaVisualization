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
    private LinkedList<InfluencerData> something;

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
            "drew.monsour", "USA", "tech", 200, 25, 1500, 40, 200));
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
     * test method to get a list of influencers for a particular month, or the
     * first quarter
     */
    public void testGetInfluencersForMonth() {
        Exception exception = null;
        something.clear();
        try {
            test.getInfluencersForMonth("January");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(data);
        something.add(moreData);
        something.add(someData);
        LinkedList<Influencer> newList = new LinkedList<Influencer>();
        newList.add(data.getInfluencerForFirstQuarter());
        newList.add(moreData.getInfluencerForFirstQuarter());
        newList.add(someData.getInfluencerForFirstQuarter());
        assertEquals(newList, test.getInfluencersForMonth("First Quarter"));
        newList.clear();
        newList.add(new Influencer("February", "rhysj", "riceyjones", "USA",
            "politics", 200, 20, 1000, 25, 250));
        newList.add(new Influencer("February", "ansela", "ansel.ajayi", "USA",
            "politics", 100, 25, 1500, 25, 270));
        newList.add(new Influencer("February", "drewm", "drew.monsour", "USA",
            "tech", 250, 25, 1000, 40, 200));
        assertEquals(newList, test.getInfluencersForMonth("February"));
    }


    /**
     * test method to get the total traditional engagement for a particular
     * influencer
     */
    public void testGetQuarterlyTraditionalEngagementForInfluencer() {
        Exception exception = null;
        try {
            test.getQuarterlyTraditionalEngagementForInfluencer("jimmy.john");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        double engagement = data.getInfluencerForFirstQuarter()
            .getTraditionalEngagementRate();
        assertEquals(engagement, test
            .getQuarterlyTraditionalEngagementForInfluencer("riceyjones"),
            0.001);
    }


    /**
     * test method to get the total reach engagement for a particular influencer
     */
    public void testGetQuarterlyReachEngagementForInfluencer() {
        Exception exception = null;
        try {
            test.getQuarterlyReachEngagementForInfluencer("jimmy.john");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        double engagement = data.getInfluencerForFirstQuarter()
            .getReachEngagementRate();
        assertEquals(engagement, test.getQuarterlyReachEngagementForInfluencer(
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
        InfluencerData newData = new InfluencerData(new Influencer("January",
            "actionDan", "wizardHighSchool", "US", "education", 53882, 431,
            95800, 4129, 442422));
        newData.addMonthlyEntry(new Influencer("February", "actionDan",
            "wizardHighSchool", "US", "education", 20260, 402, 94300, 3830,
            608010));
        newData.addMonthlyEntry(new Influencer("March", "actionDan",
            "wizardHighSchool", "US", "education", 53357, 934, 120343, 6902,
            802180));
        Influencer influencer = newData.getInfluencerForFirstQuarter();
        System.out.println(influencer.getTraditionalEngagementRate());
        double counter = newData.getInfluencerForMonth("January")
            .getTraditionalEngagementRate() + newData.getInfluencerForMonth(
                "February").getTraditionalEngagementRate() + newData
                    .getInfluencerForMonth("March")
                    .getTraditionalEngagementRate();

        System.out.println(counter);
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
    public void testSortByChannelNameForMonth() {
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


    /**
     * test method to sort by traditional engagement for the first month
     */
    public void testSortByTraditionalEngagementForFirstQuarter() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByTraditionalEngagementForFirstQuarter();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(moreData);
        something.add(data);
        something.add(someData);
        LinkedList<Influencer> sortedData = test
            .sortByTraditionalEngagementForFirstQuarter();

        // Check that the sorted data has the correct order

        assertEquals(someData.getInfluencerChannelName(), sortedData.get(1)
            .getChannelName());
        assertEquals(data.getInfluencerChannelName(), sortedData.get(0)
            .getChannelName());
        assertEquals(moreData.getInfluencerChannelName(), sortedData.get(2)
            .getChannelName());
    }


    /**
     * test method to sort by reach engagement for all months
     */
    public void testSortByReachEngagementForFirstQuarter() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByReachEngagementForFirstQuarter();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(moreData);
        something.add(someData);
        something.add(data);

        LinkedList<Influencer> sortedData = test
            .sortByReachEngagementForFirstQuarter();

        assertEquals(someData.getInfluencerChannelName(), sortedData.get(0)
            .getChannelName());
        assertEquals(data.getInfluencerChannelName(), sortedData.get(1)
            .getChannelName());
        assertEquals(moreData.getInfluencerChannelName(), sortedData.get(2)
            .getChannelName());
        // order is somedata, data, moreData
    }


    /**
     * test method for sort by channel name for all influencer data
     */
    public void testSortByChannelName() {
        Exception exception = null;
        something.clear();
        try {
            test.sortByChannelNameForFirstQuarter();
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalStateException);
        something.add(data);
        something.add(someData);
        something.add(moreData);
        LinkedList<Influencer> sortedData = test
            .sortByChannelNameForFirstQuarter();

        System.out.println(sortedData);

        assertEquals(someData.getInfluencerChannelName(), sortedData.get(1)
            .getChannelName());
        assertEquals(data.getInfluencerChannelName(), sortedData.get(2)
            .getChannelName());
        assertEquals(moreData.getInfluencerChannelName(), sortedData.get(0)
            .getChannelName());
    }
}
