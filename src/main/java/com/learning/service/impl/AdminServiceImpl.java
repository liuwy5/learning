package com.learning.service.impl;

import com.learning.bean.Resp;
import com.learning.common.enums.RespStatusEnum;
import com.learning.common.util.TimeUtil;
import com.learning.common.util.UuidUtil;
import com.learning.domain.AdminDomain;
import com.learning.persistence.AdminDomainMapper;
import com.learning.service.IAdminService;
import com.learning.vo.AdminListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 *
 * Created by lw on 16-12-19.
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private AdminDomainMapper adminDomainMapper;

    public List<AdminListVo> adminList() {
        return adminDomainMapper.selectAll();
    }

    public AdminDomain adminDetail(Integer id) {
        AdminDomain adminDomain = adminDomainMapper.selectByPrimaryKey(id);
        return adminDomain;
    }

    @Transactional
    public Resp addAdmin(AdminDomain adminDomain) {
        AdminDomain adminDomainUnit = new AdminDomain();
        adminDomain.setLoginName(adminDomain.getLoginName());

        AdminDomain adminDomain1 = adminDomainMapper.selectOne(adminDomainUnit);
        if (adminDomain1 != null) {
            return new Resp(RespStatusEnum.RESP_FAIL.getCode(), "该用户名已存在");
        } else {
            adminDomain.setUuid(UuidUtil.getUuid());
            adminDomain.setCreatedAt(TimeUtil.getDateNow());
            adminDomainMapper.insert(adminDomain);
            return new Resp(RespStatusEnum.RESP_SUCCESS.getCode(), "添加成功");
        }
    }

    @Transactional
    public Resp update(AdminDomain adminDomain) {
        AdminDomain adminDomainUnit = adminDomainMapper.selectByPrimaryKey(adminDomain.getId());
        if (adminDomainUnit == null) {
            return new Resp(RespStatusEnum.RESP_FAIL.getCode(), "该账号不存在");
        } else {
            adminDomainMapper.updateByPrimaryKeySelective(adminDomain);
            return new Resp(RespStatusEnum.RESP_SUCCESS.getCode(), "修改成功");
        }

    }

    @Transactional
    public Resp deleteById(Integer id) {
        AdminDomain adminDomain = adminDomainMapper.selectByPrimaryKey(id);
        if (adminDomain == null) {
            return new Resp(RespStatusEnum.RESP_FAIL.getCode(), "该账号不存在");
        } else {
            adminDomainMapper.deleteByPrimaryKey(id);
            return new Resp(RespStatusEnum.RESP_SUCCESS.getCode(), "删除成功");
        }
    }
}
