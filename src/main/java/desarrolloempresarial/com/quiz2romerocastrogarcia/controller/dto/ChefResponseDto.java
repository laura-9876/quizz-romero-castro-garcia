package desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ChefResponseDto {

    private Long id;
    private String name;
    private String username;
    private String role;
}