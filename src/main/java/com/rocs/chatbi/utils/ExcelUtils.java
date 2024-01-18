package com.rocs.chatbi.utils;

import cn.hutool.core.collection.CollUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Excel 工具类
 */
@Slf4j
public class ExcelUtils {

    public static String excelToCsv (MultipartFile multipartFile) {
        // 读取数据
        List<Map<Integer, String>> list = null;
        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            log.error("Excel 文件处理失败", e);
            e.printStackTrace();
        }
        if (CollUtil.isEmpty(list)) {
            return "";
        }

        // 转换为 CSV
        StringBuffer stringBuffer = new StringBuffer();
        // 读取表头
        LinkedHashMap<Integer, String> headMap = (LinkedHashMap) list.get(0);
        List<String> headList = headMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
        stringBuffer.append(StringUtils.join(headList, ",")).append("\n");
        // 读取数据
        for (int i = 1; i < list.size(); i++) {
            LinkedHashMap<Integer, String> dataMap = (LinkedHashMap) list.get(i);
            List<String> dataList = dataMap.values().stream().filter(ObjectUtils::isNotEmpty).collect(Collectors.toList());
            stringBuffer.append(StringUtils.join(dataList, ",")).append("\n");
        }
        return stringBuffer.toString();
    }
}
