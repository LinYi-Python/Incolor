package vip.incolor.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;


/**
 * @author: JimLin
 * @description: 查询条件
 * @email leafyunjim@gmail.com
 * @date: 2018-04-08
 * @time: 23:30
 */
public class SearchCondition {

    @NotNull(message = "{NotNull.startTime}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @NotNull(message = "{NotNull.endTime}")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    public SearchCondition() {
    }

    public SearchCondition(Date startTime, Date endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "SearchCondition{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
