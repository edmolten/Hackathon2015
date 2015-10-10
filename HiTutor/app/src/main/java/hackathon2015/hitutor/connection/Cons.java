package hackathon2015.hitutor.connection;


public abstract class Cons {
    public static final String SERVER_URL = /*"http://10.0.2.2:3000";*/     "http://denuncity.herokuapp.com";
    public static final String SHOW_DENUNS_URL = SERVER_URL + "/api/denuns/show.json";
    public static final String SIGNIN_URL = SERVER_URL + "/api/users/new.json";
    public static final String LOGIN_URL = SERVER_URL + "/api/sesions/create.json";
}
