package desarrolloempresarial.com.quiz2romerocastrogarcia.config;

import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Admin;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Chef;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Kitchen;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Role;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.AdminRepository;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.ChefRepository;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.KitchenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final AdminRepository adminRepository;
    private final ChefRepository chefRepository;
    private final KitchenRepository kitchenRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {

        if (adminRepository.findByUsername("admin").isEmpty()) {
            Admin admin = Admin.builder()
                    .name("Main Admin")
                    .username("admin")
                    .password(passwordEncoder.encode("admin123"))
                    .role(Role.ADMIN)
                    .build();

            adminRepository.save(admin);
        }

        Chef savedChef;
        if (chefRepository.findByUsername("chef").isEmpty()) {
            Chef chef = Chef.builder()
                    .name("Main Chef")
                    .username("chef")
                    .password(passwordEncoder.encode("chef123"))
                    .role(Role.CHEF)
                    .build();

            savedChef = chefRepository.save(chef);
        } else {
            savedChef = chefRepository.findByUsername("chef").orElseThrow();
        }

        if (kitchenRepository.findByChef(savedChef).isEmpty()) {
            Kitchen kitchen = Kitchen.builder()
                    .name("Central Kitchen")
                    .location("First Floor")
                    .chef(savedChef)
                    .build();

            kitchenRepository.save(kitchen);
        }
    }
}