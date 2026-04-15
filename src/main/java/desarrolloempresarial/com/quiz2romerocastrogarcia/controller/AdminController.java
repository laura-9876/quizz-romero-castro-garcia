package desarrolloempresarial.com.quiz2romerocastrogarcia.controller;

import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefRequestDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.ChefResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenRequestDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto.KitchenResponseDto;
import desarrolloempresarial.com.quiz2romerocastrogarcia.service.AdminService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @PostMapping("/chefs")
    public ChefResponseDto createChef(@Valid @RequestBody ChefRequestDto request) {
        return adminService.createChef(request);
    }

    @GetMapping("/chefs")
    public List<ChefResponseDto> getAllChefs() {
        return adminService.getAllChefs();
    }

    @GetMapping("/chefs/{id}")
    public ChefResponseDto getChefById(@PathVariable Long id) {
        return adminService.getChefById(id);
    }

    @PutMapping("/chefs/{id}")
    public ChefResponseDto updateChef(@PathVariable Long id,
                                      @Valid @RequestBody ChefRequestDto request) {
        return adminService.updateChef(id, request);
    }

    @DeleteMapping("/chefs/{id}")
    public String deleteChef(@PathVariable Long id) {
        adminService.deleteChef(id);
        return "Chef deleted successfully";
    }

    @PostMapping("/kitchens")
    public KitchenResponseDto createKitchen(@Valid @RequestBody KitchenRequestDto request) {
        return adminService.createKitchen(request);
    }

    @GetMapping("/kitchens")
    public List<KitchenResponseDto> getAllKitchens() {
        return adminService.getAllKitchens();
    }

    @GetMapping("/kitchens/{id}")
    public KitchenResponseDto getKitchenById(@PathVariable Long id) {
        return adminService.getKitchenById(id);
    }

    @PutMapping("/kitchens/{id}")
    public KitchenResponseDto updateKitchen(@PathVariable Long id,
                                            @Valid @RequestBody KitchenRequestDto request) {
        return adminService.updateKitchen(id, request);
    }

    @DeleteMapping("/kitchens/{id}")
    public String deleteKitchen(@PathVariable Long id) {
        adminService.deleteKitchen(id);
        return "Kitchen deleted successfully";
    }
}