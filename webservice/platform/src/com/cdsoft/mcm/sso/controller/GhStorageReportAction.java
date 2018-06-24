package com.cdsoft.mcm.sso.controller;

import com.cdsoft.mcm.sso.pojo.FgsReportRow;
import com.cdsoft.mcm.sso.service.IGhStorageReportService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 供耗存报表查询控制层，为移动端提供相应报表的查询服务
 */


@Controller
@RequestMapping("android/getGhStorageReport")
public class GhStorageReportAction {
    private static final Logger logger = Logger.getLogger(GhStorageReportAction.class);
    @Resource
    private IGhStorageReportService ghStorageReportService;

    /**
     * 查询供耗存报表
     *
     * @return 返回验证结果
     */
    @RequestMapping("queryReport")
    @ResponseBody
    public List<FgsReportRow> queryReport(HttpServletRequest request) {
        //查询参数
        String dateStr = request.getParameter("dateStr");
        //List<FgsReportRow> resultList = ghStorageReportService.queryFgsRkReport(dateStr);
        List<FgsReportRow> resultList = ghStorageReportService.queryFgsGhReport(dateStr);
        return resultList;
    }
}