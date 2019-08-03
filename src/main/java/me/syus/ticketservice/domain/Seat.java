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

    @Column
    private boolean availability;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
}
