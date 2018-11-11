package com.lzr.mapper;

import com.lzr.pojo.ZhangWu;
import com.lzr.pojo.ZhangWuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ZhangWuMapper {
    int countByExample(ZhangWuExample example);

    int deleteByExample(ZhangWuExample example);

    int deleteByPrimaryKey(Integer zwid);

    int insert(ZhangWu record);

    int insertSelective(ZhangWu record);

    List<ZhangWu> selectByExample(ZhangWuExample example);

    ZhangWu selectByPrimaryKey(Integer zwid);

    int updateByExampleSelective(@Param("record") ZhangWu record, @Param("example") ZhangWuExample example);

    int updateByExample(@Param("record") ZhangWu record, @Param("example") ZhangWuExample example);

    int updateByPrimaryKeySelective(ZhangWu record);

    int updateByPrimaryKey(ZhangWu record);
}