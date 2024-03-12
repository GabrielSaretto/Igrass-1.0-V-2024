package com.igrass.igrass.services;

import com.igrass.igrass.dao.GrassCuttingJobRepository;
import com.igrass.igrass.dto.GrassCuttingJobDTO;
import com.igrass.igrass.entity.GrassCuttingJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GrassCuttingJobImpl implements GrassCuttingJobService{

    @Autowired
    private GrassCuttingJobRepository grassCuttingJobRepository;

    @Override
    public void createGrassCuttingJob(GrassCuttingJobDTO grassCuttingJobDTO) {
        GrassCuttingJob grassCuttingJob = new GrassCuttingJob(grassCuttingJobDTO);
        grassCuttingJobRepository.save(grassCuttingJob);
    }

    @Override
    public GrassCuttingJobDTO getGrassCuttingJobById(Long serviceId) {
        return new GrassCuttingJobDTO(grassCuttingJobRepository.findById(serviceId).get());
    }

    @Override
    public List<GrassCuttingJobDTO> getAllGrassCuttingJob() {
        List<GrassCuttingJob> allGrassCuttingJobs = grassCuttingJobRepository.findAll();
        return allGrassCuttingJobs.stream().map(GrassCuttingJobDTO::new).toList();
    }

    @Override
    public GrassCuttingJobDTO updateGrassCuttingJob(GrassCuttingJobDTO newGrassCuttingJobDTO) {
        GrassCuttingJob grassCuttingJob = new GrassCuttingJob(newGrassCuttingJobDTO);
        return new GrassCuttingJobDTO(grassCuttingJobRepository.save(grassCuttingJob));
    }

    @Override
    public void deleteById(Long theId) {
        GrassCuttingJob grassCuttingJob = grassCuttingJobRepository.findById(theId).get();
        grassCuttingJobRepository.delete(grassCuttingJob);
    }

    @Override
    public void deleteAllUsers() {
        grassCuttingJobRepository.deleteAll();
    }
}
