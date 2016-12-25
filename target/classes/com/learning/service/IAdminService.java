package com.learning.service;

import com.learning.bean.Resp;
import com.learning.domain.AdminDomain;
import com.learning.vo.AdminListVo;

import java.util.List;

/**
 *
 * Created by lw on 16-12-19.
 */
public interface IAdminService {
    List<AdminListVo> adminList();

    Resp addAdmin(AdminDomain adminDomain);

    Resp update(AdminDomain adminDomain);

    Resp deleteById(Integer id);
}
