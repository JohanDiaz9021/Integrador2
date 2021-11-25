package ui;
import model.CanalTv;
import model.Categoria;

import java.util.Scanner;
/**

 * Esta clase muestra en pantalla al usuario 

 * @author: Johan Sebatian Diaz

 * @version: 27/10/2021

 */
public class Main{

    public static CanalTv tv;

    public static Scanner must = new Scanner(System.in);

    public static void main(String[] args){

        // TODO Auto-generated method stub


        Main m = new Main();
		tv = new CanalTv(null, null, null, null, null, null);
		m.menu();
    }
    /**
    * Descripción: show menu</br>
    */
    public void menu(){

        boolean rum = true;

        while(rum){

            System.out.println("\nWelcome to the best tv channel BlackSnail \n"+
            "\nChannel information: \n"+
            "Nit: A00371864. \n"+
            "Direction: icesi University. \n"+
            "WebSite: www.JohanSebastianDiaz.com \n");
            System.out.println("\n Choose the option you want to make \n");
            System.out.println("1. Sign up to BlackSnail.");
            System.out.println("2. Deactivate a subscriber.");
            System.out.println("3. Show the number of active subscribers.");
            System.out.println("4. Show the youngest subscriber with the highest number of hours willing to consume.");
            System.out.println("5. Do you want to register a movie or series?");
            System.out.println("6. Show registered products.");
            System.out.println("7. Create a season for a series.");
            System.out.println("8. Show movie by category");
            System.out.println("9. Show created series");
            System.out.println("10. End the program.");
            int seleccion = must.nextInt();
            switch(seleccion){

            case 1:
            addSuscrip();
            break;
                
            case 2:
            desactivSuscrip();
            break;

            case 3:
            mostrarSuscrpAct();
            break;

            case 4:
            mostrarSuscrpMenorEdad();
            break;

            case 5:
            menu1();
            break;

            case 6:
            mostrarProductosRegistrados();
            break;

            case 7:
            createTempor();
            break;
            
            case 8:
            mostrarCate();
            break;

            case 9:
            mostSerie();
            break;

            case 10:
            rum = false;
            System.out.println("See you later, come back soon.");
            break;

            default:
            System.out.println("This option does not exist.");
            }
        }
    }
    /**
    * Descripción: show user to create suscrip</br>
    */
    public void addSuscrip(){

        must.nextLine();
        System.out.println("Please enter your identification number: ");
        String identification = must.nextLine();

        System.out.println("Please enter your full name: ");
        String name = must.nextLine();

        System.out.println("Enter your age please: ");
        int age = must.nextInt();

        System.out.println("Enter the number of hours you are willing to consume please: ");
        int willingToConsume = must.nextInt();

        boolean rum = true;
        String tipoCliente = "";

        while(rum){
            System.out.println("\n\n Enter what type of client is please: \n"+ 
            "1. NORMAL\n" +
            "2. PLATINUM\n" +
            "3. GOLD\n" +
            "4. DIAMOND\n" 
            );
            int seleccion = must.nextInt();

            switch(seleccion){
                case 1:
                tipoCliente = "NORMAL";
                rum = false;
                break;

                case 2:
                tipoCliente = "PLATINUM";
                rum = false;
                break;

                case 3:
                tipoCliente = "GOLD";
                rum = false;
                break;

                case 4:
                tipoCliente = "DIAMOND";
                rum = false;
                break;

                default:
                System.out.println("This option does not exist.");
            }
        }
        //No se debe mostrar en pantalla
        boolean rum1 = false;
        String estado = "";
        while(rum1){

            int seleccion1 = must.nextInt();
            switch(seleccion1){

                case 1:
                estado = "ACTIVO";
                rum1 = true;
                break;

                case 2:
                estado = "INACTIVO";
                rum1 = true;
                break;

                default:
                System.out.println("Esta opcion no existe.");
            }
        }
        String message = tv.addSuscriptores(identification, name, age, willingToConsume, tipoCliente, estado);
        System.out.println(message);
    }
    /**
    * Descripción: show user to diable suscrip</br>
    */
    public void desactivSuscrip(){

        must.nextLine();
        System.out.println("Enter the identification number of the subscriber you want to deactivate: ");
        String identification = must.nextLine();



        String message = tv.desactivarSuscriptor(identification);
        System.out.println(message);


    }
    /**
    * Descripción: show suscrip online</br>
    */
    public void mostrarSuscrpAct(){


        String message = tv.mostrarSuscripAct();
        System.out.println(message);

    }
    /**
    * Descripción: show suscrip less age</br>
    */
    public void mostrarSuscrpMenorEdad(){

        String message = tv.mostrarSuscripMenorEdad();
        System.out.println(message);


        
    }
    /**
    * Descripción: show menu</br>
    */
    public void menu1(){
        boolean rum = true;

        while(rum){
            System.out.println("\n Choose the option you want to make \n");
            System.out.println("1. Register a movie.");
            System.out.println("2. Register a series.");
            System.out.println("3. Back to Main Menu.");
            int seleccion = must.nextInt();
            switch(seleccion){

            case 1:
            registerMovie();
            break;
                
            case 2:
            registerSerie();
            break;

            case 3:
            rum = false;
            menu();
            break;

            default:
            System.out.println("This option does not exist.");
            }
        }

    }
    /**
    * Descripción: show user to register movie</br>
    */
    public void registerMovie(){

        must.nextLine();
        System.out.println("Enter the name of the movie: ");
        String titleName = must.nextLine();

        System.out.println("Enter the release date of the movie as follows (mm / dd / aaaa): ");
        String releaseDate = must.nextLine();

        System.out.println("Enter the name of the director: ");
        String directoName = must.nextLine();

        System.out.println("Enter the name of the producer: ");
        String producer = must.nextLine();

        System.out.println("Enter the synopsis of the movie please: ");
        String sinopsis = must.nextLine();

        System.out.println("Enter the minimum recommended age to watch the movie: ");
        String minimumAge = must.nextLine();

        System.out.println("Enter the movie trailer: ");
        String trailer = must.nextLine();

        boolean rum = true;
        Categoria categoriaPeli = null;

        while(rum){
            System.out.println("\n\n Enter what type of client is please: \n"+ 
            "1. ROMANTICA\n" +
            "2. ACCION\n" +
            "3. SUSPENSO\n" +
            "4. TERROR\n" +
            "5. COMEDIA \n" 
            );
            int seleccion = must.nextInt();

            switch(seleccion){
                case 1:
                categoriaPeli = Categoria.ROMANTIC;
                rum = false;
                break;

                case 2:
                categoriaPeli = Categoria.ACTION;
                rum = false;
                break;

                case 3:
                categoriaPeli = Categoria.SUSPENSE;
                rum = false;
                break;

                case 4:
                categoriaPeli = Categoria.TERROR;
                rum = false;
                break;

                case 5:
                categoriaPeli = Categoria.COMEDY;
                rum = false;
                break;

                default:
                System.out.println("This option does not exist.");
            }
        }
        String message = tv.registerMovie(titleName, directoName, sinopsis, trailer, producer, minimumAge, releaseDate, categoriaPeli);
        System.out.println(message);
    }
                /**
    * Descripción: show user to serie movie</br>
    */
    public void registerSerie(){

        must.nextLine();
        System.out.println("Enter the series title: ");
        String titleName = must.nextLine();

        System.out.println("Enter the date of the first transmission in the series as follows (mm / dd / aaaa): ");
        String broadcastDate = must.nextLine();

        System.out.println("Enter the names of the programmers: ");
        String protagonistName = must.nextLine();

        System.out.println("Enter the name of the series director: ");
        String directoName = must.nextLine();

        System.out.println("Enter series synopsis: ");
        String sinopsis = must.nextLine();

        System.out.println("In case the series is censored enter the reason, otherwise say (It is not censored)");
        String censorShip = must.nextLine();

        System.out.println("Enter the series premiere date as follows (mm / dd / aaaa): ");
        String releaseDate = must.nextLine();

        System.out.println("Enter the trailer for the series please: ");
        String trailer = must.nextLine();

        System.out.println("Number of scheduled episodes: ");
        int quantityScheduledEpisodes = must.nextInt();

        System.out.println("Number of published episodes: ");
        int numberOfEpisodesPublished = must.nextInt();

        System.out.println("Enter the series season premiere date as follows (mm / dd / aaaa): ");
        String premiereDate = must.nextLine();
        must.nextLine();

        String message = tv.registerSerie(titleName, directoName, sinopsis, trailer, broadcastDate, protagonistName, censorShip, releaseDate, quantityScheduledEpisodes, numberOfEpisodesPublished, premiereDate);
        System.out.println(message);


    }
    /**
    * Descripción: show products register</br>
    */
    public void mostrarProductosRegistrados(){

        must.nextLine();
        System.out.println("Enter the name of the product you want: ");
        String titleName = must.nextLine();

        String message = tv.mostrarInformacionCreada(titleName);
        System.out.println(message);

    }
    /**
    * Descripción: show season create</br>
    */
    public void createTempor(){

        must.nextLine();
        System.out.println("Enter the series title: ");
        String titleName = must.nextLine();

        System.out.println("Number of scheduled episodes: ");
        int quantityScheduledEpisodes = must.nextInt();

        System.out.println("Number of published episodes: ");
        int numberOfEpisodesPublished = must.nextInt();

        must.nextLine();
        System.out.println("Enter the series season premiere date as follows (mm / dd / aaaa): ");
        String premiereDate = must.nextLine();

        tv.registerTemp(titleName,quantityScheduledEpisodes, numberOfEpisodesPublished, premiereDate);
        
    }
    /**
    * Descripción: show movie register by category</br>
    */
    public void mostrarCate(){

        String message = tv.mostrarPeliculasCategoria();
        System.out.println(message);
    }
    /**
    * Descripción: show user to register serie</br>
    */
    public void mostSerie(){



        String message = tv.mostrarSerie();
        System.out.println(message);
        
    }
}