package com.czk.dao;

import com.czk.domain.Shirofilterchain;
import com.czk.domain.ShirofilterchainExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShirofilterchainMapper {
    int countByExample(ShirofilterchainExample example);

    int deleteByExample(ShirofilterchainExample example);

    int deleteByPrimaryKey(String id);

    int insert(Shirofilterchain record);

    int insertSelective(Shirofilterchain record);

    List<Shirofilterchain> selectByExample(ShirofilterchainExample example);

    Shirofilterchain selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") Shirofilterchain record, @Param("example") ShirofilterchainExample example);

    int updateByExample(@Param("record") Shirofilterchain record, @Param("example") ShirofilterchainExample example);

    int updateByPrimaryKeySelective(Shirofilterchain record);

    int updateByPrimaryKey(Shirofilterchain record);
}