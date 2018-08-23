package com.vaiot.multichain.external.dto;

public class ChainLogDTO extends BaseDTO {

    public byte[] getLogs() {
        return logs;
    }

    public void setLogs(byte[] logs) {
        this.logs = logs;
    }

    private byte[] logs;
}
