package hackathon2015.hitutor.clases_result;


public class Clase {

    public final int temaId;
    public final boolean isADomicilio;
    public final boolean isDesignadoPorUsuario;
    public final String descripcion;
    public final String disponibilidad;
    public final String nivel;
    public final boolean activa;
    public final float lat;
    public final float lon;
    public final String contacto;
    public int userId;
    public float rate;
    public int price;
    public String userName;
    public String title;

    public Clase(int userId, int temaId, boolean isADomicilio,
                 boolean isDesignadoPorTutor, String descripcion,String disponibilidad,
                 int price, String userName,String title,
                 String nivel, boolean activa, float lat, float lon, String contacto, float rate){
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.price = price ;
        this.temaId = temaId;
        this.isADomicilio = isADomicilio;
        this.isDesignadoPorUsuario = isDesignadoPorTutor;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.nivel = nivel;
        this.rate = rate;
        this.activa = activa;
        this.lat = lat;
        this.lon = lon;
        this.contacto = contacto;

    }
}
