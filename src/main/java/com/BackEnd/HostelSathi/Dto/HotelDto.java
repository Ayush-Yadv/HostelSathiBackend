package com.BackEnd.HostelSathi.Dto;

import com.BackEnd.HostelSathi.Entity.ContactInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotelDto {

    private Long id;

    private String name;

    private String city;


    private String[] photo;


    private String[] animetiese;

    private ContactInfo contactInfo;

    private Boolean Active;
}

