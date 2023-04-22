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
    }


    /**
     * method to parse through a file provided in by a string
     * @param fileName is the name of the file we are trying to read
     * @throws FileNotFoundException
     *             if the file does not exist
     * @return a linked list of influencer data
     */
    private LinkedList<InfluencerData> readInfluencerFile(String fileName)
        throws FileNotFoundException {

        LinkedList<InfluencerData> newData = new LinkedList<InfluencerData>();
        Scanner file = new Scanner(new File(fileName));
        file.nextLine();

        while (file.hasNextLine()) {
            String read = file.nextLine();

            String tokens[] = read.split(", ");
            String name = tokens[0];
            String username = tokens[1];
            String channelName = tokens[2];
            String country = tokens[3];
            String mainTopic = tokens[4];
            int likes = Integer.valueOf(tokens[5]);
            int posts = Integer.valueOf(tokens[6]);
            int followers = Integer.valueOf(tokens[7]);
            int comments = Integer.valueOf(tokens[8]);
            int view = Integer.valueOf(tokens[9]);
            Influencer i = new Influencer(name, username, channelName, country,
                mainTopic, likes, posts, followers, comments, view);
            Iterator<InfluencerData> iter = newData.iterator();

            while (iter.hasNext()) {
                InfluencerData id = iter.next();
                if (id.getInfluencerChannelName().equals(i.getChannelName())) {
                    id.addMonthlyEntry(i);
                }
                else {
                    InfluencerData newID = new InfluencerData(i);
                    newData.add(newID);
                }
            }

        }
        return newData;
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
        data1 = calc.sortByChannelName();

        Iterator<InfluencerData> iter1 = data1.iterator();
        while (iter1.hasNext()) {
            InfluencerData influencer = iter1.next();
            System.out.println(influencer.getInfluencerChannelName());
            System.out.print("traditional: ");
            if (influencer.getTotalTraditionalEngagement() == 0.0) {
                System.out.println("N/A");
            }
            else {
                DecimalFormat decimal = new DecimalFormat("#.#");
                String formatted = decimal.format(influencer
                    .getTotalTraditionalEngagement());
                System.out.println(formatted);
            }
            System.out.println("==========");

        }
        System.out.println("**********");
        System.out.println("**********");

        LinkedList<InfluencerData> redoneData = reader.data;
        StatisticsCalculator newCalculator = new StatisticsCalculator(
            redoneData);
        redoneData = newCalculator.sortByReachEngagement();

        Iterator<InfluencerData> iter2 = redoneData.iterator();

        while (iter2.hasNext()) {
            InfluencerData influencer = iter2.next();
            System.out.println(influencer.getInfluencerChannelName());
            System.out.print("reach: ");
            if (influencer.getTotalReachEngagement() == 0.0) {
                System.out.println("N/A");
            }
            else {
                DecimalFormat decimal = new DecimalFormat("#.#");
                String formatted = decimal.format(influencer
                    .getTotalTraditionalEngagement());
                System.out.println(formatted);

            }
            System.out.println("==========");
        }

    }
}
