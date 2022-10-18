package be.pxl.ja;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpotifyRecordTest {

    @Test
    public void testParsSpotifyRecord() throws Exception {

        // bpm;energy;danceability;loudness;liveness;valence;length;acousticness;speechiness;popularity
        String record = "28;It's You;Ali Gatie;canadian hip hop;96;46;73;-7;19;40;213;37;3;89";
        SpotifyRecord spotifyRecord = SpotifyRecordMapper.mapToSpotifyRecord(record);
        assertEquals(28, spotifyRecord.getId());
        assertEquals("It's You", spotifyRecord.getTrackName());
        assertEquals("Ali Gatie", spotifyRecord.getArtistName());
        assertEquals(Genre.CANADIAN_HIP_HOP, spotifyRecord.getGenre());
        assertEquals(96, spotifyRecord.getBpm());
        assertEquals(46, spotifyRecord.getEnergy());
        assertEquals(73, spotifyRecord.getDanceability());
        assertEquals(-7, spotifyRecord.getLoudness());
        assertEquals(19, spotifyRecord.getLiveness());
        assertEquals(40, spotifyRecord.getValence());
        assertEquals(213, spotifyRecord.getLength());
        assertEquals(37, spotifyRecord.getAcousticness());
        assertEquals(3, spotifyRecord.getSpeechiness());
        assertEquals(89, spotifyRecord.getPopularity());
    }

    @Test
    public void loadSpotifyRecords() {
        List<SpotifyRecord> spotifyRecordList =
                SpotifyReader.loadSpotifyRecords(Path.of("src/main/resources/top50spotify2019-test.csv"));

        assertEquals(2, spotifyRecordList.size());
    }
}
