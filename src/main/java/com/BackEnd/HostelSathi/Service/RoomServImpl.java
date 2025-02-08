package com.BackEnd.HostelSathi.Service;

import com.BackEnd.HostelSathi.Dto.RoomDto;
import com.BackEnd.HostelSathi.Entity.Hotel;
import com.BackEnd.HostelSathi.Entity.Rooms;
import com.BackEnd.HostelSathi.Execption.ResourceNotFoundExp;
import com.BackEnd.HostelSathi.Reposetory.HotelRepository;
import com.BackEnd.HostelSathi.Reposetory.RoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomServImpl implements RoomSer{

      private  final ModelMapper modelMapper;
      private  final HotelRepository hotelRepository;
      private  final RoomRepository roomRepository;
     // private final Hotel hotel;
    @Override
    public RoomDto createNewRoom(Long hotelId, RoomDto roomDto) {
        log.info("Creating Room in the hotel witch have the id :{}", hotelId);
         Hotel hotel=  hotelRepository.findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundExp("hotel of the given id not fond"+hotelId));
        Rooms room=modelMapper.map(roomDto,Rooms.class);
        room.setHotel(hotel);
        room=roomRepository.save(room);

       return modelMapper.map(room,RoomDto.class);
    }

    @Override
    public RoomDto getAllRoomInHotel(Long hotelId) {
        log.info("Creating Room in the hotel witch have the id :{}", hotelId);
        Hotel hotel=  hotelRepository.findById(hotelId)
                .orElseThrow(()-> new ResourceNotFoundExp("hotel of the given id not fond"+hotelId));

        return (RoomDto) hotel.getRooms()
                .stream()
                .map(element -> modelMapper.map(element, RoomDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public RoomDto getRoomById(Long RoomId) {
        log.info("Getting the room with ID: {}", RoomId);
        Rooms room = roomRepository
                .findById(RoomId)
                .orElseThrow(() -> new ResourceNotFoundExp("Room not found with ID: " + RoomId));

        return modelMapper.map(room, RoomDto.class);
    }

    @Override
    public void DeleteRoomById(Long roomId) {
        log.info("Deleting the room with ID: {}", roomId);
        boolean exists = roomRepository.existsById(roomId);

        if (!exists) {
            throw new ResourceNotFoundExp("Room not found with ID: " + roomId);
        }

        roomRepository.deleteById(roomId);
    }
}
