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
        String fileName = "SampleInput2_2022.csv";
        if(args.length == 1) {
            fileName = args[0];
        }
        InfluencerReader reader = new InfluencerReader(fileName);
        reader.printDifferentStatistics(reader);

    }

}
