package vngvng.example.demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Height {

    private Float height;
    private Float sitHeight;

    public Height(Float height, Float sitHeight) {
        this.height = height;
        this.sitHeight = sitHeight;
    }
}
