package com.example.common.udc.app.service;

import com.example.common.udc.app.dto.UDCItemDto;
import com.example.common.udc.domain.entity.UDCItem;
import com.example.common.udc.domain.service.UDCTypeDomainService;
import com.example.domain.entity.BaseEntity;
import com.example.dto.SingleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 */
@Service
@Transactional
public class UDCTypeAppService {

    @Autowired
    private UDCTypeDomainService domainService;

    /**
     * 根据UDC类型取Item
     *
     * @param request typeId
     * @return SingleResponse<List<UDCItemDto>>
     */
    @Transactional(readOnly = true)
    public SingleResponse<List<UDCItemDto>> findAll(Long request) {
        List<UDCItem> udcItems = domainService.getByTypeId(request);
        return SingleResponse.from(BaseEntity.map(udcItems, UDCItemDto.class));
    }

    @Transactional(readOnly = true)
    public SingleResponse<List<UDCItemDto>> findByTypeCode(String request) {
        List<UDCItem> udcItems = domainService.findByTypeCode(request);
        return SingleResponse.from(BaseEntity.map(udcItems, UDCItemDto.class));
    }
}
