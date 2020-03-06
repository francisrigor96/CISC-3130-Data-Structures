package musicplaylist;

/**
 *
 * @author Francis Rigor
 */
import topstreamingartists.Artist; // Reusing the Artist class from the first homework
import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;
import java.util.Stack;
import java.io.PrintWriter;

public class MusicPlaylist {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        PrintWriter oFile = new PrintWriter("fileOutput.txt");
        LinkedList<String> songs = new LinkedList<>();

        // Dealing with each of the input files via command line
        for (String arg : args) {
            Scanner iFile = new Scanner(new File(arg));
            Artist artist = Artist.read(iFile);
            // Read the file
            while (iFile.hasNext()) {
                String songName = artist.getSongName();
                String artistName = artist.getArtistName();
                songs.add(artist.getSongName());
                artist = Artist.read(iFile);
            }
        }
        
        // Check how many songs were read from the file
        System.out.println("Songs added: " + songs.size());
        
        // Once all the files are read-in, sort all of the contents into ascending order
        Collections.sort(songs);
        
        // Get the elements from the linked list and add them to the queue
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < songs.size(); i++) {
            queue.add(songs.get(i));
        }

        // Display the contents of the queue (or playlist)
        System.out.println("\nThis queue has:");
        queue.forEach((toDisplay) -> {
            System.out.println(toDisplay);
        });
       
        System.out.println("\n------------------------------------------------");
        
        /**
         * Create a stack by emptying the queue. 
         * Each element of the stack represents a recently listened to song. 
         * As a song from the queue is listened to, it is removed and put into the stack.
         */
        Stack<String> listingHistory = new Stack<>();
         while (!queue.isEmpty()) {
            listingHistory.push(queue.remove());
        }
       
        // Display the contents of the stack
        System.out.println("The stack has:\n");
        listingHistory.forEach((display) -> {
            System.out.println(display);
        });
        
        // Check if the stack is empty
        System.out.println("\nIs the queue empty? " + queue.isEmpty());
        
        System.out.println("\nDone.");

    }

}
