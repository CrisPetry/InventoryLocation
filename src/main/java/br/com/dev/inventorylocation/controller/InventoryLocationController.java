package br.com.dev.inventorylocation.controller;

import br.com.dev.inventorylocation.domain.dto.InventoryLocationDTO;
import br.com.dev.inventorylocation.service.InventoryLocationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/inventory-locations")
@Tag(name = "InventoryLocation")
public class InventoryLocationController {
    private final InventoryLocationService service;

    @PostMapping
    @Operation(summary = "Cria um inventário.")
    public ResponseEntity<InventoryLocationDTO> createInventoryLocation(@Valid @RequestBody InventoryLocationDTO dto) {
        InventoryLocationDTO createdLocation = service.createInventoryLocation(dto);
        return new ResponseEntity<>(createdLocation, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Busca por todos os inventários.")
    public ResponseEntity<Page<InventoryLocationDTO>> getAllInventoryLocations(Pageable pageable) {
        Page<InventoryLocationDTO> locations = service.findAll(pageable);
        return ResponseEntity.ok(locations);
    }

    @GetMapping("/{warehouseId}/{sectionId}/{shelfId}/{positionId}")
    @Operation(summary = "Busca por um inventário específico conforme as chaves informadas.")
    public ResponseEntity<InventoryLocationDTO> getInventoryLocationById(
            @PathVariable Long warehouseId,
            @PathVariable String sectionId,
            @PathVariable Integer shelfId,
            @PathVariable Integer positionId) {
        InventoryLocationDTO location = service.findById(warehouseId, sectionId, shelfId, positionId);
        return ResponseEntity.ok(location);
    }

    @PutMapping("/{warehouseId}/{sectionId}/{shelfId}/{positionId}")
    @Operation(summary = "Realiza a edição de um inventário existente.")
    public ResponseEntity<InventoryLocationDTO> updateInventoryLocation(
            @PathVariable Long warehouseId,
            @PathVariable String sectionId,
            @PathVariable Integer shelfId,
            @PathVariable Integer positionId,
            @Valid @RequestBody InventoryLocationDTO dto) {
        InventoryLocationDTO updatedLocation = service.updateInventoryLocation(warehouseId, sectionId, shelfId, positionId, dto);
        return ResponseEntity.ok(updatedLocation);
    }

    @DeleteMapping("/{warehouseId}/{sectionId}/{shelfId}/{positionId}")
    @Operation(summary = "Deleta um inventário da base.")
    public ResponseEntity<Void> deleteInventoryLocation(
            @PathVariable Long warehouseId,
            @PathVariable String sectionId,
            @PathVariable Integer shelfId,
            @PathVariable Integer positionId) {
        service.deleteInventoryLocation(warehouseId, sectionId, shelfId, positionId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
