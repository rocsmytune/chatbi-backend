//package com.rocs.chatbi.api;
//
///**
// * Open AI 对话示例
// */
//public class CreateChatCompletionResponse createChatCompletion(CreateChatCompletionRequest requset, String openAiApiKey) {
//    if (StringUtils.isBlank(openAiApiKey)) {
//        throw new BusinessException(ErrorCode.PARAMS_ERROR, "OpenAI API Key 未配置");
//    }
//
//    String url = "https://api.openai.com/v1/chat/completions";
//    String json = JSONUtil.toJsonStr(requset);
//    String result = HttpRequest.post(url)
//            .header("Authorization", "Bearer " + openAiApiKey)
//            .body(json)
//            .execute()
//            .body();
//
//    return JSONUtil.toBean(result, CreateChatCompletionResponse.class);
//}
