package desarrolloempresarial.com.quiz2romerocastrogarcia.service.impl;


import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.AuthResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.LoginRequestDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.security.CustomUserDetails;
import desarrolloempresarial.com.quiz2romerocastrogarcia.security.JwtService;
import desarrolloempresarial.com.quiz2romerocastrogarcia.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public AuthResponseDto login(LoginRequestDto request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);

        return new AuthResponseDto(
                token,
                userDetails.getUsername(),
                userDetails.getRole()
        );
    }
}