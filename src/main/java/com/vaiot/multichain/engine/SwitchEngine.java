package com.vaiot.multichain.engine;

import com.vaiot.ai.store.AIBlockchainDataStore;
import com.vaiot.multichain.engine.ai.AIEngine;
import com.vaiot.multichain.external.adapter.AdapterInterface;
import com.vaiot.multichain.external.adapter.factory.AdapterFactory;
import com.vaiot.multichain.external.dto.ChainDataDTO;
import com.vaiot.multichain.external.dto.ChainLogDTO;
import com.vaiot.multichain.type.ChainType;

public class SwitchEngine {
    public ChainDataDTO writeToBlockchain(byte[] data, ChainType blockchainType, byte[] additionalBlockchainData) {
        AdapterInterface adapter = AdapterFactory.createAdapter(blockchainType, additionalBlockchainData);

        return adapter.putDate(data);
    }

    public ChainDataDTO readFromBlockchain(byte[] dataId, ChainType blockchainType, byte[] additionalBlockchainData) {
        AdapterInterface adapter = AdapterFactory.createAdapter(blockchainType, additionalBlockchainData);

        return adapter.getData(dataId);
    }

    public ChainLogDTO writeLogsToBlockchain(byte[] logs, ChainType blockchainType, byte[] additionalBlockchainData) {
        AdapterInterface adapter = AdapterFactory.createAdapter(blockchainType, additionalBlockchainData);

        return adapter.putLogs(logs);
    }

    public ChainLogDTO readLogsFromBlockchain(byte[] logsId, ChainType blockchainType, byte[] additionalBlockchainData) {
        AdapterInterface adapter = AdapterFactory.createAdapter(blockchainType, additionalBlockchainData);

        return adapter.getLogs(logsId);
    }

    public ChainDataDTO convertDataFromId(byte[] sourceDataId, ChainType sourceBlockchainType, byte[] sourceAdditionalBlockchainData,
                                    ChainType targetBlockchainType, byte[] targetAdditionalBlockchainData) {
        ChainDataDTO sourceData = sourceAdapter.getData(sourceDataId);
        ChainDataDTO targetData = convertData(sourceData, sourceBlockchainType, sourceAdditionalBlockchainData,
                targetBlockchainType, targetAdditionalBlockchainData);

        return targetData;
    }

    public ChainDataDTO convertData(byte[] sourceData, ChainType sourceBlockchainType, byte[] sourceAdditionalBlockchainData,
                                    ChainType targetBlockchainType, byte[] targetAdditionalBlockchainData) {
        AdapterInterface sourceAdapter = AdapterFactory.createAdapter(sourceBlockchainType, sourceAdditionalBlockchainData);
        AdapterInterface targetAdapter = AdapterFactory.createAdapter(targetBlockchainType, targetAdditionalBlockchainData);

        ChainDataDTO targetData = AIEngine.translate(sourceData, targetBlockchainType,
                AIBlockchainDataStore.prepare(sourceBlockchainType, sourceAdditionalBlockchainData,
                        targetBlockchainType, targetAdditionalBlockchainData));

        return targetData;
    }
}
