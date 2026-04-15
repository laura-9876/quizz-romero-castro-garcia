package desarrolloempresarial.com.quiz2romerocastrogarcia.service;


import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefRequestDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenRequestDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenResponseDto;

import java.util.List;

public interface AdminService {

    ChefResponseDto createChef(ChefRequestDto request);

    List<ChefResponseDto> getAllChefs();

    ChefResponseDto getChefById(Long id);

    ChefResponseDto updateChef(Long id, ChefRequestDto request);

    void deleteChef(Long id);

    KitchenResponseDto createKitchen(KitchenRequestDto request);

    List<KitchenResponseDto> getAllKitchens();

    KitchenResponseDto getKitchenById(Long id);

    KitchenResponseDto updateKitchen(Long id, KitchenRequestDto request);

    void deleteKitchen(Long id);
}