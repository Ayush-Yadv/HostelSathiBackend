package com.BackEnd.HostelSathi.Entity;


import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable

public class ContactInfo {
    private String adress;
    private String Location;
    private String phone_number;
    private String email;
}
