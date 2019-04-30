package com.example.simple_maven_app.service.impl;

import com.example.simple_maven_app.repository.CommonDao;
import com.example.simple_maven_app.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 14183
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Autowired
    protected CommonDao commonDao;

    public void setCommonDao(CommonDao commonDao) {
        this.commonDao = commonDao;
    }
}
