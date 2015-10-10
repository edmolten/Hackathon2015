package hackathon2015.hitutor;


public class User {
    public final String about;
    public int id;
    public String name;
    public float valoracion;

    public User(int id, String name, float valoracion, String about) {
        this.id = id;
        this.name = name;
        this.valoracion = valoracion;
        this.about = about;
    }
}
