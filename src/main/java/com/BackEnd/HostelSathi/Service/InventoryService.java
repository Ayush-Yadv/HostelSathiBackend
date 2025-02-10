package com.BackEnd.HostelSathi.Service;

import com.BackEnd.HostelSathi.Entity.Rooms;

public interface InventoryService {


     Void initializeRoomForAYear(Rooms room);

     Void deleteFutureInventories(Rooms room);
}
