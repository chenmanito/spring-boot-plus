package io.geekidea.springbootplus.system.web.param;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import io.geekidea.springbootplus.common.web.param.QueryParam;

/**
 * <p>
 * 用户表 查询参数对象
 * </p>
 *
 * @author chenpengfei
 * @date 2019-08-09
 */
@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="SysUserQueryParam对象", description="用户表查询参数")
public class SysUserQueryParam extends QueryParam {
    private static final long serialVersionUID = 1L;
}
