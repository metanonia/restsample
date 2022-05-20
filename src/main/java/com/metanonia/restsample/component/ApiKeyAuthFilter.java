package com.metanonia.restsample.component;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Slf4j
@Component
public class ApiKeyAuthFilter extends AbstractPreAuthenticatedProcessingFilter {
    private String API_KEY_AUTH_HEADER_NAME = "X-APIKEY";
    private String SIGN_HEADER_NAME = "X-SIGN";

    @Autowired
    public ApiKeyAuthFilter(ApiKeyAuthManager manager) {
        this.setAuthenticationManager(manager);
    }

    @SneakyThrows
    @Override
    protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
        return request.getHeader(API_KEY_AUTH_HEADER_NAME);
        /*
        String apikey = request.getHeader(API_KEY_AUTH_HEADER_NAME);
        String query = request.getQueryString();
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("apikey", apikey);
        jsonObject.put("query", query);

        String body = null;
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            InputStream inputStream = request.getInputStream();
            if(inputStream != null) {
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                char[] charBuffer = new char[128];
                int byteRead = -1;
                while ((byteRead = bufferedReader.read(charBuffer)) > 0) {
                    stringBuilder.append(charBuffer, 0, byteRead);
                }
            }
        }
        catch (IOException e) {
            log.info(e.toString());
            throw e;
        }
        finally {
            if(bufferedReader != null) {
                try {
                    bufferedReader.close();
                }
                catch (IOException ex) {
                    throw ex;
                }
            }
        }
        body = stringBuilder.toString();
        jsonObject.put("body", body);

        return jsonObject;
         */
    }

    @Override
    protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
        return request.getHeader(SIGN_HEADER_NAME);
    }

}
