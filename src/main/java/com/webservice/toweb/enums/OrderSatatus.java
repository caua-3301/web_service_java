package com.webservice.toweb.enums;

public enum OrderSatatus {
    WAINTING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCELED(5);

    private int code;

    private OrderSatatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static OrderSatatus valueOf(int code) {
        for (OrderSatatus value: OrderSatatus.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Status of order doenst exist");
    }
}
