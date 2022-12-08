package com.Examples;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@ApiModel(value = "benim PET nesnem",description = "my PET")
public class Pet {
    @ApiModelProperty(value = "pet nesnesinin tekil id alanı")
    private long id;
    @ApiModelProperty(value = "pet nesnesinin tekil name alanı")
    private String name;
    @ApiModelProperty(value = "pet nesnesinin tekil date alanı")
    private Date date;
}
