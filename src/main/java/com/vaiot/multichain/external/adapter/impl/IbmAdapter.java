package com.vaiot.multichain.external.adapter.impl;

import com.vaiot.multichain.external.adapter.AdapterInterface;
import com.vaiot.multichain.external.dto.ChainDataDTO;
import com.vaiot.multichain.external.dto.ChainLogDTO;

public class IbmAdapter implements AdapterInterface {
    @Override
    public ChainDataDTO getData(byte[] dataId) {
        return null;
    }

    @Override
    public ChainDataDTO putDate(byte[] data) {
        return null;
    }

    @Override
    public ChainLogDTO getLogs(byte[] logsId) {
        return null;
    }

    @Override
    public ChainLogDTO putLogs(byte[] logs) {
        return null;
    }
}
