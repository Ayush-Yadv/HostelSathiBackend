package com.BackEnd.HostelSathi.Entity;

import com.BackEnd.HostelSathi.Enum.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "user_name")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    private String Name;

    @Column(nullable = false,unique = true)
    private String Email;

    @Column(nullable = false)
    private String password;

   @ElementCollection(fetch = FetchType.EAGER)
   @Enumerated(EnumType.STRING)
    private Set<Role> role;
}
