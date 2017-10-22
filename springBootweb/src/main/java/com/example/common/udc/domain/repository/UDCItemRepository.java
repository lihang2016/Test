
package com.example.common.udc.domain.repository;


import com.example.common.udc.domain.entity.UDCItem;
import com.example.dao.BaseRepository;

import java.util.List;

/**
 *
 */
public interface UDCItemRepository extends BaseRepository<UDCItem, Long> {


    List<UDCItem> findByTypeIdOrderByValue(Long typeId);



}
