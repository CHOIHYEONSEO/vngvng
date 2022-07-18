package vngvng.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Venue {

    @Id @GeneratedValue
    @Column(name = "venue_id")
    private Long id;

    @Column(name = "venue_name")
    private String name;

    private String hallName;

    @OneToMany(mappedBy = "venue")
    private List<Review> reviews = new ArrayList<>();

    public Venue(String name, String hallName, Long totalSeat, Long totalFloor) {
        this.name = name;
        this.hallName = hallName;
        this.totalSeat = totalSeat;
        this.totalFloor = totalFloor;
    }

    public void addReviews(Review review){
        this.reviews.add(review);
    }

    private Long totalSeat;
    private Long totalFloor;
}
