package com.example.demo.module2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional(readOnly = true)
public interface ParkingSpotRepository extends JpaRepository<ParkingSlot, Long> {
    List<ParkingSlot> findByLocation(String Location);
}
