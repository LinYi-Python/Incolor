package vip.incolor.service;

import vip.incolor.dto.MultiInvoices;

import javax.servlet.http.HttpSession;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/23
 * @time 20:05
 */
public interface InvoicesService {
    MultiInvoices getInvoices(HttpSession session);
    void addInvoices(HttpSession session,MultiInvoices multiInvoices);
    void modifyInvoices(HttpSession session,MultiInvoices multiInvoices);
}
