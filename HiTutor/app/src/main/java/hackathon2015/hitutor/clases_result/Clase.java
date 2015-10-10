package hackathon2015.hitutor.clases_result;


public class Clase {

    private int userId;
    private int price;
    private int rate;
    private String materia;
    private String userName;
    private String title;

    public Clase(int userId, int price, int rate, String userName,String materia,String title){
        this.userId = userId;
        this.userName = userName;
        this.title = title;
        this.materia = materia;
        this.price = price ;
        this.rate = rate ;

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
    public int getPrice() {
        return price;
    } public int getRate() {
        return rate;
    }
}
