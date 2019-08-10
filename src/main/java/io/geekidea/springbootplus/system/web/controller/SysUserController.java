package io.geekidea.springbootplus.system.web.controller;

import io.geekidea.springbootplus.system.entity.SysUser;
import io.geekidea.springbootplus.system.service.SysUserService;
import io.geekidea.springbootplus.system.web.param.SysUserQueryParam;
import io.geekidea.springbootplus.system.web.vo.SysUserQueryVo;
import io.geekidea.springbootplus.common.web.controller.BaseController;
import io.geekidea.springbootplus.common.api.ApiResult;
    import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import io.geekidea.springbootplus.common.web.vo.Paging;
import io.geekidea.springbootplus.common.web.param.IdParam;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author chenpengfei
 * @since 2019-08-09
 */
@Slf4j
@RestController
@RequestMapping("/sysUser")
@Api("用户表 API")
public class SysUserController extends BaseController {

    @Autowired
    private SysUserService sysUserService;

    /**
    * 添加用户表
    */
    @PostMapping("/add")
    @ApiOperation(value = "添加SysUser对象",notes = "添加用户表",response = ApiResult.class)
    public ApiResult<Boolean> addSysUser(@Valid @RequestBody SysUser sysUser) throws Exception{
        boolean flag = sysUserService.save(sysUser);
        return ApiResult.result(flag);
    }

    /**
    * 修改用户表
    */
    @PostMapping("/update")
    @ApiOperation(value = "修改SysUser对象",notes = "修改用户表",response = ApiResult.class)
    public ApiResult<Boolean> updateSysUser(@Valid @RequestBody SysUser sysUser) throws Exception{
        boolean flag = sysUserService.updateById(sysUser);
        return ApiResult.result(flag);
    }

    /**
    * 删除用户表
    */
    @PostMapping("/delete")
    @ApiOperation(value = "删除SysUser对象",notes = "删除用户表",response = ApiResult.class)
    public ApiResult<Boolean> deleteSysUser(@Valid @RequestBody IdParam idParam) throws Exception{
        boolean flag = sysUserService.removeById(idParam.getId());
        return ApiResult.result(flag);
    }

    /**
    * 获取用户表
    */
    @PostMapping("/info")
    @ApiOperation(value = "获取SysUser对象详情",notes = "查看用户表",response = SysUserQueryVo.class)
    public ApiResult<SysUserQueryVo> getSysUser(@Valid @RequestBody IdParam idParam) throws Exception{
        SysUserQueryVo sysUserQueryVo = sysUserService.getSysUserById(idParam.getId());
        return ApiResult.ok(sysUserQueryVo);
    }

    /**
     * 用户表分页列表
     */
    @PostMapping("/getPageList")
    @ApiOperation(value = "获取SysUser分页列表",notes = "用户表分页列表",response = SysUserQueryVo.class)
    public ApiResult<Paging<SysUserQueryVo>> getSysUserPageList(@Valid @RequestBody(required = false) SysUserQueryParam sysUserQueryParam) throws Exception{
        Paging<SysUserQueryVo> paging = sysUserService.getSysUserPageList(sysUserQueryParam);
        return ApiResult.ok(paging);
    }

}

