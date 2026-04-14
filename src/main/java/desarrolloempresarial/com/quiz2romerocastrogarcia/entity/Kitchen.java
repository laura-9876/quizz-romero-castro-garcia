package desarrolloempresarial.com.quiz2romerocastrogarcia.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "kitchens")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Kitchen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "chef_id", nullable = false)
    private Chef chef;
}