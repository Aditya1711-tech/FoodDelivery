package com.tiffin.foodDelivery.controllers;

import com.tiffin.foodDelivery.dtos.ItemDTO;
import com.tiffin.foodDelivery.dtos.common.ResponseDTO;
import com.tiffin.foodDelivery.entities.Item;
import com.tiffin.foodDelivery.mappers.ItemMapper;
import com.tiffin.foodDelivery.repositories.ItemRepository;
import com.tiffin.foodDelivery.services.ItemService;
import com.tiffin.foodDelivery.utils.constants.MessageConstants;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@AllArgsConstructor
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    @PostMapping
    public ResponseEntity<ResponseDTO<ItemDTO>> createItem(@ModelAttribute ItemDTO itemDTO) throws Exception {
        Item item = itemService.create(itemDTO);
        return ResponseEntity.ok(ResponseDTO.success(MessageConstants.Item.ITEM_CREATED, itemMapper.toDTO(item)));
    }

    @GetMapping("/{item-id}")
    public ResponseEntity<ResponseDTO<ItemDTO>> getItemById(@PathVariable(name = "item-id") String itemId){
        Item item = itemService.getById(itemId);
        return ResponseEntity.ok(ResponseDTO.success(MessageConstants.Item.ITEM_FOUND, itemMapper.toDTO(item)));
    }

    @PutMapping("/{item-id}")
    public ResponseEntity<ResponseDTO<ItemDTO>> updateItemById(@PathVariable(name = "item-id") String itemId, @ModelAttribute ItemDTO itemDTO){
        Item updatedItem = itemService.updateById(itemId, itemDTO);
        return ResponseEntity.ok(ResponseDTO.success(MessageConstants.Item.ITEM_UPDATED, itemMapper.toDTO(updatedItem)));
    }
}
