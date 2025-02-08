package com.BackEnd.HostelSathi.Controler;

import com.BackEnd.HostelSathi.Dto.HotelDto;
import com.BackEnd.HostelSathi.Entity.Hotel;
import com.BackEnd.HostelSathi.Service.HotelServ;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/hotel")
public class HotelControler {

    private final HotelServ hotelServ;

    @PostMapping("/post")
    public ResponseEntity<HotelDto> createNewHotel(@RequestBody HotelDto hotelDto){
      //  log.info("creating hotel by hotel hotel manager ");
        HotelDto hotel = hotelServ.createNewHotel(hotelDto);
       return new  ResponseEntity<>(hotel, HttpStatus.CREATED);
    }


    @GetMapping("/{hotelId}")
    public ResponseEntity<HotelDto> getHotelById(@PathVariable Long hotelId){
        HotelDto hotel=hotelServ.getHotelById(hotelId);
        log.info("getting hotel by hotel id : {}",hotelId);
        return new ResponseEntity<>(hotel,HttpStatus.FOUND);
    }

    @PutMapping("/{hotelId}")
    public ResponseEntity<HotelDto> updateTheHotel(@PathVariable Long hotelId,
                                                   @RequestBody HotelDto hotelDto){
      HotelDto hotel=  hotelServ.updateHotelById(hotelId,hotelDto);
        return new ResponseEntity<>(hotel,HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity deleteHotel(@PathVariable Long hotelId ){
        hotelServ.deleteHotelById(hotelId);
        return ResponseEntity.ok().build();
    }
}

