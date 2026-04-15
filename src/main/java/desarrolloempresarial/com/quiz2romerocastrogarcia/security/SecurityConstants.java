package desarrolloempresarial.com.quiz2romerocastrogarcia.security;
public class SecurityConstants {

    private SecurityConstants() {
    }

    public static final String SECRET_KEY = "quiz2romerocastrogarcia_secret_key_for_jwt_2026";
    public static final long EXPIRATION_TIME = 1000 * 60 * 60 * 24; // 24 horas
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_AUTHORIZATION = "Authorization";
}