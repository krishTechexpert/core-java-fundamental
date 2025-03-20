package com.FindTrain.FindTrainProject.repo;

import com.FindTrain.FindTrainProject.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StationRepository extends JpaRepository<Station,Long> {
}
