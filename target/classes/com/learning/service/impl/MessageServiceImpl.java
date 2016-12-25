package com.learning.service.impl;

import com.learning.common.util.UuidUtil;
import com.learning.domain.MessageDomain;
import com.learning.persistence.MessageDomainMapper;
import com.learning.service.IMessageService;
import com.learning.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * Created by lw on 16-12-22.
 */
@Service
public class MessageServiceImpl implements IMessageService {
    @Autowired
    private MessageDomainMapper messageDomainMapper;

    @Transactional
    public void storeSingleMessage(MessageVo messageVo) {
        System.out.println("fdsfd" + messageVo.getContent() +" " + messageVo.getSender() + "  " + messageVo.getReceiver());
        MessageDomain messageDomain = new MessageDomain();
        messageDomain.setUuid(UuidUtil.getUuid());
        messageDomain.setContent(messageVo.getContent());
        messageDomain.setSender(messageVo.getSender());
        messageDomain.setReceiver(messageVo.getReceiver());
        messageDomain.setSend(0);
        messageDomain.setHasread(1);
        messageDomainMapper.insertSelective(messageDomain);
        messageDomain.setSender(messageVo.getReceiver());
        messageDomain.setReceiver(messageVo.getSender());
        messageDomain.setSend(1);
        messageDomainMapper.insertSelective(messageDomain);
    }

}
