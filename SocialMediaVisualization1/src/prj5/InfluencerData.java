/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author Group116
 * @version 2023.04.18
 *          Influencer Data controls a single Influencer but contains data for
 *          them for
 *          all months
 *
 */
public class InfluencerData {

    private LinkedList<Influencer> data;
    private String influencerChannelName;

    /**
     * Constructor for influencer data takes in an
     * 
     * @param newInfluencer
     *            that uses its name to create the name for
     *            the Class and adds the influencer as the first data point
     */
    public InfluencerData(Influencer newInfluencer) {
        influencerChannelName = newInfluencer.getChannelName();
        data = new LinkedList<Influencer>();
        addMonthlyEntry(newInfluencer);
    }


    /**
     * method to get the influencer channel name
     * 
     * @return the channel name of the data
     */
    public String getInfluencerChannelName() {
        return influencerChannelName;
    }


    /**
     * method to get all of the data of the influencer
     * 
     * @return the list of influencers
     */
    public LinkedList<Influencer> getData() {
        return data;
    }


    /**
     * method to get traditional engagement rate for month
     * 
     * @param month
     *            is the month we are trying to find
     * @return the double for the specified month
     * @throws IllegalArgumentException
     *             if the month in the
     *             parameter does not exist
     */
    public double getTraditionalEngagementForMonth(String month) {
        Iterator<Influencer> iter = data.iterator();

        while (iter.hasNext()) {
            Influencer person = iter.next();
            if (person.getMonth().equals(month)) {
                return person.getTraditionalEngagementRate();
            }
        }
        throw new IllegalArgumentException("No data for this month");
    }


    /**
     * method to get the reach engagement for a specific month
     * specified by
     * 
     * @param month
     *            which is the month we are looking for
     * @return the double for the specific month
     * @throws IllegalArgumentException
     *             if there is no data for the
     *             the month in the parameter
     */
    public double getReachEngagementForMonth(String month) {
        Iterator<Influencer> iter = data.iterator();

        while (iter.hasNext()) {
            Influencer person = iter.next();
            if (person.getMonth().equals(month)) {
                return person.getReachEngagementRate();
            }

        }

        throw new IllegalArgumentException("No data for this month");
    }


    /**
     * method to determine if the month is valid
     * 
     * @param month
     *            is the string we are checking
     * @return true if the month is
     *         of of the twelve months
     */
    private boolean isValidMonth(String month) {
        if (month.equals("January")) {
            return true;
        }
        else if (month.equals("February")) {
            return true;
        }
        else if (month.equals("March")) {
            return true;
        }
        else if (month.equals("April")) {
            return true;
        }
        else if (month.equals("June")) {
            return true;
        }
        else if (month.equals("July")) {
            return true;
        }
        else if (month.equals("August")) {
            return true;
        }
        else if (month.equals("September")) {
            return true;
        }
        else if (month.equals("October")) {
            return true;
        }
        else if (month.equals("November")) {
            return true;
        }
        return month.equals("December");
    }


    /**
     * boolean method to ensure that the entry is valid.
     * This means that an iterator will iterate through
     * all of the data to ensure the month of the influencer
     * does not already exist
     * 
     * @param influencer
     *            is the influnecer we are looking at
     * @return if the influencer can successfully be added
     */
    private boolean isValid(Influencer influencer) {
        if (influencer == null) {
            return false;
        }
        if (!influencer.getChannelName().equals(influencerChannelName)) {
            return false;
        }
        Iterator<Influencer> iter = data.iterator();
        while (iter.hasNext()) {
            Influencer existingInfluencer = iter.next();
            if (existingInfluencer.getMonth().equals(influencer.getMonth())) {
                return false;
            }
        }
        return true;
    }


    /**
     * method to add the Influencer to the list
     * should check to see if the influencer is valid first
     * 
     * @param influencer
     *            is the influencer we are trying to add
     * @return true if the month was successfully added
     */
    public boolean addMonthlyEntry(Influencer influencer) {
        if (isValid(influencer) && isValidMonth(influencer.getMonth())) {
            data.add(influencer);
            return true;
        }
        return false;
    }


    /**
     * method to return influencer data for a particular month
     * 
     * @param month
     *            is the month we were looking for
     * @return an influencer for a particular month
     */
    public Influencer getInfluencerForMonth(String month) {
        if (data.isEmpty()) {
            throw new IllegalStateException("No Data");
        }

        Iterator<Influencer> iter = data.iterator();
        while (iter.hasNext()) {
            Influencer next = iter.next();
            if (next.getMonth().equals(month)) {
                return next;
            }

        }
        return new Influencer(month, "", this.influencerChannelName, "", "", 0,
            0, 0, 0, 0);
    }


    /**
     * Method to get an influencer that combines influencers for a full quarter
     * 
     * @return a single influencer that includes a combination of all of the
     *         influencers for the first quarter
     */
    public Influencer getInfluencerForFirstQuarter() {
        if (data.isEmpty()) {
            return null;
        }
        String month = "First Quarter";
        String username = "";
        String channelName = influencerChannelName;
        String country = "";
        String mainTopic = "";
        int likes = 0;
        int posts = 0;
        int followers = this.getInfluencerForMonth("March").getFollowersCount();
        int comments = 0;
        int views = 0;
        int counter = 0;
        Iterator<Influencer> iter = data.iterator();
        while (iter.hasNext() && counter < 3) {
            Influencer influencer = iter.next();
            username = influencer.getUsername();
            country = influencer.getCountry();
            mainTopic = influencer.getMainTopic();
            likes = likes + influencer.getLikes();
            posts = posts + influencer.getPostCount();
            comments = comments + influencer.getCommentsCount();
            views = views + influencer.getViews();
            counter++;
        }
        return new Influencer(month, username, channelName, country, mainTopic,
            likes, posts, followers, comments, views);

    }
}

    

