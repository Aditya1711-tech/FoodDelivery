package com.tiffin.foodDelivery.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.tiffin.foodDelivery.dtos.common.NamedDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ItemDTO extends NamedDTO {
    @JsonIgnore
    private MultipartFile image;
    private Double price = 0.0;
    private Integer quantity = 0;
    private String imageUrl;
}
