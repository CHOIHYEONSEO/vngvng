package vngvng.example.demo.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Review {
    @Column(name="review_id")
    @Id @GeneratedValue
    private Long id;

    //@Temporal(TemporalType.TIME)
    private LocalDateTime writeTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member writer;

    @Embedded
    private Seat seat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "show_id")
    private Show show;

    private Float evaluation;

    //a.png;b.png;c.png
    private String pictures;

    ///////////중복 vs join 2번///////////
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="venue_id")
    private Venue venue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="artist_id")
    private Artist artist;


    /////연관관계 편의 매서드//////
    public Review(LocalDateTime writeTime, Member writer, Seat seat, Show show, Float evaluation,
                  Venue venue, Artist artist) {
        this.writeTime = writeTime;
        this.writer = writer;
        this.seat = seat;
        this.show = show;
        this.evaluation = evaluation;
        this.venue = venue;
        this.artist = artist;
        artist.addReviews(this);
        venue.addReviews(this);
        show.addReviews(this);
        writer.addReviews(this);
    }

    //void addPictures(List<String> pictures){}
}
