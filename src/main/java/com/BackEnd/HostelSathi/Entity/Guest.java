package com.BackEnd.HostelSathi.Entity;

import com.BackEnd.HostelSathi.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Guest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(fetch =FetchType.LAZY)
    @JoinTable(
            name = "booking_guest",
           joinColumns = @JoinColumn(name = "booking_id"),
           inverseJoinColumns = @JoinColumn(name = "user_id")

    )
    private Set<Guest> guests;
}
