package com.tiffin.foodDelivery.services;

import com.tiffin.foodDelivery.dtos.ItemDTO;
import com.tiffin.foodDelivery.entities.Item;

import java.util.List;

public interface ItemService {

    // Item Mapper
    Item getEntity(ItemDTO itemDTO);
    ItemDTO getDTO(Item item);
    List<Item> getEntityList(List<ItemDTO> itemDTOList);
    List<ItemDTO> getDTOList(List<Item> itemList);

    // Item Repository
    Item create(ItemDTO itemDTO) throws Exception;
    Item getById(String itemId);
    Item updateById(String itemId, ItemDTO itemDTO);
}
