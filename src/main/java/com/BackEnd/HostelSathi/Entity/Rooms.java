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
public class Rooms {
  @Id
   @GeneratedValue(strategy =GenerationType.IDENTITY )
    private Long id;


   @Column(nullable = false)
   private String Type;

    @ManyToOne
    @JoinColumn(name = "hotel_id",nullable = false)
    private  Hotel hotel;

    @Column(columnDefinition ="TEXT[]")
    private String[] photo;

    @Column(columnDefinition ="TEXT[]")
    private String[] animetiese;

    @Column(nullable = false)
    private Integer TotalCount;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal Bestprice;

    @Column  (nullable = false)
    private Integer Capacity;


    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Embedded
    private ContactInfo contactInfo;

    @Column (nullable = false)
    private Boolean active;


}


