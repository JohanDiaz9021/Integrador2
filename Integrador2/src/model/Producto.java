package model;
public abstract class Producto{

    private String titleName;
    private String directoName;
    private String sinopsis;
    private String trailer;

    public Producto(String titleName, String directoName, String sinopsis, String trailer) {
        this.titleName = titleName;
        this.directoName = directoName;
        this.sinopsis = sinopsis;
        this.trailer = trailer;
    }
    
    abstract public String toString();

    public String ultmTemp(){
        String out = "";

        return out;
    }

    public String getTitleName() {
        return titleName;
    }
    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }
    public String getSinopsis() {
        return sinopsis;
    }
    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }
    public String getDirectoName() {
        return directoName;
    }
    public void setDirectoName(String directoName) {
        this.directoName = directoName;
    }
    public String getTrailer() {
        return trailer;
    }
    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }
}

