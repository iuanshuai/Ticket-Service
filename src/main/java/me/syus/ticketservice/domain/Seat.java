package me.syus.ticketservice.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
