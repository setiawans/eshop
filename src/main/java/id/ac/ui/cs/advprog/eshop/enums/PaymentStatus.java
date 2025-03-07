package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum PaymentStatus {
    SUCCESS("SUCCESS"),
    REJECTED("REJECTED");

    private final String value;

    PaymentStatus(String value) {
        this.value = value;
    }

    public static boolean contains(String param) {
        try {
            PaymentStatus.valueOf(param);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}