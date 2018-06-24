package com.cdsoft.mcm.sso.service;

import com.cdsoft.mcm.sso.pojo.FgsReportRow;

import java.util.List;

/**
 * 供耗存报表查询服务
 */
public interface IGhStorageReportService {

    /**
     * 查询分公司报表(入库)
     * @param dateString 日期字符串 2018-03-01
     * @return 报表记录
     */
    List<FgsReportRow> queryFgsRkReport(String dateString);

    /**
     * 查询分公司报表(过衡)
     * @param dateString 日期字符串 2018-03-01
     * @return 报表记录
     */
    List<FgsReportRow> queryFgsGhReport(String dateString);
}
