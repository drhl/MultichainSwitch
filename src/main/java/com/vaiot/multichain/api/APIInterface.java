package com.vaiot.multichain.api;

import com.vaiot.multichain.api.exception.APIException;
import com.vaiot.security.dto.Token;
import com.vaiot.multichain.external.dto.ChainDataDTO;
import com.vaiot.multichain.type.ChainType;

public interface APIInterface {
    public Token generateToken(byte[] userData)  throws APIException;
    public ChainDataDTO readDataFromBlockchain(byte[] dataId, ChainType blockchainType, Token token) throws APIException;
    public ChainDataDTO writeDataToBlockchain(byte[] data, ChainType blockchainType, Token token)  throws APIException;
    public ChainDataDTO convertData(ChainDataDTO dataToConvert, ChainType targetBlockchainType, Token token)  throws APIException;
}
