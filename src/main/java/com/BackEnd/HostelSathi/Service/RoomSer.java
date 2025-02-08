package com.BackEnd.HostelSathi.Service;

import com.BackEnd.HostelSathi.Dto.RoomDto;

public interface RoomSer {

    RoomDto createNewRoom(Long hotelId,RoomDto roomDto);

    RoomDto getAllRoomInHotel(Long hotelId);


    RoomDto getRoomById(Long RoomId);

    void DeleteRoomById(Long roomId);


}
