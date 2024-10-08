package br.com.dev.inventorylocation.domain.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryLocationDTO {

    @NotNull
    private Long warehouseId;

    @NotNull
    @Size(min = 1, max = 10)
    private String sectionId;

    @NotNull
    private Integer shelfId;

    @NotNull
    private Integer positionId;

    @NotNull
    @Size(min = 2, max = 100)
    private String itemName;

    @Min(1)
    private Integer quantity;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastUpdate;

}
