package com.tiffin.foodDelivery.entities;

import com.tiffin.foodDelivery.entities.common.NameEntity;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = true)
@Document(collection = "items")
public class Item extends NameEntity {
    private Double price = 0.0;
    private Integer quantity = 0;
    private String imageUrl;
}
