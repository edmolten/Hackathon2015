package hackathon2015.hitutor.clases_result;


public class Clase {

    private int userId;
    private int price;
    private float rate;
    private String materia;
    private String userName;
    private String title;
    private String level;

    public Clase(int userId, int price, int rate, String userName,String materia,String title, String level){
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.materia = materia;
        this.price = price ;
        this.rate = rate ;
        this.level = level ;

    }



    public String getuserName() {
        return userName;
    }
    public String getMateria() {
        return materia;
    }
    public String getTitle() {
        return title;
    }
    public String getLvl() {
        return level;
    }
    public int getPrice() {        return price;    }
    public float getRate() {
        return rate;
    }

}
