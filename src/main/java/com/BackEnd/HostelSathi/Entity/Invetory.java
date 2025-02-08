package com.BackEnd.HostelSathi.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(
      uniqueConstraints = @UniqueConstraint(
                name = "unique_hotel_room_date",
              columnNames = {"hotel_id","room_id","date"}
        )



)
public class Invetory {

       @Id
       @GeneratedValue(strategy=GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch =FetchType.LAZY)
        @JoinColumn(name = "hotel_id",nullable = false)
        private Hotel hotel;


       @ManyToOne(fetch =FetchType.LAZY)
       @JoinColumn(name = "Room_id",nullable = false)
        private Rooms room;

        @Column(nullable = false)
        private LocalDateTime date;

        @Column(nullable = false)
        private Integer bookedcount;


        @Column(nullable = false)
        private  Integer totalcount;


        @Column(precision = 5, scale = 2, nullable = false)
        private BigDecimal surgeFactor;

        @Column(precision = 10, scale = 2, nullable = false)
        private BigDecimal price;
        @CreationTimestamp
        private LocalDateTime createdAt;

        @UpdateTimestamp
        private LocalDateTime updatedAt;

        @Column(nullable = false)
        private  String city;
}
