package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    public  List<String> readFileAndConvertToStringArray(String filename) {
        List<String> rows = new ArrayList<>();

        try {
            File file = new File("src/main/resources/"+filename);
            Scanner myReader = new Scanner(file);

            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                //System.out.println(line);
                rows.add(line);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            e.printStackTrace();
        }

        return rows;
    }

    public String readFileAndConvertToString(String filename) {
        try {
            File file = new File("src/main/resources/"+filename);
            Scanner myReader = new Scanner(file);

            return myReader.nextLine();

        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
            e.printStackTrace();
            return "";
        }
    }
}
