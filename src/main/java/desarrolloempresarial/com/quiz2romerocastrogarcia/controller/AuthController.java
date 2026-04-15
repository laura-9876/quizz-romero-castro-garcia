package desarrolloempresarial.com.quiz2romerocastrogarcia.controller;


import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.AuthResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.LoginRequestDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public AuthResponseDto login(@Valid @RequestBody LoginRequestDto request) {
        return authService.login(request);
    }
}