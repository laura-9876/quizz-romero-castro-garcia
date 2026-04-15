package desarrolloempresarial.com.quiz2romerocastrogarcia.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class KitchenResponseDto {

    private Long id;
    private String name;
    private String location;
    private Long chefId;
}