package desarrolloempresarial.com.quiz2romerocastrogarcia.controller;

import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.service.ChefService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chef")
@RequiredArgsConstructor
public class ChefController {

    private final ChefService chefService;

    @GetMapping("/me")
    public ChefResponseDto getMyInfo(Authentication authentication) {
        return chefService.getMyInfo(authentication.getName());
    }

    @GetMapping("/kitchens")
    public List<KitchenResponseDto> getMyKitchens(Authentication authentication) {
        return chefService.getMyKitchens(authentication.getName());
    }
}