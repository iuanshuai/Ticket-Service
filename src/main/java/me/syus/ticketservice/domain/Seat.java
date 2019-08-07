package me.syus.ticketservice.domain;

import javax.persistence.*;
import java.math.BigDecimal;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator="seats_id_seq")
    @SequenceGenerator(name="seats_id_seq", sequenceName="seats_id_seq", allocationSize = 1)
    private Long id;

    @Column
    private BigDecimal price;

    @Column(name = "availability")
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailability(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
