
/********************************************************
 *                                                      *
 * Author:      Kalen Gladu-Lauridsen                   *
 * Date:        21 Nov 2020                             *
 * Course:      20F_CST8130_300 Data Structures         *
 *                                                      *
 * Purpose:     To be capable of using this program     *
 *              to keep track of keys and their values  *
 *              in a TreeMap                            *
 *                                                      *
 ********************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Dictionary {
    private TreeMap<String, Integer> treeMap = new TreeMap<>();
    private ArrayList<String> listFile = new ArrayList<>();

    /**
     * Reads from a file and adds content to an ArrayList after that it has been put
     * to lower case and removed all non characters
     * 
     * @param fileName User input
     */
    public void readFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scan = new Scanner(file);
            while (scan.hasNext()) {
                String info = scan.next();
                listFile.add(info.toLowerCase().replaceAll("[^a-z]", ""));
            }
            scan.close();
        } catch (FileNotFoundException fne) {
            System.out.println("File was not found");
            fne.printStackTrace();
        }
    }

    /**
     * Reads user input and adds it to an ArrayList once after that it has been put
     * to lower case and removed all non characters
     * 
     * @param word User input
     */
    public void readFromUser(String[] word) {
        for (int i = 0; i < word.length; i++) {
            listFile.add(word[i].toLowerCase().replaceAll("[^a-z]", ""));
        }
    }

    /**
     * Calls addToTree method and adds listFile ArrayList
     */
    public void addToTree() {
        addToTree(listFile);
    }

    /**
     * Adds contents of an ArrayList to a TreeMap with a starting value of 1 if it
     * is not currently in the TreeMap or adds a value of +1 if the key already
     * exists within the TreeMap
     * 
     * @param words ArrayList
     */
    public void addToTree(ArrayList<String> words) {
        treeMap = new TreeMap<>();
        for (String word : words) {
            if (treeMap.containsKey(word)) {
                int count = treeMap.get(word);
                treeMap.put(word, count + 1);
            } else {
                treeMap.put(word, 1);
            }
        }
    }

    /**
     * Searches for user input in the TreeMap
     * 
     * @param word user's input
     * @return return value of the key if the key is found in the TreeMap and
     *         returns -1 if the key has not been found
     */
    public int search(String word) {
        if (treeMap.containsKey(word))
            return treeMap.get(word);
        return -1;
    }

    /**
     * Finds number of nodes in the TreeMap
     */
    public int nodeNum() {
        return treeMap.size();
    }

    /**
     * Empties both the TreeMap and ArrayList
     */
    public void reset() {
        treeMap.clear();
        listFile.clear();
    }

    /**
     * Checks if the TreeMap is empty
     * 
     * @return returns -1 if TreeMap is empty and returns 0 if it is not
     */
    public int isEmpty() {
        if (treeMap.isEmpty())
            return -1;
        return 0;
    }
}