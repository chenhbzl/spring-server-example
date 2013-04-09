package com.meituan.service.mobile.example.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.meituan.service.mobile.example.dao.IExampleDao;
import com.meituan.service.mobile.example.model.Example;

@Repository
public class ExampleDaoImpl extends NamedParameterJdbcDaoSupport implements
        IExampleDao, RowMapper<Example> {

    public static final String QUERY_EXAMPLE_BY_DID = "select * from server_example where did = :did";

    public static final String QUERY_EXAMPLE_BY_VERIFIED = "select * from server_example verified  = :verified";

    public static final String INSERT_EXAMPLE = "insert into server_example (udid,did,appnm,source,activeTime,verified) values (:udid,:did,:appnm,:source,:activeTime,:verified)";

    public static final String UPDATW_EXAMPLE_VERIFIED = "update server_example set verified = 1 where did = :did";

    public static final String DELETE_EXAMPLE_BY_DID = "delete from server_example  where did = :did";

    @Autowired
    public void initDataSource(DataSource dataSource) {
        setDataSource(dataSource);
    }

    @Override
    public Example getOneExample(String did) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("did", did);
        Example example = this.getNamedParameterJdbcTemplate().queryForObject(
                QUERY_EXAMPLE_BY_DID, paramSource, this);

        return example;

    }

    @Override
    public List<Example> getExamples() {

        int verified = 0;

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("verified", verified);
        List<Example> list = this.getNamedParameterJdbcTemplate().query(
                QUERY_EXAMPLE_BY_VERIFIED, paramSource, this);
        return list;

    }

    @Override
    public Example mapRow(ResultSet rs, int rowNum) throws SQLException {
        Example e = new Example();
        e.setActiveTime(rs.getDate("activeTime"));
        e.setAppnm(rs.getString("appnm"));
        e.setComfireTime(rs.getDate("confirmTime"));
        e.setDid(rs.getString("did"));
        e.setSource(rs.getString("source"));
        e.setUdid(rs.getString("udid"));
        e.setVerified(rs.getInt("verified"));
        return e;

    }

    @Override
    public int insert(Example example) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("udid", example.getUdid());
        paramSource.addValue("did", example.getDid());
        paramSource.addValue("appnm", example.getAppnm());
        paramSource.addValue("source", example.getSource());
        paramSource.addValue("activeTime", example.getActiveTime());
        paramSource.addValue("verified", example.getVerified());
        return this.getNamedParameterJdbcTemplate().update(INSERT_EXAMPLE,
                paramSource);

    }

    @Override
    public int update(String did) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("did", did);
        return this.getNamedParameterJdbcTemplate().update(
                UPDATW_EXAMPLE_VERIFIED, paramSource);

    }

    @Override
    public int delete(String did) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("did", did);
        return this.getNamedParameterJdbcTemplate().update(
                DELETE_EXAMPLE_BY_DID, paramSource);
    }
}
