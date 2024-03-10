package com.rocs.chatbi.manager;

import com.rocs.chatbi.common.ErrorCode;
import com.rocs.chatbi.exception.BusinessException;
import com.yupi.yucongming.dev.client.YuCongMingClient;
import com.yupi.yucongming.dev.common.BaseResponse;
import com.yupi.yucongming.dev.model.DevChatRequest;
import com.yupi.yucongming.dev.model.DevChatResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AiManager {

    @Resource
    private YuCongMingClient yuCongMingClient;

    /**
     * 调用AI接口进行对话
     *
     * @param question
     * @return
     */
    public String doChat(String question) {
        DevChatRequest devChatRequest = new DevChatRequest();
        devChatRequest.setModelId(1766891838285238274L);
        devChatRequest.setMessage(question);

        BaseResponse<DevChatResponse> response = yuCongMingClient.doChat(devChatRequest);

        if (response == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "AI接口调用失败");
        }

        return response.getData().getContent();
    }
}
