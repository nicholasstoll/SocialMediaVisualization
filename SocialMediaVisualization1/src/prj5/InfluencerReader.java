/**
 * 
 */
package prj5;

import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * @author Group 116
 * @version 2023.04.21
 *          Class to read influencer file and add influencers accordingly
 */
public class InfluencerReader {
    private LinkedList<InfluencerData> data;
    private LinkedList<Influencer> januaryData;
    private LinkedList<Influencer> februaryData;
    private LinkedList<Influencer> marchData;
    private LinkedList<Influencer> quarterlyData;

    /**
     * constructor for playlist reader takes in a single file
     * of recorded monthly influencers
     * 
     * @param influencerFile
     *            is the file of influencers
     */
    public InfluencerReader(String influencerFile)
        throws FileNotFoundException {

        data = readInfluencerFile(influencerFile);
        StatisticsCalculator calculator = new StatisticsCalculator(data);
        januaryData = calculator.getInfluencersForMonth("January");
        februaryData = calculator.getInfluencersForMonth("February");
        marchData = calculator.getInfluencersForMonth("March");
        quarterlyData = calculator.getInfluencersForMonth("First Quarter");
    }


    /**
     * method to parse through a file provided in by a string
     * 
     * @param fileName
     *            is the name of the file we are trying to read
     * @throws FileNotFoundException
     *             if the file does not exist
     * @return a linked list of influencer data
     */
    private LinkedList<InfluencerData> readInfluencerFile(String fileName)
        throws FileNotFoundException {

        LinkedList<InfluencerData> data = new LinkedList<InfluencerData>();
        Scanner file = new Scanner(new File(fileName));
        if (file.hasNextLine()) {
            file.nextLine();
        }

        while (file.hasNextLine()) {
            String read = file.nextLine();
            String[] tokens = read.split(",");

            String month = tokens[0];
            String username = tokens[1];
            String channel = tokens[2];
            String country = tokens[3];
            String main = tokens[4];
            int likes = Integer.valueOf(tokens[5]);
            int posts = Integer.valueOf(tokens[6]);
            int followers = Integer.valueOf(tokens[7]);
            int comments = Integer.valueOf(tokens[8]);
            int views = Integer.valueOf(tokens[9]);
            Influencer in = new Influencer(month, username, channel, country,
                main, likes, posts, followers, comments, views);

            boolean found = false;
            Iterator<InfluencerData> iter = data.iterator();
            while (iter.hasNext()) {
                InfluencerData i = iter.next();
                if (in.getChannelName().equals(i.getInfluencerChannelName())) {
                    i.addMonthlyEntry(in);
                    found = true;
                    break;
                }
            }
            if (!found) {
                data.add(new InfluencerData(in));
            }
        }

        return data;
    }


    /**
     * method to print data based on the expected output of the
     * data
     * 
     * @param reader
     *            is the influencer reader
     * 
     */
    public void printDifferentStatistics(InfluencerReader reader) {
        LinkedList<InfluencerData> data1 = reader.data;
        StatisticsCalculator calc = new StatisticsCalculator(data1);

        LinkedList<Influencer> influencers1 = calc
            .sortByChannelNameForFirstQuarter();

        Iterator<Influencer> iter1 = influencers1.iterator();
        while (iter1.hasNext()) {

            Influencer i1 = iter1.next();
            System.out.println(i1.getChannelName());
            System.out.print("traditional: ");
            if (i1.getTraditionalEngagementRate() == 0.0) {
                System.out.println("N/A");
            }
            else {
                DecimalFormat decimal = new DecimalFormat("#.#");
                String formatted = decimal.format(i1
                    .getTraditionalEngagementRate());
                System.out.println(formatted);
            }
            System.out.println("==========");

        }
        System.out.println("**********");
        System.out.println("**********");

        LinkedList<Influencer> influencers2 = calc
            .sortByReachEngagementForFirstQuarter();

        Iterator<Influencer> iter2 = influencers2.iterator();

        while (iter2.hasNext()) {
            Influencer i2 = iter2.next();
            System.out.println(i2.getChannelName());
            System.out.print("reach: ");
            if (i2.getReachEngagementRate() == 0.0) {
                System.out.println("N/A");
            }
            else {
                DecimalFormat decimal = new DecimalFormat("#.#");
                String formatted = decimal.format(i2.getReachEngagementRate());
                System.out.println(formatted);

            }
            System.out.println("==========");
        }

    }
}
