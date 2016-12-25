package com.learning.service.impl;

import com.learning.bean.Resp;
import com.learning.common.enums.RespStatusEnum;
import com.learning.common.util.TimeUtil;
import com.learning.common.util.UuidUtil;
import com.learning.domain.CultureDomain;
import com.learning.persistence.CultureDomainMapper;
import com.learning.service.ICutureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * Created by lw on 16-12-19.
 */
@Service
public class CutureServiceImpl implements ICutureService{
    @Autowired
    private CultureDomainMapper cultureDomainMapper;

    public List<CultureDomain> cultureList() {
        return cultureDomainMapper.selectAll();
    }

    @Transactional
    public Resp addCulture(CultureDomain cultureDomain) {
        cultureDomain.setUuid(UuidUtil.getUuid());
        cultureDomain.setCreatedAt(TimeUtil.getDateNow());
        cultureDomainMapper.insert(cultureDomain);
        return new Resp(RespStatusEnum.RESP_SUCCESS.getCode(), "添加成功");
    }

    public Resp update(CultureDomain cultureDomain) {
        CultureDomain cultureDomain1 = cultureDomainMapper.selectByPrimaryKey(cultureDomain.getId());
        if (cultureDomain1 == null) {
            return new Resp(RespStatusEnum.RESP_FAIL.getCode(), "该文化内容不存在");
        } else {
            cultureDomainMapper.updateByPrimaryKey(cultureDomain);
            return new Resp(RespStatusEnum.RESP_SUCCESS.getCode(), "修改成功");
        }
    }

    public Resp deleteById(Integer id) {
        CultureDomain cultureDomain = cultureDomainMapper.selectByPrimaryKey(id);
        if (cultureDomain == null) {
            return new Resp(RespStatusEnum.RESP_FAIL.getCode(), "该文化内容不存在");
        } else {
            cultureDomainMapper.deleteByPrimaryKey(id);
            return new Resp(RespStatusEnum.RESP_SUCCESS.getCode(), "删除成功");
        }
    }
}
