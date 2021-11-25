package model;

/**

 * Esta clase define los variables del suscriptor para poder crearlo 

 * @author: Johan Sebatian Diaz

 * @version: 27/10/2021

 */
public class Suscriptor{

    private String identification;
    private String name;
    private int age;
    private int willingToConsume;

    //Relation

    private TipoCliente rangoCliente;
    private Estado estadoCliente;
    

    /**
	 * 
	 * @param identification1
	 * @param name1
	 * @param age1
	 * @param willingToConsume1
	 * @param rangoClient
	 * @param EstadoClient
	 */

    public Suscriptor(String identification1, String name1, int age1, int willingToConsume1, String rangoClient, String estadoClient) {
        identification = identification1;
        name = name1;
        age = age1;
        willingToConsume = willingToConsume1;
        this.rangoCliente = TipoCliente.valueOf(rangoClient);
        this.estadoCliente = Estado.ACTIVE;
    }

    ///////////// get and set/////////////
    public Estado getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(Estado estadoCliente) {
        this.estadoCliente = estadoCliente;

    }

    ///////////// get and set/////////////
    public TipoCliente getRangoCliente() {
        return rangoCliente;
    }
    public void setRangoCliente(TipoCliente rangoCliente) {
        String tipo = "NORMAL";
        rangoCliente = TipoCliente.valueOf(tipo);
        
    }
    ///////////// get and set/////////////
    public String getIdentification() {
        return identification;
    }
    public void setIdentification(String identificacion1) {
        identification = identificacion1;
    }
    ///////////// get and set/////////////
    public String getName() {
        return name;
    }
    public void setName(String name1) {
        name = name1;
    }
    ///////////// get and set/////////////
    public int getAge() {
        return age;
    }
    public void setAge(int age1) {
        age = age1;
    }
    ///////////// get and set/////////////
    public int getWillingToConsume() {
        return willingToConsume;
    }
    public void setWillingToConsume(int willingToConsume1) {
        willingToConsume = willingToConsume1;
    }
}