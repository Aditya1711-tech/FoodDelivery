package com.tiffin.foodDelivery.services.impl;

import com.tiffin.foodDelivery.dtos.ItemDTO;
import com.tiffin.foodDelivery.dtos.fileupload.FileUploadDTO;
import com.tiffin.foodDelivery.entities.Item;
import com.tiffin.foodDelivery.exceptions.ItemNotFoundException;
import com.tiffin.foodDelivery.mappers.ItemMapper;
import com.tiffin.foodDelivery.repositories.ItemRepository;
import com.tiffin.foodDelivery.services.ItemService;
import com.tiffin.foodDelivery.services.fileupload.FileUploadService;
import com.tiffin.foodDelivery.utils.constants.MessageConstants;
import com.tiffin.foodDelivery.utils.functions.FileUtils;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);

    private final ItemMapper itemMapper;
    private final FileUploadService fileUploadService;
    private final ItemRepository itemRepository;

    private final List<String> allowedFileExtensions = List.of("jpg", "png", "jpeg");

    @Override
    public Item getEntity(ItemDTO itemDTO) {
        return itemMapper.toEntity(itemDTO);
    }

    @Override
    public ItemDTO getDTO(Item item) {
        return itemMapper.toDTO(item);
    }

    @Override
    public List<Item> getEntityList(List<ItemDTO> itemDTOList) {
        return itemMapper.toEntityList(itemDTOList);
    }

    @Override
    public List<ItemDTO> getDTOList(List<Item> itemList) {
        return itemMapper.toDTOList(itemList);
    }

    @Override
    public Item create(ItemDTO itemDTO) throws Exception {
        // Step 1: Upload image first
        MultipartFile itemImage = itemDTO.getImage();
        String fileExtension = FileUtils.getFileExtension(itemImage);
        if(!allowedFileExtensions.contains(fileExtension)) throw new Exception(MessageConstants.FileUpload.FILE_NOT_ALLOWED);

        String imageUrl = fileUploadService.uploadFile(new FileUploadDTO(itemImage));

        // Step 2: Get Item object from ItemDTO
        Item newItem = itemMapper.toEntity(itemDTO);
        newItem.setImageUrl(imageUrl);

        return itemRepository.save(newItem);
    }

    @Override
    public Item getById(String itemId) {
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new ItemNotFoundException(MessageConstants.Item.ITEM_NOT_FOUND));
        return item;
    }

    @Override
    public Item updateById(String itemId, ItemDTO itemDTO) {
        Item existingItem = this.getById(itemId);
        itemMapper.updateEntity(itemDTO, existingItem);
        return itemRepository.save(existingItem);
    }
}
