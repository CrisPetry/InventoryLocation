package br.com.dev.inventorylocation.exception;

public class InventoryLocationNotFoundException extends RuntimeException{
    public InventoryLocationNotFoundException(String message) {
        super(message);
    }
}
