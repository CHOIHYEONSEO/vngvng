package vngvng.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
public class Artist {
    @Id @GeneratedValue
    @Column(name="artist_id")
    private Long id;

    @Column(name="artist_name")
    private String name;

    @OneToMany(mappedBy = "artist")
    private List<Review> reviews = new ArrayList<>();

    public Artist(String name) {
        this.name = name;
    }

    public void addReviews(Review review){
        this.reviews.add(review);
    }
}
