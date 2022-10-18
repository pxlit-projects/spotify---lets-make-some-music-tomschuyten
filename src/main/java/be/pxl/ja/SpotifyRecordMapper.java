package be.pxl.ja;

public class SpotifyRecordMapper {

    public static SpotifyRecord mapToSpotifyRecord(String record) throws Exception {

        // id;track.name;artist.name;genre;bpm;energy;danceability;
        // loudness;liveness;valence;length;acousticness;speechiness;popularity
        String[] splitRecord = record.split(";");
        SpotifyRecord spotifyRecord = new SpotifyRecord();

        spotifyRecord.setId(Integer.valueOf(splitRecord[0]));
        spotifyRecord.setTrackName(splitRecord[1]);
        spotifyRecord.setArtistName(splitRecord[2]);
        spotifyRecord.setGenre(Genre.valueOf(splitRecord[3]
                .replace(" ", "_").toUpperCase()));
        spotifyRecord.setBpm(Integer.valueOf(splitRecord[4]));
        spotifyRecord.setEnergy(Integer.valueOf(splitRecord[5]));
        spotifyRecord.setDanceability(Integer.valueOf(splitRecord[6]));
        spotifyRecord.setLoudness(Integer.valueOf(splitRecord[7]));
        spotifyRecord.setLiveness(Integer.valueOf(splitRecord[8]));
        spotifyRecord.setValence(Integer.valueOf(splitRecord[9]));
        spotifyRecord.setLength(Integer.valueOf(splitRecord[10]));
        spotifyRecord.setAcousticness(Integer.valueOf(splitRecord[11]));
        spotifyRecord.setSpeechiness(Integer.valueOf(splitRecord[12]));
        spotifyRecord.setPopularity(Integer.valueOf(splitRecord[13]));

        return spotifyRecord;
    }

    public static void main(String[] args) {
        System.out.println(Genre.valueOf("canadian hip hop"
                .replace(" ", "_").toUpperCase()));
    }
}
