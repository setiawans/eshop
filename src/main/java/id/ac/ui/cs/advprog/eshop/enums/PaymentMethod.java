package id.ac.ui.cs.advprog.eshop.enums;

import lombok.Getter;

@Getter
public enum PaymentMethod {
    VOUCHER("VOUCHER"),
    TRANSFER_BANK("TRANSFER_BANK");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    public static boolean contains(String param) {
        try {
            PaymentMethod.valueOf(param);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}