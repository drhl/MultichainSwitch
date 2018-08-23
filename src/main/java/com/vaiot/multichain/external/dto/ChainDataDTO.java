package com.vaiot.multichain.external.dto;

public class ChainDataDTO extends BaseDTO {

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    private byte[] data;
}
