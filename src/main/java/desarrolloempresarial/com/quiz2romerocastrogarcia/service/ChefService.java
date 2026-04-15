package desarrolloempresarial.com.quiz2romerocastrogarcia.service;

import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenResponseDto;

import java.util.List;

public interface ChefService {

    ChefResponseDto getMyInfo(String username);

    List<KitchenResponseDto> getMyKitchens(String username);
}