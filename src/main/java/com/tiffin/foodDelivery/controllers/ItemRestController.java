package com.tiffin.foodDelivery.controllers;

import com.tiffin.foodDelivery.audits.ApplicationAuditAware;
import com.tiffin.foodDelivery.dtos.common.ResponseDTO;
import com.tiffin.foodDelivery.entities.Item;
import com.tiffin.foodDelivery.repositories.ItemRepository;
import com.tiffin.foodDelivery.utils.constants.MessageConstants;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
@AllArgsConstructor
public class ItemRestController {

    private ItemRepository itemRepository;

    @PostMapping
    public ResponseEntity<ResponseDTO<Item>> createItem(@RequestBody Item item){
        return ResponseEntity.ok(ResponseDTO.success(MessageConstants.UserSuccess.TOKEN_REFRESHED, itemRepository.save(item)));
    }
}
