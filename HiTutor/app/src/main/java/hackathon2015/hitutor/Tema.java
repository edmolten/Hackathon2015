package hackathon2015.hitutor;

public class Tema {
    public int id;
    public String name;

    public Tema(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.valueOf(id) + " " + name;
    }
}
