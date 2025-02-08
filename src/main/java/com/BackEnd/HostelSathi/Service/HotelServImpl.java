package com.BackEnd.HostelSathi.Service;

import com.BackEnd.HostelSathi.Dto.HotelDto;
import com.BackEnd.HostelSathi.Entity.Hotel;
import com.BackEnd.HostelSathi.Execption.ResourceNotFoundExp;
import com.BackEnd.HostelSathi.Reposetory.HotelRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class HotelServImpl implements HotelServ {



    private final HotelRepository hotelRepository;
    private final ModelMapper modelMapper;

    @Override
    public HotelDto createNewHotel(HotelDto hoteldto) {

        log.info("creating a new hotel with id: {}"+hoteldto.getId());

        Hotel hotel=modelMapper.map(hoteldto,Hotel.class);

        hotel.setActive(false);

        hotel= hotelRepository.save(hotel);

       log.info("hotel got created with the id "+hotel.getId());

        return modelMapper.map(hotel,HotelDto.class);
    }
    @Override
    public HotelDto getHotelById(Long id) {
     log.info("trying to get hotel by hotel id:{}",id);
       Hotel hotel= hotelRepository.findById(id).orElseThrow(()->
               new ResourceNotFoundExp("hotel does not exist with given id"));
        return modelMapper.map(hotel,HotelDto.class);
    }

    @Override
    public HotelDto updateHotelById(Long Id, HotelDto hotelDto) {
        log.info("updating the hotel with hotel id : {}",Id);
        Hotel hotel= hotelRepository.findById(Id)
                .orElseThrow(()->new ResourceNotFoundExp("hotel not found with id this "+Id));
        modelMapper.map(hotelDto,hotel);
        hotel.setId(Id);
       Hotel updatedHotel= hotelRepository.save(hotel);
       log.info("hotel ot updated with id this :{}",Id);
       return  modelMapper.map(updatedHotel,HotelDto.class);

    }

    @Override
    public void deleteHotelById(Long Id) {
        log.info("Deleting the hotel with hotel id : {}",Id);
        Hotel hotel= hotelRepository.findById(Id)
                .orElseThrow(()->new ResourceNotFoundExp("hotel not found with id this "+Id));
        hotelRepository.deleteById(Id);

    }
}
