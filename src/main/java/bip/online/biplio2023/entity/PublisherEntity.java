package bip.online.biplio2023.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "publishers")
public class PublisherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @ManyToOne
    @JoinColumn (name = "city_id")
    private  CityEntity city;
    @JsonIgnore
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<BookEntity> books;


}
