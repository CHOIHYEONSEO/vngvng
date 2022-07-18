package vngvng.example.demo.domain;

import lombok.Getter;
import net.bytebuddy.asm.Advice;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.time.LocalDate;
import java.util.Date;

@Embeddable
@Getter
public class DateInfo {
    //@Temporal(TemporalType.DATE)
    private LocalDate startDate;

    //@Temporal(TemporalType.DATE)
    private LocalDate endDate;

    protected DateInfo(){
    }

    public DateInfo(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
