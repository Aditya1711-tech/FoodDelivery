package com.tiffin.foodDelivery.repositories;

import com.tiffin.foodDelivery.entities.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ItemRepository extends MongoRepository<Item, String> {
}
