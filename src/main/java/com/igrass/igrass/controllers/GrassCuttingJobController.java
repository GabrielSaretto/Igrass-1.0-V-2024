package com.igrass.igrass.controllers;

import com.igrass.igrass.dto.GrassCuttingJobDTO;
import com.igrass.igrass.services.GrassCuttingJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grasservice")
public class GrassCuttingJobController {

    @Autowired
    private GrassCuttingJobService grassCuttingJobService;

    @GetMapping()
    public ResponseEntity<List<GrassCuttingJobDTO>> getAllGrassCuttingJob(){
        List<GrassCuttingJobDTO> grassCuttingJob = grassCuttingJobService.getAllGrassCuttingJob();
        return ResponseEntity.ok(grassCuttingJob);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GrassCuttingJobDTO> getGrassCuttingJobById(@PathVariable Long id){
        GrassCuttingJobDTO grassCuttingJob = grassCuttingJobService.getGrassCuttingJobById(id);
        if (grassCuttingJob != null) {
            return ResponseEntity.ok(grassCuttingJob);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<String> createGrassCuttingJob(@RequestBody GrassCuttingJobDTO grassCuttingJob){
        grassCuttingJobService.createGrassCuttingJob(grassCuttingJob);
        return ResponseEntity.status(HttpStatus.CREATED).body("Serviço criado com sucesso");
    }

    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody GrassCuttingJobDTO grassCuttingJob){
        GrassCuttingJobDTO updateGrassCuttingJob = grassCuttingJobService.updateGrassCuttingJob(grassCuttingJob);
        if (updateGrassCuttingJob != null) {
            return ResponseEntity.ok("Serviço atualizado com sucesso");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id){
        grassCuttingJobService.deleteById(id);
        return ResponseEntity.ok("Serviço excluído com sucesso");
    }

    @DeleteMapping("/all")
    public ResponseEntity<String> deleteAll(){
        grassCuttingJobService.deleteAllUsers();
        return ResponseEntity.ok("Todos os serviços foram excluídos com sucesso");
    }

}
