package com.vaiot.multichain.api.rest;

import com.vaiot.multichain.api.exception.APIException;
import com.vaiot.multichain.engine.SwitchEngine;
import com.vaiot.multichain.api.APIInterface;
import com.vaiot.multichain.external.dto.ChainDataDTO;
import com.vaiot.multichain.type.ChainType;
import com.vaiot.store.DataEngine;
import com.vaiot.security.dto.Token;
import com.vaiot.security.TokenEngine;

public class RestEngine implements APIInterface {
    @Override
    public Token generateToken(byte[] userData) {
        Token userToken = TokenEngine.createToken(userData)  throws APIException;

        return userToken;
    }

    @Override
    public ChainDataDTO readDataFromBlockchain(byte[] dataId, ChainType blockchainType, Token token) throws APIException {
        if(TokenEngine.isValid(token) == false) {
            throw new APIException("Provided token is not valid");
        }

        SwitchEngine switchEngine = new SwitchEngine();
        ChainDataDTO chainDataDTO = switchEngine.readFromBlockchain(dataId, blockchainType, DataEngine.getAdditionalBlockchainData(blockchainType));

        return chainDataDTO;
    }

    @Override
    public ChainDataDTO writeDataToBlockchain(byte[] data, ChainType blockchainType, Token token) throws APIException {
        if(TokenEngine.isValid(token) == false) {
            throw new APIException("Provided token is not valid");
        }

        SwitchEngine switchEngine = new SwitchEngine();
        ChainDataDTO chainDataDTO = switchEngine.writeToBlockchain(data, blockchainType, DataEngine.getAdditionalBlockchainData(blockchainType));

        return chainDataDTO;
    }

    @Override
    public ChainDataDTO convertData(ChainDataDTO dataToConvert, ChainType targetBlockchainType, Token token) throws APIException {
        if(TokenEngine.isValid(token) == false) {
            throw new APIException("Provided token is not valid");
        }

        SwitchEngine switchEngine = new SwitchEngine();
        byte[] sourceAdditionalBlockchainData = DataEngine.getAdditionalBlockchainData(dataToConvert.getOrigin());
        byte[] targetAdditionalBlockchainData = DataEngine.getAdditionalBlockchainData(targetBlockchainType);

        ChainDataDTO convertedData = null;

        if(dataToConvert.getId() != null && dataToConvert.getData() == null) {
            switchEngine.convertDataFromId(dataToConvert.getId(), dataToConvert.getOrigin(),
                    sourceAdditionalBlockchainData, targetBlockchainType, targetAdditionalBlockchainData);
        } else if(dataToConvert.getData() != null) {
            switchEngine.convertData(dataToConvert.getData(), dataToConvert.getOrigin(),
                    sourceAdditionalBlockchainData, targetBlockchainType, targetAdditionalBlockchainData);
        } else {
            throw new APIException("Wrong value of dataToConvert - dataId and data not set");
        }

        return convertedData;
    }
}
