package be.pxl.ja;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SpotifyReader {
    public static List<SpotifyRecord> loadSpotifyRecords(Path path) {

        try {
            List<String> records = Files.readAllLines(path);
            List<SpotifyRecord> spotifyRecordList = new ArrayList<>();

            for(String record: records) {

                SpotifyRecord spotifyRecord = null;
                try {
                    spotifyRecord = SpotifyRecordMapper.mapToSpotifyRecord(record);
                    spotifyRecordList.add(spotifyRecord);
                } catch (Exception e) {
                    System.err.println("Could not parse record..." + record);
                }
            }

            return spotifyRecordList;
        } catch (IOException e) {
            System.err.println("File kan niet gelezen...");
        }
        return null;
    }
}
