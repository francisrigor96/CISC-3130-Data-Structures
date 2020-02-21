package topstreamingartists;

import java.util.LinkedList;
import java.util.Scanner;

public class Artist {

    private String position;       // The artist's posiion number
    private String songName;    // The artist's song name
    private String artistName;  // The name of this artist
    private String streams;        // The number of users who streamed this artist's song
    private String url;   // The url of this song

    //--------------------------***Constructor***---------------------------------------------
    public Artist(String position, String songName, String artistName, String streams, String url) {
        this.position = position;
        this.songName = songName;
        this.artistName = artistName;
        this.streams = streams;
        this.url = url;
    }

    //------------------------***Getter methods***----------------------------------------------
    public String getArtistName() {
        return this.artistName;
    }

    public String getSongName() {
        return this.songName;
    }

    public String getPosition() {
        return this.position;
    }

    public String getStreams() {
        return this.streams;
    }

    //-----------------------***Setter methods***--------------------------------------------
    public void setArtistName(String name) {
        this.artistName = name;
    }

    public void setSongName(String song) {
        this.songName = song;
    }

    public void setPosition(String pos) {
        this.position = pos;
    }

    public void setStreams(String stream) {
        this.streams = stream;
    }

    //-----------------------***Other methods***-------------------------------------------
    
    /**
     * This method was created to test if all of the data fields are getting in the data needed
     * 
     * @return A line containing all the data fields on a successful read-in
     */
    @Override
    public String toString() {
        return position + ", " + songName + ", " + artistName + ", " + streams + ", " + url + "\n";
    }

    /**
     * This method will read-in from the file to create an Artist object
     *
     * @param scanner The scanner object containing the file
     * @return An object of the Artist class
     */
    public static Artist read(Scanner scanner) {
        String line = scanner.nextLine(); // get the line
        String[] results = line.split(","); // split it on the commas
        return new Artist(results[0], results[1], results[2], results[3], results[4]);
    }

}
