package model;

public class Temporada{

    private int quantityScheduledEpisodes;
    private int numberOfEpisodesPublished;
    private String premierDate;
    

    public Temporada( int quantityScheduledEpisodes, int numberOfEpisodesPublished, String premierDate) {
        this.quantityScheduledEpisodes = quantityScheduledEpisodes;
        this.numberOfEpisodesPublished = numberOfEpisodesPublished;
        this.premierDate = premierDate;
    }

        /**
    * Descripción: show season</br>
    * @return <out> <String>, shows information season
    */
    public String toString(){
        String out = "";
        out =
                    " Number of scheduled episodes: "+quantityScheduledEpisodes+"\n"
                    +" Number of published episodes: "+numberOfEpisodesPublished+"\n"
                    +" premiere date "+premierDate;

                    out = toString();

        return out;
    }
 
    public String getPremierDate() {
        return premierDate;
    }
    public void setPremierDate(String premierDate) {
        this.premierDate = premierDate;
    }
    public int getNumberOfEpisodesPublished() {
        return numberOfEpisodesPublished;
    }
    public void setNumberOfEpisodesPublished(int numberOfEpisodesPublished) {
        this.numberOfEpisodesPublished = numberOfEpisodesPublished;
    }
    public int getQuantityScheduledEpisodes() {
        return quantityScheduledEpisodes;
    }
    public void setQuantityScheduledEpisodes(int quantityScheduledEpisodes) {
        this.quantityScheduledEpisodes = quantityScheduledEpisodes;
    }
}
