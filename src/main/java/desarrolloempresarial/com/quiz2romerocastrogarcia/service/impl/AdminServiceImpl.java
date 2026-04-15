package desarrolloempresarial.com.quiz2romerocastrogarcia.service.impl;


import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefRequestDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenRequestDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Chef;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Kitchen;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Role;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.ChefRepository;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.KitchenRepository;
import desarrolloempresarial.com.quiz2romerocastrogarcia.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ChefRepository chefRepository;
    private final KitchenRepository kitchenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public ChefResponseDto createChef(ChefRequestDto request) {
        Chef chef = Chef.builder()
                .name(request.getName())
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.CHEF)
                .build();

        return mapChefToResponse(chefRepository.save(chef));
    }

    @Override
    public List<ChefResponseDto> getAllChefs() {
        return chefRepository.findAll()
                .stream()
                .map(this::mapChefToResponse)
                .toList();
    }

    @Override
    public ChefResponseDto getChefById(Long id) {
        Chef chef = chefRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        return mapChefToResponse(chef);
    }

    @Override
    public ChefResponseDto updateChef(Long id, ChefRequestDto request) {
        Chef chef = chefRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        chef.setName(request.getName());
        chef.setUsername(request.getUsername());
        chef.setPassword(passwordEncoder.encode(request.getPassword()));

        return mapChefToResponse(chefRepository.save(chef));
    }

    @Override
    public void deleteChef(Long id) {
        Chef chef = chefRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        chefRepository.delete(chef);
    }

    @Override
    public KitchenResponseDto createKitchen(KitchenRequestDto request) {
        Chef chef = chefRepository.findById(request.getChefId())
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        Kitchen kitchen = Kitchen.builder()
                .name(request.getName())
                .location(request.getLocation())
                .chef(chef)
                .build();

        return mapKitchenToResponse(kitchenRepository.save(kitchen));
    }

    @Override
    public List<KitchenResponseDto> getAllKitchens() {
        return kitchenRepository.findAll()
                .stream()
                .map(this::mapKitchenToResponse)
                .toList();
    }

    @Override
    public KitchenResponseDto getKitchenById(Long id) {
        Kitchen kitchen = kitchenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitchen not found"));

        return mapKitchenToResponse(kitchen);
    }

    @Override
    public KitchenResponseDto updateKitchen(Long id, KitchenRequestDto request) {
        Kitchen kitchen = kitchenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitchen not found"));

        Chef chef = chefRepository.findById(request.getChefId())
                .orElseThrow(() -> new RuntimeException("Chef not found"));

        kitchen.setName(request.getName());
        kitchen.setLocation(request.getLocation());
        kitchen.setChef(chef);

        return mapKitchenToResponse(kitchenRepository.save(kitchen));
    }

    @Override
    public void deleteKitchen(Long id) {
        Kitchen kitchen = kitchenRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Kitchen not found"));

        kitchenRepository.delete(kitchen);
    }

    private ChefResponseDto mapChefToResponse(Chef chef) {
        return ChefResponseDto.builder()
                .id(chef.getId())
                .name(chef.getName())
                .username(chef.getUsername())
                .role(chef.getRole().name())
                .build();
    }

    private KitchenResponseDto mapKitchenToResponse(Kitchen kitchen) {
        return KitchenResponseDto.builder()
                .id(kitchen.getId())
                .name(kitchen.getName())
                .location(kitchen.getLocation())
                .chefId(kitchen.getChef().getId())
                .build();
    }
}