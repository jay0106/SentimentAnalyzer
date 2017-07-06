// Read input from a txt file line by line

import java.io.*;
import java.util.ArrayList;

public class InputReview {
    public static ArrayList<String> read(String filename){
        ArrayList<String> data = new ArrayList<>();
        //try with resources. auto close
        try(BufferedReader br = new BufferedReader(new InputStreamReader
                (new FileInputStream(filename), "UTF-8"))){
            String line;
            while((line = br.readLine()) != null){
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
