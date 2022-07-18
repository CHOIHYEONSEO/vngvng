package vngvng.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Show {
    @Id @GeneratedValue
    @Column(name = "show_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id")
    private Venue venue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Embedded
    private DateInfo dateInfo;
    //@Temporal(TemporalType.TIME)
    private LocalDateTime timeInfo;

    @OneToMany(mappedBy = "show")
    private List<Review> reviews = new ArrayList<>();

    public Show(Venue venue, Artist artist, DateInfo dateInfo, LocalDateTime timeInfo) {
        this.venue = venue;
        this.artist = artist;
        this.dateInfo = dateInfo;
        this.timeInfo = timeInfo;
    }

    public void addReviews(Review review){
        this.reviews.add(review);
    }
}
