package com.dao;

import com.entity.ShangpinBangfushenqingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShangpinBangfushenqingView;

/**
 * 帮扶申请 Dao 接口
 *
 * @author 
 */
public interface ShangpinBangfushenqingDao extends BaseMapper<ShangpinBangfushenqingEntity> {

   List<ShangpinBangfushenqingView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
