package topstreamingartists;

import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.Collections;
import java.util.LinkedList;

public class TopStreamingArtists {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        /**
         * For the program to work correctly and not have an exception, the 
         * first 2 lines (which are comments) of the file have to be deleted so that the file only contains
         * the data to be read-in and not the comments.
         */
        final int ROW = 199;
        final int COL = 2;
        String[][] names = new String[ROW][COL];

        try {
            /**
             * The file is meant to be read from a command line argument since I
             * chose to rename the file and you may have different data than I
             * used.
             */
            Scanner inputFile = new Scanner(new File(args[0]));
            Artist artist = Artist.read(inputFile);

            /**
             * These ArrayLists are used in order to single out individual
             * variables from the Artist object
             */
            ArrayList<String> artistName = new ArrayList<>();
            ArrayList<String> songName = new ArrayList<>();

            // Read the file
            while (inputFile.hasNext()) {
                artistName.add(artist.getArtistName());
                songName.add(artist.getSongName());
                artist = Artist.read(inputFile);
            }

            // Fill the 2d array
            for (int i = 0; i < ROW; i++) {
                names[i][0] = songName.get(i);
                names[i][1] = artistName.get(i);
                System.out.println(songName.get(i) + " | " + artistName.get(i));
            }

            // Sorted list
            LinkedList<String> list = new LinkedList<>(artistName);
            Collections.sort(list); // sort the list in alphabetical order
            System.out.println("------------------------------------------");
            System.out.println("The sorted list is:\n");
            for (int idx = 0; idx < ROW; idx++) {
                System.out.println(list.get(idx));
            }

            // Display this message if the program doesn't go to one of the catch statements
            System.out.println("\nThe program was run successfully.");

        } catch (InputMismatchException a) {
            System.out.println("\n***InputMismatchException*** " + a.getMessage());
        } catch (FileNotFoundException b) {
            System.out.println("\n***FileNotFoundException*** " + b.getMessage());
        } catch (Exception c) {
            System.out.println("\n***Exception*** " + c.getMessage());
        }

    }

}
