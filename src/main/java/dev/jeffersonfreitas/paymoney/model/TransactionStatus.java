package dev.jeffersonfreitas.paymoney.model;

public enum TransactionStatus {
    APPROVED("approved"),
    PENDING("pending"),
    REFUSED("refused");

    private String description;

    TransactionStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
