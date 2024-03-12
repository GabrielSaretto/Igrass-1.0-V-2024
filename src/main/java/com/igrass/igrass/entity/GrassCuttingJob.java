package com.igrass.igrass.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Entity
@Table(name = "grass_cutting_job")
@Getter
@Setter
@ToString
public class GrassCuttingJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long serviceId;

    @ManyToOne
    @JoinColumn(name = "provider_id", nullable = false)
    private User userDetail;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "location", nullable = false)
    private String location;

    public GrassCuttingJob(com.igrass.igrass.dto.GrassCuttingJobDTO grassCuttingJobDTO){
        BeanUtils.copyProperties(grassCuttingJobDTO, this);
    }

    public GrassCuttingJob() {
    }
}
