package com.vaiot.multichain.external.adapter;

import com.vaiot.multichain.external.dto.ChainDataDTO;
import com.vaiot.multichain.external.dto.ChainLogDTO;

public interface AdapterInterface {
    public ChainDataDTO getData(byte[] dataId);
    public ChainDataDTO putDate(byte[] data);
    public ChainLogDTO getLogs(byte[] logsId);
    public ChainLogDTO putLogs(byte[] logs);
}
