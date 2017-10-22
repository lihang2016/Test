package com.example.domain.app.service;

import com.example.dto.PageDto;
import com.example.dto.PersonDto;
import com.example.dto.PersonTwoDto;
import com.example.dto.SingleResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 96230 on 2017/5/29.
 */
@Transactional
@Service
public class PersonAppService {


    public SingleResponse<List<PersonDto>> queryListPerson(){
        return null;
    }

    public SingleResponse<Page<PersonTwoDto>> queryListPersonTwo(PageDto pageDto){
        return null;
    }
}
