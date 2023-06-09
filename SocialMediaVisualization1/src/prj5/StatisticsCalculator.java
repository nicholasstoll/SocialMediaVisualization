/**
 * 
 */
package prj5;

import java.util.Iterator;

/**
 * @author Group 116
 * @version 2023.04.20
 *          Statistics calculator class meant to
 *          perform necessary calculations and sorting
 *          as needed
 *
 */
public class StatisticsCalculator {

    private LinkedList<InfluencerData> data;

    /**
     * constructor for statistics calculator
     * 
     * @param allData
     *            is taken in to be used
     *            by the calculator
     */
    public StatisticsCalculator(LinkedList<InfluencerData> allData) {
        data = allData;
    }


    /**
     * method to return all of the Influencer data
     * 
     * @return a linked list of all influencer data
     */
    public LinkedList<InfluencerData> getAllData() {
        return data;
    }


    /**
     * method to get the data for a specific
     * influencer specified by the parameter
     * 
     * @param channelName
     *            is the channelName of the
     *            influencer
     * @return influencerData for a particular influencer
     * @throws IllegalArgumentException
     *             if the channelName does not
     *             exist in the data
     */
    private InfluencerData getDataForInfluencer(String channelName) {
        Iterator<InfluencerData> iter = data.iterator();
        while (iter.hasNext()) {
            InfluencerData current = iter.next();
            if (current.getInfluencerChannelName().equals(channelName)) {
                return current;
            }
        }
        throw new IllegalArgumentException("Channel name does not exist");
    }


    /**
     * private supporter method to obtain a linked list of influencers that
     * correspond to a particular month or can be specified
     * 
     * @param month
     *            is the month we are looking for or FIRST Quarter, which allows
     *            the method to get the quarterly data
     * @return a linked list of influencers for the corresponding month/quarter
     * 
     */
    public LinkedList<Influencer> getInfluencersForMonth(String month) {
        if (data.isEmpty()) {
            throw new IllegalStateException();
        }
        if (month.equals("First Quarter")) {
            LinkedList<Influencer> list = new LinkedList<Influencer>();
            Iterator<InfluencerData> iter = data.iterator();
            while (iter.hasNext()) {
                InfluencerData next = iter.next();
                list.add(next.getInfluencerForFirstQuarter());
            }
            return list;
        }
        LinkedList<Influencer> list = new LinkedList<Influencer>();
        Iterator<InfluencerData> iter = data.iterator();
        while (iter.hasNext()) {
            InfluencerData next = iter.next();
            list.add(next.getInfluencerForMonth(month));
        }
        return list;
    }


    /**
     * Method to return the total traditional engagement for a
     * particular INfluencer finds the influencer data for
     * that channelname and then returns its total engagement rate
     * 
     * @param channelName
     *            is the influencer name we are looking for
     * @return a double representing the total traditional engagement
     *         for a particular user
     */
    public double getQuarterlyTraditionalEngagementForInfluencer(
        String channelName) {
        InfluencerData someData = getDataForInfluencer(channelName);
        return someData.getInfluencerForFirstQuarter()
            .getTraditionalEngagementRate();

    }


    /**
     * Method to return the total reach engagement for a particular
     * influencer using get data for influencer
     * 
     * @param channelName
     *            is the name of the influencer we a
     *            looking for
     * @return a double representing the reach engagement
     */
    public double getQuarterlyReachEngagementForInfluencer(String channelName) {
        InfluencerData someData = getDataForInfluencer(channelName);
        return someData.getInfluencerForFirstQuarter().getReachEngagementRate();
    }


    /**
     * Method to sort the influencers traditional engagement for a particular
     * month will create LinkedList of influencers for a particular
     * month and then sort it via insertion sort and return that list
     * 
     * @param month
     *            is the month we wish to sort
     * @return a linked list of influencers sorted via a particular month
     */
    public LinkedList<Influencer> sortByTraditonalEngagementForMonth(
        String month) {
        if (data.isEmpty()) {
            throw new IllegalStateException();
        }
        LinkedList<Influencer> list = getInfluencersForMonth(month);

        for (int i = 1; i < list.size(); i++) {
            Influencer key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTraditionalEngagement(
                key) > 0) {

                list.setDataAtNode(j + 1, list.get(j));
                j--;
            }
            list.setDataAtNode(j + 1, key);
        }
        return list;

    }


    /**
     * Method to sort the influencers reach engagement for a particular
     * month will create LinkedList of influencers for a particular
     * month and then sort it via insertion sort and return that list
     * 
     * @param month
     *            is the month we wish to sort
     * @return a linked list of influencers sorted via a particular month
     */
    public LinkedList<Influencer> sortByReachEngagementForMonth(String month) {
        if (data.isEmpty()) {
            throw new IllegalStateException();
        }
        LinkedList<Influencer> list = getInfluencersForMonth(month);

        for (int i = 1; i < list.size(); i++) {
            Influencer key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareReachEngagement(key) > 0) {

                list.setDataAtNode(j + 1, list.get(j));
                j--;
            }
            list.setDataAtNode(j + 1, key);
        }
        return list;

    }


    /**
     * Method to sort the influencers by name should sort them alphabetically
     * 
     * @param month
     *            is the month we with to sort for
     * @return a list of influencers that represents the sorted alphabetical
     *         list
     */
    public LinkedList<Influencer> sortByChannelNameForMonth(String month) {
        if (data.isEmpty()) {
            throw new IllegalStateException();
        }
        LinkedList<Influencer> list = getInfluencersForMonth(month);

        for (int i = 1; i < list.size(); i++) {
            Influencer key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.setDataAtNode(j + 1, list.get(j));
                j--;
            }
            list.setDataAtNode(j + 1, key);
        }
        return list;

    }


    /**
     * Method to sort influencers for total engagement for the entire quarter
     * 
     * @return a list of influencer data based on their total engagement
     */
    public LinkedList<Influencer> sortByTraditionalEngagementForFirstQuarter() {
        if (data.isEmpty()) {
            throw new IllegalStateException();
        }
        LinkedList<Influencer> list = getInfluencersForMonth(
            "First Quarter");

        for (int i = 1; i < list.size(); i++) {
            Influencer key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTraditionalEngagement(
                key) > 0) {

                list.setDataAtNode(j + 1, list.get(j));
                j--;
            }
            list.setDataAtNode(j + 1, key);
        }
        return list;

    }


    /**
     * Method to sort influence data for total reach engagement
     * for the entire quarter
     * 
     * @return a sorted list of influencer data
     */
    public LinkedList<Influencer> sortByReachEngagementForFirstQuarter() {
        if (data.isEmpty()) {
            throw new IllegalStateException();
        }
        LinkedList<Influencer> list = getInfluencersForMonth(
            "First Quarter");

        for (int i = 1; i < list.size(); i++) {
            Influencer key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareReachEngagement(key) > 0) {

                list.setDataAtNode(j + 1, list.get(j));
                j--;
            }
            list.setDataAtNode(j + 1, key);
        }
        return list;

    }


    /**
     * Method to sort influencer data by name in alphabetical order
     * 
     * @return a sorted list of influencer data based on name
     */
    public LinkedList<Influencer> sortByChannelNameForFirstQuarter() {
        if (data.isEmpty()) {
            throw new IllegalStateException();
        }
        LinkedList<Influencer> list = getInfluencersForMonth(
            "First Quarter");

        for (int i = 1; i < list.size(); i++) {
            Influencer key = list.get(i);
            int j = i - 1;
            while (j >= 0 && list.get(j).compareTo(key) > 0) {
                list.setDataAtNode(j + 1, list.get(j));
                j--;
            }
            list.setDataAtNode(j + 1, key);
        }
        return list;
    }

}

