
package com.example.common.udc.biz;


import com.example.common.udc.domain.entity.UDCType;

/**
 *
 */
public interface UDCService {
    UDCType findByCode(String code);
}
