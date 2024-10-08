package br.com.dev.inventorylocation.repository;

import br.com.dev.inventorylocation.domain.entity.InventoryLocation;
import br.com.dev.inventorylocation.domain.entity.InventoryLocationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryLocationRepository extends JpaRepository<InventoryLocation, InventoryLocationId> {}