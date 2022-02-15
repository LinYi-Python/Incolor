package vip.incolor.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.HtmlUtils;
import vip.incolor.dto.MultiInvoices;
import vip.incolor.entity.Invoices;
import vip.incolor.entity.InvoicesExample;
import vip.incolor.exception.ServerInternalException;
import vip.incolor.exception.WrongInputException;
import vip.incolor.mapper.InvoicesMapper;
import vip.incolor.service.InvoicesService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author LiYizhan
 * @email 1062585732@qq.com
 * @description
 * @date 2018/4/23
 * @time 20:05
 */
@Service
public class InvoicesServiceImpl implements InvoicesService {

    private InvoicesMapper invoicesMapper;

    @Autowired
    public InvoicesServiceImpl(InvoicesMapper invoicesMapper) {
        super();
        this.invoicesMapper=invoicesMapper;
    }

    @Override
    public MultiInvoices getInvoices(HttpSession session) {
        int userId=(Integer)session.getAttribute("user_id");
        List<Invoices> list=getInvoicesList(userId);
        if(!list.isEmpty()){
            Invoices invoices=list.get(0);
            MultiInvoices multiInvoices=new MultiInvoices();
            multiInvoices.setPersonalName(invoices.getInvoices_personal_name());
            multiInvoices.setCompanyName(invoices.getInvoices_company_name());
            multiInvoices.setCode(invoices.getInvoices_company_number());
            return multiInvoices;
        }else {
            return null;
        }
    }

    @Override
    @Transactional
    public void addInvoices(HttpSession session, MultiInvoices multiInvoices) {
        try {
            int userId=(Integer)session.getAttribute("user_id");
            List<Invoices> list=getInvoicesList(userId);
            if(!list.isEmpty()){
                modify(list.get(0),multiInvoices);
            }else{
                String personalName=multiInvoices.getPersonalName();
                String companyName=multiInvoices.getCompanyName();
                String code=multiInvoices.getCode();
                Invoices invoices=new Invoices();
                invoices.setUser_id(userId);
                if(personalName!=null){
                    personalName= HtmlUtils.htmlEscape(personalName);
                    invoices.setInvoices_personal_name(personalName);
                    invoicesMapper.insert(invoices);
                }else if(companyName!=null&&code!=null){
                    companyName=HtmlUtils.htmlEscape(companyName);
                    code=HtmlUtils.htmlEscape(code);
                    invoices.setInvoices_company_name(companyName);
                    invoices.setInvoices_company_number(code);
                    invoicesMapper.insert(invoices);
                }else{
                    throw new WrongInputException();
                }
            }
        } catch (WrongInputException e) {
            throw e;
        } catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void modifyInvoices(HttpSession session, MultiInvoices multiInvoices) {
        try {
            int userId=(Integer)session.getAttribute("user_id");
            List<Invoices> list=getInvoicesList(userId);
            if(!list.isEmpty()){
                modify(list.get(0),multiInvoices);
            }
        } catch (WrongInputException e) {
            throw e;
        } catch (Exception e){
            throw new ServerInternalException(e.getMessage());
        }
    }

    private List<Invoices> getInvoicesList(int userId){
        InvoicesExample example=new InvoicesExample();
        example.createCriteria().andUser_idEqualTo(userId);
        return invoicesMapper.selectByExample(example);
    }


    private void modify(Invoices invoices,MultiInvoices multiInvoices){
        String personalName=multiInvoices.getPersonalName();
        String companyName=multiInvoices.getCompanyName();
        String code=multiInvoices.getCode();
        if(personalName!=null){
            personalName= HtmlUtils.htmlEscape(personalName);
            invoices.setInvoices_personal_name(personalName);
            invoicesMapper.updateByPrimaryKey(invoices);
        }else if(companyName!=null&&code!=null){
            companyName=HtmlUtils.htmlEscape(companyName);
            code=HtmlUtils.htmlEscape(code);
            invoices.setInvoices_company_name(companyName);
            invoices.setInvoices_company_number(code);
            invoicesMapper.updateByPrimaryKey(invoices);
        }else{
            throw new WrongInputException();
        }
    }
}
