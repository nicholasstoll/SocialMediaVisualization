package prj5;

import java.io.FileNotFoundException;

/**
 * 
 * @author Group 116
 * @version 2023.04.21
 *          Input class is the project runner
 *          Should run the program based on the file provided
 *
 */
public class Input {

    public static void main(String[] args) throws FileNotFoundException {
        String file = "SocialMediaVisualization/SampleInput1_2022.csv";
        if (args.length == 1) {
            file = args[0];
        }
        InfluencerReader reader = new InfluencerReader(file);

    }

}
