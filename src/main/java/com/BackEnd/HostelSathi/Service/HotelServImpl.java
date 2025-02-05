package com.BackEnd.HostelSathi.Service;

import com.BackEnd.HostelSathi.Dto.HotelDto;
import com.BackEnd.HostelSathi.Entity.Hotel;
import com.BackEnd.HostelSathi.Reposetory.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServImpl implements HotelServ {


    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hoteldto) {

        log.info("creating a new hotel with id "+hoteldto.getId());

        Hotel hotel=modelMapper.map(hoteldto,Hotel.class);

        hotel.setActive(false);

        hotel= hotelRepository.save(hotel);

         log.info("hotel got created with the id "+hotel.getId());

        return modelMapper.map(hotel,HotelDto.class);
    }
    @Override
    public HotelDto getHotelById(Long id) {
        return null;
    }
}
