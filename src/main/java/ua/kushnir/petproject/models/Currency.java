package ua.kushnir.petproject.models;

import lombok.Data;

public enum Currency {
    USD(840), UAH(980), EUR(978), GBP(826);
    private int code;

    Currency(int code) {
        this.code = code;
    }
}
