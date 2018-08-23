package com.vaiot.multichain.external.dto;

import com.vaiot.multichain.type.ChainType;

public abstract class BaseDTO {

    public byte[] getId() {
        return id;
    }

    public void setId(byte[] id) {
        this.id = id;
    }


    public ChainType getOrigin() {
        return origin;
    }

    public void setOrigin(ChainType origin) {
        this.origin = origin;
    }


    private byte[] id;
    private ChainType origin;
}
