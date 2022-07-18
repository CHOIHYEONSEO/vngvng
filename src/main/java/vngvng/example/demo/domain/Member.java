package vngvng.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member {
    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name="member_name")
    private String name;

    private String nickname;
    private Integer age;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "CHAR(1)")
    private Gender gender;

    @Embedded
    private Height height;

    //@Temporal(TemporalType.DATE)
    private LocalDate birthday;

    private Boolean wearGlass;

    @OneToMany(mappedBy = "writer")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Scrap> scrap = new ArrayList<>();
    
    public void addReviews(Review review){
        this.reviews.add(review);
    }

    public void addScrap(Scrap scrap){
        this.scrap.add(scrap);
    }

    
    //필수입력값만 저장 > 나머지는 그냥 set으로
    public Member(String id, String name, String nickname, Integer age, Gender gender, Height height, 
                  LocalDate birthday, Boolean wearGlass) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.birthday = birthday;
        this.wearGlass = wearGlass;
    }

    //builder?
    //회원수정기능이 있으므로 edit컬럼명 기능 추가
    public void editName(String name){
        this.name = name;
    }

    public void editNickname(String nickname){
        this.nickname = nickname;
    }
}
