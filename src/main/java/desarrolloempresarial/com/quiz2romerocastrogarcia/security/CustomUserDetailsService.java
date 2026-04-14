package desarrolloempresarial.com.quiz2romerocastrogarcia.security;

import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Admin;
import desarrolloempresarial.com.quiz2romerocastrogarcia.entity.Chef;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.AdminRepository;
import desarrolloempresarial.com.quiz2romerocastrogarcia.repository.ChefRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final ChefRepository chefRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Admin admin = adminRepository.findByUsername(username).orElse(null);
        if (admin != null) {
            return new CustomUserDetails(
                    admin.getId(),
                    admin.getUsername(),
                    admin.getPassword(),
                    admin.getRole().name()
            );
        }

        Chef chef = chefRepository.findByUsername(username).orElse(null);
        if (chef != null) {
            return new CustomUserDetails(
                    chef.getId(),
                    chef.getUsername(),
                    chef.getPassword(),
                    chef.getRole().name()
            );
        }

        throw new UsernameNotFoundException("User not found with username: " + username);
    }
}