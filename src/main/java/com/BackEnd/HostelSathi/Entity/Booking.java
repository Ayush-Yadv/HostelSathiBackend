package com.BackEnd.HostelSathi.Entity;

import com.BackEnd.HostelSathi.Enum.Booking_status;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "hotel_id",nullable = false)
    private Hotel hotel;


    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "Room_id",nullable = false)
    private Rooms room;

    @ManyToOne(fetch =FetchType.LAZY)
    @JoinColumn(name = "User_id",nullable = false)
    private User user;

   @Column(nullable = false)
    private LocalDateTime checkInDate;

    @Column(nullable = false)
    private LocalDateTime checkOutDate;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentid")
    private Payment payment;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private Booking_status booking_status;
}

