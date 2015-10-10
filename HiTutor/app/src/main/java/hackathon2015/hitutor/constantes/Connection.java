package hackathon2015.hitutor.constantes;


public abstract class Connection {
    public static final String SERVER_URL = /*"http://10.0.2.2:3000";*/ "http://hitutor.herokuapp.com";
    public static final String SIGNUP_URL = SERVER_URL + "/api/user/new.json";
    public static final String LOGIN_URL = SERVER_URL + "/api/session/create.json";
    public static final String POST_CLASE_URL = SERVER_URL + "/api/clase/new.json";
    public static final String GET_TEMAS_URL = SERVER_URL + "/api/tema/get.json";
    public static final String GET_CLASES_URL = SERVER_URL + "/api/clase/get.json";
    public static final String GET_USERS_URL = SERVER_URL + "/api/user/get.json";
}
