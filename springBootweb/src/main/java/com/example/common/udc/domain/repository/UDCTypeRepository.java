
package com.example.common.udc.domain.repository;


import com.example.common.udc.domain.entity.UDCType;
import com.example.dao.BaseRepository;

/**
 *
 */
public interface UDCTypeRepository extends BaseRepository<UDCType, Long> {
    UDCType findByCode(String code);

}
