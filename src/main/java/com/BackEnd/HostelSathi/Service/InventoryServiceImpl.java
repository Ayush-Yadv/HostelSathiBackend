package com.BackEnd.HostelSathi.Service;

import com.BackEnd.HostelSathi.Entity.Inventory;
import com.BackEnd.HostelSathi.Entity.Rooms;
import com.BackEnd.HostelSathi.Reposetory.InventryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService{

    private final InventryRepository inventoryRepository;

    @Override
    public Void initializeRoomForAYear(Rooms room) {
        LocalDate today = LocalDate.now();
        LocalDate endDate = today.plusYears(1);
        for(; !today.isAfter(endDate); today = today.plusDays(1)){
            Inventory inventory = Inventory.builder()
                    .hotel(room.getHotel())
                    .room(room)
                    .bookedcount(0)
                    .city(room.getHotel().getCity())
                    .date(today)
                    .price(room.getBestprice())
                    .surgeFactor(BigDecimal.ONE)
                    .totalcount(room.getTotalCount())
                    .closed(false)
                    .build();
            inventoryRepository.save(inventory);
        }
        return null;
    }

    @Override
    public Void deleteFutureInventories(Rooms room) {
        LocalDate today = LocalDate.now();
        inventoryRepository.deleteAfterDateAndRoom(today ,room);
        return null;
    }
}
