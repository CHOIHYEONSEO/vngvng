package vngvng.example.demo.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Seat {
    private int floor;
    private String seat;

    protected Seat(){

    }

    public Seat(int floor, String seat) {
        this.floor = floor;
        this.seat = seat;
    }
}
