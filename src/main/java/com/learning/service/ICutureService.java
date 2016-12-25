package com.learning.service;

import com.learning.bean.Resp;
import com.learning.domain.CultureDomain;

import java.util.List;

/**
 *
 * Created by lw on 16-12-19.
 */
public interface ICutureService {
    List<CultureDomain> cultureList();

    Resp addCulture(CultureDomain cultureDomain);

    Resp update(CultureDomain cultureDomain);

    Resp deleteById(Integer id);
}
