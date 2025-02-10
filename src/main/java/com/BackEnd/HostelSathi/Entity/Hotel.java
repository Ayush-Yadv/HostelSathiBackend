package com.BackEnd.HostelSathi.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.jackson.JsonComponent;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(columnDefinition ="TEXT[]")
    private String[] photo;

    @Column(columnDefinition ="TEXT[]")
    private String[] animetiese;


   @CreationTimestamp
    private LocalDateTime createdAt;

   @UpdateTimestamp
    private LocalDateTime updatedAt;
   
   @Embedded
    private ContactInfo contactInfo;

   private Boolean Active;

   @ManyToOne
    private User owner;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Rooms> rooms;
}
