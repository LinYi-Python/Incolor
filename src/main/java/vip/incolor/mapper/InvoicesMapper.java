package vip.incolor.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import vip.incolor.entity.Invoices;
import vip.incolor.entity.InvoicesExample;
@Mapper
@Repository
public interface InvoicesMapper {
    int deleteByPrimaryKey(Integer invoices_id);

    int insert(Invoices record);

    int insertSelective(Invoices record);

    List<Invoices> selectByExample(InvoicesExample example);

    Invoices selectByPrimaryKey(Integer invoices_id);

    int updateByPrimaryKeySelective(Invoices record);

    int updateByPrimaryKey(Invoices record);
}