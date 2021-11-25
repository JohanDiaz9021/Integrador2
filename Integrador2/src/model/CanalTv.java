package model;

/**
 * 
 * Esta clase se encarga de crear un suscriptor, desactivar suscriptor, mostrar
 * suscriptores activos, mostrar suscriptor con mayor consumo en la plataforma
 * 
 * @author: Johan Sebatian Diaz
 * 
 * @version: 27/10/2021
 * 
 */

public class CanalTv {

    private String nit;
    private String direccion;
    private String webSite;
    private static final int MAXSUSCRIPTORES = 50;
    private static final int MAXPRODUCTS = 85;

    // Atributo
    private Suscriptor[] subs;
    private Producto[] prods;
    // Relation
    private Suscriptor personasSuscrip;
    private Serie ser;
    private Movie pel;

    public CanalTv(String nit, String direccion, String webSite, Suscriptor personasSuscrip, Serie ser, Movie pel) {
        this.nit = nit;
        this.direccion = direccion;
        this.webSite = webSite;
        this.personasSuscrip = personasSuscrip;
        this.ser = ser;
        this.pel = pel;
        subs = new Suscriptor[MAXSUSCRIPTORES];
        prods = new Producto[MAXPRODUCTS];
    }

    /**
     * Descripción: Verifica que no se pueda registrar un suscriptor con una
     * identificacion ya registrada</br>
     * 
     * @param <identificacion> <String>, hacer un recorrido y verificar que ningun
     *                         otro usuario tenga
     * @return <message> <String>, retorna si hay un suscriptor con una misma
     *         identificacion
     */
    public boolean verificacionSuscriptores(String identification) {

        for (int i = 0; i < subs.length; i++) {

            if (subs[i] != null) {
                if (subs[i].getIdentification().equals(identification)) { // Identifica si hay un mismo suscriptor con
                                                                          // misma identificacion
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * Descripción: Añade un suscriptor a la plataforma</br>
     * 
     * @param <identification>   <String>, Darle un registro unico por medio de la
     *                           identificacion
     * @param <name>             <String>, Nombre de la persona que esta
     *                           registrandose
     * @param <age>              <int>, Tener el rango de edad de las personas que
     *                           se registran a la plataforma
     * @param <willingToConsume> <int>, Poder saber la cantidad de horas que esta
     *                           dispuesto el suscriptor para estar en la plataforma
     * @param <tipoClient>       <String>, Poder saber que tipo de suscriptor es si
     *                           Normal, Oro, Diamante, Platino.
     * @param <estadoClient>     <String>, Poder informar al usuario si ya hay un
     *                           usuario con la misma identificacion, si se pudo
     *                           registrar o si ha llegado al limite de
     *                           suscripciones
     * @return <message> <String>, informacion sobre variable de retorno --> retorno
     */
    public String addSuscriptores(String identification, String name, int age, int willingToConsume, String tipoClient,
            String estadoClient) {
        boolean rum = true;
        String message = "There is already a user with this same ID";
        Suscriptor suscrip = new Suscriptor(identification, name, age, willingToConsume, tipoClient, estadoClient);

        for (int i = 0; i < subs.length && rum; i++) {

            if (verificacionSuscriptores(identification) == false) {

                if (subs[i] == null) {
                    subs[i] = suscrip;
                    rum = false;
                    message = "The subscriber has registered correctly";
                } else if (subs[i] != null) {
                    message = "We have reached the subscriber limit, sorry";
                }
            }
        }

        return message;
    }

    /**
     * Descripción: Vuelve al suscriptor de manera inactivo</br>
     * 
     * @param <identification> <String>, Poder desactivar al usuario por medio de su
     *                         identifiacion
     * @return <message> <String>, Informar si el usuario se ha desactivado de
     *         manera correcta o si no hay ningun usuario con la cedula ingresada
     */
    public String desactivarSuscriptor(String identification) {

        String message = "";

        for (int i = 0; i < subs.length; i++) {

            if (subs[i] != null) {
                if (subs[i].getIdentification().equals(identification)) {
                    if (subs[i].getEstadoCliente() != Estado.INACTIVE) {
                        subs[i].setEstadoCliente(Estado.INACTIVE);
                        subs[i].setRangoCliente(TipoCliente.NORMAL);
                        subs[i] = null;
                        message = "The subscriber has been successfully deactivated.";
                    }

                } else {
                    message = "There is no subscriber with this active identification number.";
                }
            }
        }
        return message;
    }

    /**
     * Descripción: Muestra los suscriptores registrados activos por medio de su
     * tipo cliente Normal, Platino, Oro, Diamante</br>
     * 
     * @return <message> <String>, Mostrar los usuarios activos por medio de un
     *         acumulador y contatenando en un string
     */
    public String mostrarSuscripAct() {

        String message = "";

        int acumuladorSuscriptorNORMAL = 0;
        int acumuladorSuscriptorPLATINUM = 0;
        int acumuladorSuscriptorGOLD = 0;
        int acumuladorSuscriptorDIAMOND = 0;

        for (int i = 0; i < subs.length; i++) {

            if (subs[i] != null) {
                if (subs[i].getEstadoCliente().equals(Estado.ACTIVE)) {
                    if (subs[i].getRangoCliente().equals(TipoCliente.NORMAL)) {
                        acumuladorSuscriptorNORMAL++;

                    }
                    if (subs[i].getRangoCliente().equals(TipoCliente.PLATINUM)) {
                        acumuladorSuscriptorPLATINUM++;

                    }
                    if (subs[i].getRangoCliente().equals(TipoCliente.GOLD)) {
                        acumuladorSuscriptorGOLD++;

                    }
                    if (subs[i].getRangoCliente().equals(TipoCliente.DIAMOND)) {
                        acumuladorSuscriptorDIAMOND++;

                    }
                }
            }
            message = "The number of active subscribers are: \n" + "NORMAL:" + acumuladorSuscriptorNORMAL + "\n"
                    + "PLATIUM: " + acumuladorSuscriptorPLATINUM + "\n" + "GOLD: " + acumuladorSuscriptorGOLD + "\n"
                    + "DIAMOND: " + acumuladorSuscriptorDIAMOND;
        }
        return message;
    }

    /**
     * Descripción: Muestra el usuario menor de edad con mayor horas a consumir en
     * la plataforma</br>
     * 
     * @param <nombre_par> <tipo>, condiciones sobre el parametro --> si tiene
     * @return <message> <String>, mustra el usuario menor de edad por medio de un
     *         for que recorre identificando al menor de edad con la mayor cantidad
     *         de horas para consumir para retornar su nombre
     */
    public String mostrarSuscripMenorEdad() {

        String message = "";

        int willingToConsume = 0;
        int position = 0;

        for (int i = 0; i < subs.length; i++) {
            if (subs[i] != null) {
                if (subs[i].getAge() < 18) {
                    if (subs[i].getWillingToConsume() > willingToConsume) {
                        willingToConsume = subs[i].getWillingToConsume();
                        position = i;
                    }
                }
            }
            message = "The name of the subscriber who has the highest number of hours willing to consume is: "
                    + subs[position].getName();
        }
        return message;
    }

    //////////////////////////////////////// CODIFICATION FROM CLASS
    //////////////////////////////////////// PRODUCT//////////////////////////////////////////////////////////////
    // Validation
    public boolean verificationProducts(String titleName) {

        for (int i = 0; i < prods.length; i++) {

            if (prods[i] != null) {

                if (prods[i].getTitleName().equalsIgnoreCase(titleName)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Descripción: Register movie from correcty</br>
     * 
     * @param <titleName>   <String>
     * @param <directoName> <String>
     * @param <sinopsis>    <String>
     * @param <trailer>     <String>
     * @param <producer>    <String>
     * @param <minimumAge>  <String>
     * @param <releaseDate> <String>
     * @param <cat>         <Categoria>
     * @return <message> <String>, reports that the movie was created
     */
    public String registerMovie(String titleName, String directoName, String sinopsis, String trailer, String producer,
            String minimumAge, String releaseDate, Categoria cat) {
        String message = "There is already a movie with this same name.";
        boolean rum = true;

        Movie productsMovieRegister = new Movie(titleName, directoName, sinopsis, trailer, producer, minimumAge,
                releaseDate, cat);

        for (int i = 0; i < prods.length && rum; i++) {
            if (verificationProducts(titleName) == false) {
                if (prods[i] == null) {
                    prods[i] = productsMovieRegister;
                    rum = false;
                    message = "The movie has registered correctly.";
                } else if (prods[i] != null) {
                    message = "we have reached the movie limit, sorry.";
                }
            }
        }
        return message;
    }

    /**
     * Descripción: Register Serie from correcty</br>
     * 
     * @param <titleName>                 <String>
     * @param <directoName>               <String>
     * @param <sinopsis>                  <String>
     * @param <trailer>                   <String>
     * @param <broadcastDate>             <String>
     * @param <protagonistName>           <String>
     * @param <censorShip>                <String>
     * @param <releaseDate>               <String>
     * @param <quantityScheduledEpisodes> <int>
     * @param <numberOfEpisodesPublished> <int>
     * @param <premiereDate>              <String>
     * @return <message> <String>, reports that the serie was created
     */
    public String registerSerie(String titleName, String directoName, String sinopsis, String trailer,
            String broadcastDate, String protagonistName, String censorShip, String releaseDate,
            int quantityScheduledEpisodes, int numberOfEpisodesPublished, String premiereDate) {

        String message = "";

        boolean rum = true;

        Serie productsSerieRegister = new Serie(titleName, directoName, sinopsis, trailer, broadcastDate,
                protagonistName, censorShip, releaseDate,
                new Temporada(quantityScheduledEpisodes, numberOfEpisodesPublished, premiereDate));

        for (int i = 0; i < prods.length && rum; i++) {
            if (verificationProducts(titleName) == false) {
                if (prods[i] == null) {
                    prods[i] = productsSerieRegister;
                    rum = false;
                    message = "The serie has registered correctly";
                } else if (prods[i] != null) {
                    message = "We have reached the serie limit, sorry";
                }
            }
        }
        return message;
    }

    /**
     * Descripción: shows information of products created</br>
     * 
     * @param <titleName> <String>
     * @return <message> <String>, shows information
     */
    public String mostrarInformacionCreada(String titleName) {
        String message = "";

        for (int i = 0; i < prods.length; i++) {
            if (prods[i] != null) {
                if (prods[i].getTitleName().equalsIgnoreCase(titleName)) {
                    message = prods[i].toString();
                }
            }
        }
        return message;
    }

    /**
     * Descripción: Register season from correcty</br>
     * 
     * @param <titleName>                 <String>
     * @param <quantityScheduledEpisodes> <int>
     * @param <numberOfEpisodesPublished> <int>
     * @param <premiereDate>              <String>
     */
    public void registerTemp(String titleName, int quantityScheduledEpisodes, int numberOfEpisodesPublished,
            String premiereDate) {

        Temporada temp = new Temporada(quantityScheduledEpisodes, numberOfEpisodesPublished, premiereDate);

        for (int i = 0; i < prods.length; i++) {
            if (prods[i] != null) {
                if (prods[i].getTitleName().equalsIgnoreCase(titleName) && prods[i] instanceof Serie) {

                    ((Serie) prods[i]).addTemp(temp);
                }
            }
        }
    }

    /**
     * Descripción: shows movie by category</br>
     * 
     * @return <message> <String>, shows accumulator and movie genre with its title
     */
    public String mostrarPeliculasCategoria() {

        String message = "";
        String peliculaRomantica = "";
        String peliculaAction = "";
        String peliculaSuspense = "";
        String peliculaTerror = "";
        String peliculaComedy = "";

        int acumuladorCategoriaROMANTIC = 0;
        int acumuladorCategoriaACTION = 0;
        int acumuladorCategoriaSUSPENSE = 0;
        int acumuladorCategoriaTERROR = 0;
        int acumuladorCategoriaCOMEDY = 0;

        for (int i = 0; i < prods.length; i++) {

            if (prods[i] != null) {
                if (prods[i] instanceof Movie) {
                    if (((Movie) prods[i]).getCat().equals(Categoria.ROMANTIC)) {
                        peliculaRomantica += prods[i].getTitleName() + "\n";
                        acumuladorCategoriaROMANTIC++;
                    }
                }
                if (prods[i] instanceof Movie) {
                    if (((Movie) prods[i]).getCat().equals(Categoria.ACTION)) {
                        peliculaAction += prods[i].getTitleName() + "\n";

                        acumuladorCategoriaACTION++;
                    }
                }
                if (prods[i] instanceof Movie) {
                    if (((Movie) prods[i]).getCat().equals(Categoria.SUSPENSE)) {
                        peliculaSuspense += prods[i].getTitleName() + "\n";

                        acumuladorCategoriaSUSPENSE++;
                    }
                }
                if (prods[i] instanceof Movie) {
                    if (((Movie) prods[i]).getCat().equals(Categoria.TERROR)) {
                        peliculaTerror += prods[i].getTitleName() + "\n";

                        acumuladorCategoriaTERROR++;
                    }
                }
                if (prods[i] instanceof Movie) {
                    if (((Movie) prods[i]).getCat().equals(Categoria.COMEDY)) {
                        peliculaComedy += prods[i].getTitleName() + "\n";

                        acumuladorCategoriaCOMEDY++;
                    }
                }

            }
            message = "categories of registered movies: \n" + "amount of movies romantic: "
                    + acumuladorCategoriaROMANTIC + "\n" + "Title: " + "\n" + peliculaRomantica + "\n"
                    + "amount of movies action: " + acumuladorCategoriaACTION + "\n" + "Title: " + "\n" + peliculaAction
                    + "\n" + "amount of movies suspense: " + acumuladorCategoriaSUSPENSE + "\n" + "Title: " + "\n"
                    + peliculaSuspense + "\n" + "amount of movies terror: " + acumuladorCategoriaTERROR + "\n"
                    + "Title: " + "\n" + peliculaTerror + "\n" + "amount of movies comedy: " + acumuladorCategoriaCOMEDY
                    + "\n" + "Title: " + "\n" + peliculaComedy;
        }
        return message;
    }

    /**
     * Descripción: shows serie create</br>
     * 
     * @return <message> <String>, shows title name serie
     */
    public String mostrarSerie() {

        String message = "";

        for (int i = 0; i < prods.length; i++) {

            if (prods[i] != null) {
                if (prods[i] instanceof Serie) {
                    message += "Title of series created: " + "\n";
                    message += prods[i].ultmTemp();
                }
            }
        }
        return message;
    }

    ///////////// get and set/////////////
    public Suscriptor getPersonasSuscrip() {
        return personasSuscrip;
    }

    public void setPersonasSuscrip(Suscriptor personasSuscrip) {
        this.personasSuscrip = personasSuscrip;
    }

    ///////////// get and set/////////////
    public String getNit() {
        return nit;
    }

    public void setNit(String nit1) {
        nit = nit1;
    }

    ///////////// get and set/////////////
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion1) {
        direccion = direccion1;
    }

    ///////////// get and set/////////////
    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite1) {
        webSite = webSite1;
    }

    public Movie getPel() {
        return pel;
    }

    public void setPel(Movie pel) {
        this.pel = pel;
    }

    public Serie getSer() {
        return ser;
    }

    public void setSer(Serie ser) {
        this.ser = ser;
    }
}