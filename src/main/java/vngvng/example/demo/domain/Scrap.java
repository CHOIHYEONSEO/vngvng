package vngvng.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Scrap {

    @Id @GeneratedValue
    @Column(name = "scrap_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name="review_id")
    private Review review;

    //@Temporal(TemporalType.DATE)
    private LocalDate scrapDate;

    public Scrap(Member member, Review review, LocalDate scrapDate) {
        this.member = member;
        this.review = review;
        this.scrapDate = scrapDate;
        member.addScrap(this);
    }
}
