package jp.co.itfllc.employeesofitf.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TestUtils {
    /**
     * MockMvc
     */
    @Autowired
    MockMvc mvc;

    /**
     * POSTリクエスト
     *
     * @param <T> レスポンスの型
     * @param url リクエストURL
     * @param body リクエストボディー
     * @param headers リクエストヘッダー
     * @param resultMatcher 期待するHTTPステータス
     * @return リクエストレスポンス
     * @throws Exception 例外
     */
    public <T> T postUtil(String url, Object body, Map<String, String> headers, ResultMatcher resultMatcher) throws Exception {
        return this.postUtil(url, body, headers, resultMatcher, null);
    }

    /**
     * POSTリクエスト
     *
     * @param <T> レスポンスの型
     * @param url リクエストURL
     * @param body リクエストボディー
     * @param headers リクエストヘッダー
     * @param resultMatcher 期待するHTTPステータス
     * @param valueType レスポンスの型
     * @return リクエストレスポンス
     * @throws Exception 例外
     */
    public <T> T postUtil(String url, Object body, Map<String, String> headers, ResultMatcher resultMatcher,
            Class<T> valueType) throws Exception {
        var objectMapper = new ObjectMapper();
        MockHttpServletRequestBuilder builder = post(url);

        if (body != null) {
            String content = objectMapper.writeValueAsString(body);
            builder = builder.content(content);
        }

        if (headers != null) {
            for (Map.Entry<String, String> header : headers.entrySet()) {
                builder = builder.header(header.getKey(), header.getValue());
            }
        }

        builder = builder.contentType(MediaType.APPLICATION_JSON_VALUE);

        MvcResult result = this.mvc.perform(builder).andExpect(resultMatcher).andReturn();

        if (valueType == null) {
            return null;
        }

        var response = objectMapper.readValue(result.getResponse().getContentAsString(), valueType);

        return response;
    }
}
