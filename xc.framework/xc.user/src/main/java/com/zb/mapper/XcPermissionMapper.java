package com.zb.mapper;

import com.zb.pojo.XcPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface XcPermissionMapper {

	public XcPermission getXcPermissionById(@Param(value = "id") Long id)throws Exception;

	public List<XcPermission>	getXcPermissionListByMap(Map<String, Object> param)throws Exception;

	public Integer getXcPermissionCountByMap(Map<String, Object> param)throws Exception;

	public Integer insertXcPermission(XcPermission xcPermission)throws Exception;

	public Integer updateXcPermission(XcPermission xcPermission)throws Exception;

	public Integer deleteXcPermissionById(@Param(value = "id") Long id)throws Exception;

	public Integer batchDeleteXcPermission(Map<String, List<String>> params);

}
