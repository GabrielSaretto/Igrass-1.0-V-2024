package com.igrass.igrass.services;

import com.igrass.igrass.dto.GrassCuttingJobDTO;
import com.igrass.igrass.dto.UserDTO;

import java.util.List;

public interface GrassCuttingJobService {
    void createGrassCuttingJob(GrassCuttingJobDTO grassCuttingJobDTO);

    GrassCuttingJobDTO getGrassCuttingJobById(Long serviceId);

    List<GrassCuttingJobDTO> getAllGrassCuttingJob();

    GrassCuttingJobDTO updateGrassCuttingJob(GrassCuttingJobDTO newGrassCuttingJobDTO);

    void deleteById(Long theId);

    void deleteAllUsers();
}
