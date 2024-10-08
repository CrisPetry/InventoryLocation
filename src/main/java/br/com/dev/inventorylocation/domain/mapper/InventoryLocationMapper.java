package br.com.dev.inventorylocation.domain.mapper;

import br.com.dev.inventorylocation.domain.entity.InventoryLocation;
import br.com.dev.inventorylocation.domain.entity.InventoryLocationId;
import br.com.dev.inventorylocation.domain.dto.InventoryLocationDTO;
import org.springframework.stereotype.Component;

@Component
public class InventoryLocationMapper {

    public InventoryLocationDTO toDTO(InventoryLocation entity) {
        return InventoryLocationDTO.builder()
                .warehouseId(entity.getId().getWarehouseId())
                .sectionId(entity.getId().getSectionId())
                .shelfId(entity.getId().getShelfId())
                .positionId(entity.getId().getPositionId())
                .itemName(entity.getItemName())
                .quantity(entity.getQuantity())
                .lastUpdate(entity.getLastUpdate())
                .build();
    }

    public InventoryLocation toEntity(InventoryLocationDTO dto) {
        InventoryLocationId id = new InventoryLocationId(
                dto.getWarehouseId(),
                dto.getSectionId(),
                dto.getShelfId(),
                dto.getPositionId()
        );

        return InventoryLocation.builder()
                .id(id)
                .itemName(dto.getItemName())
                .quantity(dto.getQuantity())
                .lastUpdate(dto.getLastUpdate())
                .build();
    }
}
