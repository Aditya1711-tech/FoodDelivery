package com.tiffin.foodDelivery.mappers;

import com.tiffin.foodDelivery.dtos.ItemDTO;
import com.tiffin.foodDelivery.entities.Item;
import com.tiffin.foodDelivery.services.client.UserService;
import com.tiffin.foodDelivery.utils.functions.CustomDateTimeFormatter;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class ItemMapper {

    @Lazy
    @Autowired
    private UserService userService;

    @Named("toDTO")
    public abstract ItemDTO toDTO(Item item);

    @Named("toEntity")
    public abstract Item toEntity(ItemDTO itemDTO);

    @AfterMapping
    protected void stringFormatting(Item item, @MappingTarget ItemDTO itemDTO){
        itemDTO.setCreatedDate(CustomDateTimeFormatter.getFormatedDateTimeByIntensity(item.getCreatedDate()));
        itemDTO.setLastUpdatedDate(CustomDateTimeFormatter.getFormatedDateTimeByIntensity(item.getLastUpdatedDate()));
        itemDTO.setLastUpdatedBy(userService.getUsernameByUserId(item.getLastUpdatedBy()));
        itemDTO.setCreatedBy(userService.getUsernameByUserId(item.getCreatedBy()));
    }
}
