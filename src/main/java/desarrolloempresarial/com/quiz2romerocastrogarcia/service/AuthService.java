package desarrolloempresarial.com.quiz2romerocastrogarcia.service;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.AuthResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.LoginRequestDto;

public interface AuthService {
    AuthResponseDto login(LoginRequestDto request);
}