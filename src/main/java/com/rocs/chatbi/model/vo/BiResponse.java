package com.rocs.chatbi.model.vo;

import lombok.Data;

/**
 * BI 返回的结果
 */
@Data
public class BiResponse {
    private String genChart;

    private String genResult;

    private Long chatId;
}
