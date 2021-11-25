package model;

public class Movie extends Producto{
    private String producer;
    private String minimumAge;
    private String releaseDate;


    //Relation
    private Categoria cat;

    public Movie(String titleName,String directoName, String sinopsis, String trailer,String producer, String minimumAge, String releaseDate, Categoria cat) {
        super(titleName,directoName, sinopsis, trailer);
        this.producer = producer;
        this.minimumAge = minimumAge;
        this.releaseDate = releaseDate;
        this.cat = cat;
    }

        /**
    * Descripción: show movie</br>
    * @return <out> <String>, shows information from movie
    */
    public String toString(){
        String out = "";
        out = ("Movie "+
        "Titulo: "+getTitleName()+"\n"
        +" Name Director: "+getDirectoName()+"\n"
        +" Sinopsis: "+getSinopsis()+"\n"
        +" Trailer: "+getTrailer()+"\n"
        +" Producer: "+producer+"\n"
        +" Minimum age: "+minimumAge+"\n"
        +" Release date: " +releaseDate+"\n"
        +" Category: "+cat+"\n");
        return out;
    }
    public Categoria getCat() {
        return cat;
    }
    public void setCat(Categoria cat) {
        this.cat = cat;
    }
    public String getMinimumAge() {
        return minimumAge;
    }
    public void setMinimumAge(String minimumAge) {
        this.minimumAge = minimumAge;
    }
    public String getProducer() {
        return producer;
    }
    public void setProducer(String producer) {
        this.producer = producer;
    }
    public String getDateStren() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    
}
