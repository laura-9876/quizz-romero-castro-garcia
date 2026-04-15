package desarrolloempresarial.com.quiz2romerocastrogarcia.service.impl;


import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Chef;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Kitchen;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.ChefRepository;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.KitchenRepository;
import desarrolloempresarial.com.quiz2romerocastrogarcia.service.ChefService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ChefServiceImpl implements ChefService {

    private final ChefRepository chefRepository;
    private final KitchenRepository kitchenRepository;

    @Override
    public ChefResponseDto getMyInfo(String username) {
        Chef chef = chefRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        return ChefResponseDto.builder()
                .id(chef.getId())
                .name(chef.getName())
                .username(chef.getUsername())
                .role(chef.getRole().name())
                .build();
    }

    @Override
    public List<KitchenResponseDto> getMyKitchens(String username) {
        Chef chef = chefRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        List<Kitchen> kitchens = kitchenRepository.findByChef(chef);

        return kitchens.stream()
                .map(kitchen -> KitchenResponseDto.builder()
                        .id(kitchen.getId())
                        .name(kitchen.getName())
                        .location(kitchen.getLocation())
                        .chefId(kitchen.getChef().getId())
                        .build())
                .toList();
    }
}