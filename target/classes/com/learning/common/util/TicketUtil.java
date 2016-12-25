package com.learning.common.util;

import com.learning.bean.Ticket;

import javax.servlet.http.HttpSession;

/**
 *
 * Created by lw on 16-12-21.
 */
public class TicketUtil {
    public static Ticket getTicket(HttpSession httpSession) {
        Ticket ticket = null;
        Object object = httpSession.getAttribute("ticket");
        if (object != null) {
            ticket = (Ticket)object;
        }
        return ticket;
    }

    public static String getLoginName(HttpSession httpSession) {
        String loginName = null;
        Ticket ticket = getTicket(httpSession);
        if (ticket != null) {
            loginName = ticket.getLoginName();
        }
        return loginName;
    }
}
