/*
 * Copyright (c) 2010-2011 meituan.com
 * All rights reserved.
 * 
 */
package com.meituan.service.mobile.example.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meituan.service.mobile.example.dao.IExampleDao;
import com.meituan.service.mobile.example.model.Example;
import com.meituan.service.mobile.example.service.IExampleService;

/**
 * @author zhengxu
 * 
 * @version 1.0
 */
@Service
public class ExampleServiceImpl implements IExampleService {

    @Autowired
    IExampleDao exampleDao;

    @Override
    public Example getOneExample(String did) {
        return exampleDao.getOneExample(did);
    }

    @Override
    public List<Example> getExamples() {
        return exampleDao.getExamples();
    }

    @Override
    public int insert(Example example) {
        return exampleDao.insert(example);
    }

    @Override
    public int update(String did) {
        return exampleDao.update(did);
    }

    @Override
    public int delete(String did) {
        return exampleDao.delete(did);
    }

}
