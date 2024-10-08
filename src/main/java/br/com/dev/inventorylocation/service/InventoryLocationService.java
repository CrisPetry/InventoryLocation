package br.com.dev.inventorylocation.service;

import br.com.dev.inventorylocation.domain.dto.InventoryLocationDTO;
import br.com.dev.inventorylocation.domain.entity.InventoryLocation;
import br.com.dev.inventorylocation.domain.entity.InventoryLocationId;
import br.com.dev.inventorylocation.domain.mapper.InventoryLocationMapper;
import br.com.dev.inventorylocation.exception.InventoryLocationNotFoundException;
import br.com.dev.inventorylocation.repository.InventoryLocationRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class InventoryLocationService {

    private final InventoryLocationRepository repository;
    private final InventoryLocationMapper mapper;

    @Transactional
    public InventoryLocationDTO createInventoryLocation(InventoryLocationDTO dto) {
        InventoryLocation entity = mapper.toEntity(dto);
        InventoryLocation entitySaved = repository.save(entity);
        return mapper.toDTO(entitySaved);
    }

    public Page<InventoryLocationDTO> findAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDTO);
    }

    public InventoryLocationDTO findById(Long warehouseId, String sectionId, Integer shelfId, Integer positionId) {
        InventoryLocationId id = new InventoryLocationId(warehouseId, sectionId, shelfId, positionId);
        InventoryLocation entity = repository.findById(id)
                .orElseThrow(() -> new InventoryLocationNotFoundException("Localização de inventário não encontrada"));
        return mapper.toDTO(entity);
    }

    @Transactional
    public InventoryLocationDTO updateInventoryLocation(Long warehouseId, String sectionId, Integer shelfId, Integer positionId, InventoryLocationDTO dto) {
        InventoryLocationId id = new InventoryLocationId(warehouseId, sectionId, shelfId, positionId);
        InventoryLocation entity = repository.findById(id)
                .orElseThrow(() -> new InventoryLocationNotFoundException("Localização de inventário não encontrada"));

        // Atualizando os campos
        entity.setItemName(dto.getItemName());
        entity.setQuantity(dto.getQuantity());
        entity.setLastUpdate(dto.getLastUpdate());

        InventoryLocation updatedEntity = repository.save(entity);
        return mapper.toDTO(updatedEntity);
    }

    @Transactional
    public void deleteInventoryLocation(Long warehouseId, String sectionId, Integer shelfId, Integer positionId) {
        InventoryLocationId id = new InventoryLocationId(warehouseId, sectionId, shelfId, positionId);
        repository.deleteById(id);
    }
}
