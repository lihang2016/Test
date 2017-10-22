

package com.example.common.udc.domain.service;

import com.example.common.udc.app.dto.UDCItemDto;
import com.example.common.udc.domain.entity.UDCItem;
import com.example.common.udc.domain.repository.UDCItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class UDCItemDomainService {

    @Autowired
    private UDCItemRepository udcItemRepository;

    public UDCItem findById(Long id) {
        return udcItemRepository.findOne(id);
    }

    public Page<UDCItem> findAll(UDCItemDto dto) {
        return udcItemRepository.findAll(dto.toPage());
    }

}
