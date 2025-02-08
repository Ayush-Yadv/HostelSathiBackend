package com.BackEnd.HostelSathi.Service;

import com.BackEnd.HostelSathi.Dto.HotelDto;

public interface HotelServ {
    HotelDto createNewHotel(HotelDto hotelDto);

    HotelDto getHotelById(Long id);

    HotelDto updateHotelById(Long Id, HotelDto hotelDto);

    void deleteHotelById(Long Id);
}
