package com.BackEnd.HostelSathi.Entity;


import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class ContactInfo {
    private String adress;
    private String Location;
    private String phone_number;
    private String email;
}
