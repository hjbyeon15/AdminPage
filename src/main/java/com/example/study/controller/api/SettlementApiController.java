/*
use study;
DROP TABLE IF EXISTS settlement;
CREATE TABLE settlement
(
	USER_ID BIGINT NOT NULL
    ,PRICE BIGINT NOT NULL
    ,PRIMARY KEY(USER_ID)
) ENGINE=InnoDB
;
COMMIT;
* */

package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.SettlementApiRequest;
import com.example.study.model.network.response.SettlementApiResponse;
import com.example.study.service.SettlementApiLogicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settlement")
public class SettlementApiController implements CrudInterface<SettlementApiRequest, SettlementApiResponse> {
    @Autowired
    private SettlementApiLogicService settlementApiLogicService;

    @Override
    @PostMapping("")
    public Header<SettlementApiResponse> create(@RequestBody Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    @GetMapping("{id}")
    public Header<SettlementApiResponse> read(@PathVariable Long id) {
        return null;
    }

    @Override
    @PutMapping("")
    public Header<SettlementApiResponse> update(@RequestBody Header<SettlementApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}")
    public Header delete(@PathVariable Long id) {
        return null;
    }
}
