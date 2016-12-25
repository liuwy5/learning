package com.learning.controller.socket;

import com.learning.bean.Ticket;
import com.learning.common.util.JsonUtil;
import com.learning.common.util.TimeUtil;
import com.learning.config.GetHttpSessionConfigurator;
import com.learning.service.IMessageService;
import com.learning.service.impl.MessageServiceImpl;
import com.learning.vo.MessageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.SpringConfigurator;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 *
 * Created by lw on 16-12-16.
 */
@ServerEndpoint(value = "/webSocket", configurator = GetHttpSessionConfigurator.class)
@Component
public class MyWebSocket {

//    @Autowired
//    private IMessageService messageService;

//    @Resource
//    private IMessageService messageService = (IMessageService) ContextLoader.getCurrentWebApplicationContext().getBean("messageService");

    // TODO: 设计为线程安全的
    private static int onlineCount = 0;

    // 线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<MyWebSocket> webSocketSet = new CopyOnWriteArraySet<MyWebSocket>();

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    private String loginName;

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        this.session = session;
        webSocketSet.add(this);
        addOnlineCount();
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
        HttpSession httpSession = (HttpSession) config.getUserProperties().get(HttpSession.class.getName());
        Ticket ticket = (Ticket) httpSession.getAttribute("ticket");
        if (ticket != null) {
            this.loginName = ticket.getLoginName();
        }

//        try {
//            sendMessage("有新连接加入！当前在线人数为" + getOnlineCount());
//        } catch (IOException e) {
//            System.out.println("IO异常");
//        }
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        subOnlineCount();
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        MessageVo messageVo = (MessageVo) JsonUtil.jsonToObject(message, MessageVo.class);
        messageVo.setSender(this.loginName);

//        ApplicationContext ac = new FileSystemXmlApplicationContext("/spring/spring.xml");
//        IMessageService messageService = (IMessageService) ac.getBean("messageService");

        IMessageService messageService = null;

                // 存储消息
        System.out.println(" =========" + (messageService == null));
        if (messageService != null) {
            messageService.storeSingleMessage(messageVo);
        }

        // 发给消息接收方
        messageVo.setSelf(false);
        for (MyWebSocket webSocket : webSocketSet) {
            try {
                if (messageVo.getReceiver().equals(webSocket.loginName)) {
                    webSocket.sendMessage(messageVo);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    private void sendMessage(String message) throws IOException {
        MessageVo messageVo = new MessageVo();
        messageVo.setContent(message);
        messageVo.setSelf(true);
        messageVo.setDate(TimeUtil.getDate("yyyy-MM-dd HH:mm:ss"));
        String messageJson = JsonUtil.toJsonString(messageVo);
        this.session.getBasicRemote().sendText(messageJson);
    }

    private void sendMessage(MessageVo message) throws IOException {
        if (message.getDate() == null) {
            message.setDate(TimeUtil.getDate("yyyy-MM-dd HH:mm:ss"));
        }

        String messageJson = JsonUtil.toJsonString(message);
        this.session.getBasicRemote().sendText(messageJson);
    }

    public static void sendGroupMessage(String message) {
        //群发消息
        for (MyWebSocket item : webSocketSet) {
            try {
                item.sendMessage("来自服务器的消息： " + message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        MyWebSocket.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        MyWebSocket.onlineCount--;
    }
}
