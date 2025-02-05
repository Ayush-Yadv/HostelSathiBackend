package com.BackEnd.HostelSathi.Dto;


import com.BackEnd.HostelSathi.Entity.Hotel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomDto {

    private Long id;



    private String Type;

    private Hotel hotel;


    private String[] photo;


    private String[] animetiese;


    private Integer TotalCount;


    private BigDecimal Bestprice;


    private Integer Capacity;

    private LocalDateTime createdAt;

    private Boolean active;


}
