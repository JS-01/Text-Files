package playingwithtextfiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class PlayingWithTextFiles {

    public static ArrayList<String> textItems = new ArrayList<>();

    public static String fullDir;

    public static void getDir() {
        fullDir = System.getProperty("user.dir") + "\\myText.txt";
    }

    public static void writeFile() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Name and Surname");
        String myStr = input.nextLine();

        try {
            FileWriter writeToFile = new FileWriter(fullDir, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            printToFile.println(myStr);
            printToFile.close();
            writeToFile.close();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }

    public static void readFile() {
        String inputLine;
        try {
            BufferedReader read = new BufferedReader(new FileReader(fullDir));
            while ((inputLine = read.readLine()) != null) {
                textItems.add(inputLine);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
    
   public static void printItems() {
       for (int i = 0; i < textItems.size(); i++) {
           System.out.println(textItems.get(i));
       }
   }

    public static void main(String[] args) {
        getDir();
        System.out.println(fullDir);
        writeFile();
        readFile();
        printItems();
    }

}
