package com.meituan.service.mobile.example.dao;

import java.util.List;

import com.meituan.service.mobile.example.model.Example;

public interface IExampleDao {

    public Example getOneExample(String did);

    public List<Example> getExamples();

    public int insert(Example example);

    public int update(String did);

    public int delete(String did);

}
