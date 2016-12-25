package com.learning.service;

import com.learning.bean.Resp;
import com.learning.domain.RoleDomain;
import com.learning.vo.RoleVo;

import java.util.List;

/**
 *
 * Created by lw on 16-12-19.
 */
public interface IRoleService {
    List<RoleDomain> roleList();

    Resp addRole(RoleVo roleVo);

    Resp update(RoleVo roleVo);

    Resp deleteById(Integer id);
}
