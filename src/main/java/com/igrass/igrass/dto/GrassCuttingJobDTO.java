package com.igrass.igrass.dto;

import com.igrass.igrass.entity.User;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
public class GrassCuttingJobDTO {

    private Long serviceId;
    private User userDetail;
    private String description;
    private BigDecimal price;
    private String location;

    public GrassCuttingJobDTO(com.igrass.igrass.entity.GrassCuttingJob grassCuttingJob){
        BeanUtils.copyProperties(grassCuttingJob, this);
    }

    public GrassCuttingJobDTO() {
    }

}
