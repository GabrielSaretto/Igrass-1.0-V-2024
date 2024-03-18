package com.igrass.igrass.dao;

import com.igrass.igrass.entity.GrassCuttingJob;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GrassCuttingJobRepository extends JpaRepository<GrassCuttingJob, Long> {
}
