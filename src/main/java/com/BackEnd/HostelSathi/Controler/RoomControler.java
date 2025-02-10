package com.BackEnd.HostelSathi.Controler;

import com.BackEnd.HostelSathi.Dto.RoomDto;
import com.BackEnd.HostelSathi.Service.RoomSer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/admin/hotel/{hotelId}rooms")
public class RoomControler{

    private final RoomSer roomSer;

    @PutMapping
    public ResponseEntity<RoomDto> createNewRoom(@PathVariable Long hotelId,
                                                 @RequestBody RoomDto roomDto) {
        log.info("trying  to create room in the hotel:{}", hotelId);
        RoomDto room = roomSer.createNewRoom(hotelId, roomDto);
        return new ResponseEntity<>(room, HttpStatus.CREATED);

    }

    @GetMapping
    public ResponseEntity<List<RoomDto>>getAllRoomInHotel(@PathVariable Long hotelId) {

        log.info("trying  to fetch hotelsRoom from the hotel:{}", hotelId);
        return ResponseEntity.ok((List<RoomDto>) roomSer.getAllRoomInHotel(hotelId));
    }

    @GetMapping("/{RoomId}")
    public ResponseEntity<RoomDto> getRoomInHotel(@PathVariable Long RoomId) {
        RoomDto rooms = roomSer.getRoomById(RoomId);
        log.info("trying  to get a room in the hotelsRoom :{}", RoomId);
        return new ResponseEntity<>(rooms, HttpStatus.FOUND);
    }

    @DeleteMapping("/{RoomId}")
        public ResponseEntity deleteRoomInHotel(@PathVariable Long RoomId){
        roomSer.DeleteRoomById(RoomId);
        return (ResponseEntity) ResponseEntity.ok();

    }
}
