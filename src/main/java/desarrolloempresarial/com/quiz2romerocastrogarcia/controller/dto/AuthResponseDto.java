package desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponseDto {

    private String token;
    private String username;
    private String role;
}