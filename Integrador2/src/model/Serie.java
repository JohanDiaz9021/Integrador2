package model;

public class Serie extends Producto {

    private String broadcastDate;
    private String protagonistName;
    private String censorShip;
    private String releaseDate;

    private static final int MAXTEMPORADA = 50;



    //Relation
    private Temporada temp;

    private Temporada[] temps;


    public Serie(String titleName,String directoName, String sinopsis, String trailer,String broadcastDate, String protagonistName, String censorShip, String releaseDate, Temporada temp) {
        super(titleName,directoName, sinopsis, trailer);
        this.broadcastDate = broadcastDate;
        this.protagonistName = protagonistName;
        this.censorShip = censorShip;
        this.releaseDate = releaseDate;
        temps = new Temporada[MAXTEMPORADA];
    }


    /**
    * Descripción: create season</br>
    * @return <message> <String>, shows from shape correct what is create
    */
    public String addTemp(Temporada temporad){

        String message ="";

        for(int i = 0;i < temps.length;i++){
            if(temps[i] == null){

                temps[i] = temporad;
                message = "The season was created";

            }
        }
        return message;
    }
    @Override

    public String ultmTemp(){

        String message = "";

        message += getTitleName()+"\n";



        for(int i = 0; i < temps.length -1;i++){

            if(temps[i] != null){
                if(temps.length >= i+1){
                    if(temps[i+1] == null){
                        message += temps[i+1].toString();

                    }
    
                }
                else{
                    message += temps[i].toString();
                }
            }
        }





        return message;
    }    
    public String toString(){
        String out = "";
        out =       ("Serie \n"
                    +"Titulo: "+getTitleName()+"\n"
                    +" Name Director: "+getDirectoName()+"\n"
                    +" Sinopsis: "+getSinopsis()+"\n"
                    +" Trailer: "+getTrailer()+"\n"
                    +" Rekease date: "+releaseDate+"\n"
                    +" broadcast Date: "+broadcastDate+"\n"
                    +" protagonistName: "+protagonistName+"\n"
                    +" censorShip: " +censorShip+"\n");

                    if(temp != null){
                        out+=temp.toString();
                    }
        return out;
    }
    public String getBroadcastDate() {
        return broadcastDate;
    }
    public String getCensorShip() {
        return censorShip;
    }


    public void setCensorShip(String censorShip) {
        this.censorShip = censorShip;
    }


    public String getProtagonistName() {
        return protagonistName;
    }


    public void setProtagonistName(String protagonistName) {
        this.protagonistName = protagonistName;
    }


    public void setBroadcastDate(String broadcastDate) {
        this.broadcastDate = broadcastDate;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

}
