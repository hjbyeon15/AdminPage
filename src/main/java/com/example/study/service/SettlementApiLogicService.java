package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.SettlementApiRequest;
import com.example.study.model.network.response.SettlementApiResponse;
import com.example.study.repository.SettlementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SettlementApiLogicService implements CrudInterface<SettlementApiRequest, SettlementApiResponse> {
    @Autowired
    private SettlementRepository settlementRepository;

    @Override
    public Header<SettlementApiResponse> create(Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    public Header<SettlementApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<SettlementApiResponse> update(Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    public Header delete(Long id) {
        return null;
    }
}
