package br.com.dev.inventorylocation.domain.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class InventoryLocationId implements Serializable {

    private Long warehouseId;
    private String sectionId;
    private Integer shelfId;
    private Integer positionId;
}
