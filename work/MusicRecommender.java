import java.io.*;
import java.util.ArrayList;

public class MusicRecommender {
    private String musicListFileName;
    private ArrayList<Music> music;
    private static String musicParts[];
    private static String track;
    private static String artist;
    private static String genre;
    private static String BPM;
    private static int intBPM;
    private static String popularity;
    private static int intPopularity;
    private static String preferredArtist;
    File f = new File(musicListFileName);
    FileOutputStream fos = new FileOutputStream(f);
    PrintWriter pw = new PrintWriter(fos);
    FileReader fr = new FileReader(f);
    BufferedReader bfr = new BufferedReader(fr);

    public MusicRecommender(String musicListFileName) throws FileNotFoundException, MusicFileFormatException {
        this.musicListFileName = musicListFileName;
        music.add(parseMusic(musicListFileName));
        this.music = music;
    }

    private static Music parseMusic(String musicInfoLine) throws MusicFileFormatException {
        musicParts = musicInfoLine.split("_"); // this just splits the name of the file, not the contents of the file
        track = musicParts[0];
        artist = musicParts[1];
        genre = musicParts[2];
        BPM = musicParts[3];
        intBPM = Integer.parseInt(BPM);
        popularity = musicParts[4];
        intPopularity = Integer.parseInt(popularity);
        return new Music(track, artist, genre, intBPM, intPopularity);
    }

    public ArrayList<Music> searchArtists(MusicProfile musicProfile) throws NoRecommendationException {
        preferredArtist = musicProfile.getPreferredArtist();

    }
}
