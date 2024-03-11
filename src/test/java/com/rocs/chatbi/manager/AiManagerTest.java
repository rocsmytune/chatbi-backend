package com.rocs.chatbi.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AiManagerTest {

    @Resource
    private AiManager aiManager;

    @Test
    void doChat() {
        String res = aiManager.doChat("分析需求：\n" +
                "分析网站用户增长情况\n" +
                "原始数据：\n" +
                "日期,用户数\n" +
                "1,24\n" +
                "2,45\n" +
                "3,120\n" +
                "4,140", 1766891838285238274L);
        System.out.println(res);
    }
}