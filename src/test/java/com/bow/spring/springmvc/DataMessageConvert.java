package com.bow.spring.springmvc;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vv
 * @since 2017/2/3.
 */
public class DataMessageConvert extends AbstractHttpMessageConverter<Object> {

    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(RequestData.class);
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(ResponseData.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return Collections.singletonList(MediaType.ALL);
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Map.class);
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage)
            throws IOException, HttpMessageNotReadableException {
        Charset cs = Charset.forName("UTF-8");
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = inputMessage.getBody();
        byte[] b = new byte[1024];
        int length;
        while ((length = inputStream.read(b)) != -1) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(length);
            byteBuffer.put(b, 0, length);
            byteBuffer.flip();
            stringBuilder.append(cs.decode(byteBuffer).array());
        }
        String[] list = stringBuilder.toString().split(";");
        Map<String, String> map = new HashMap(list.length);
        for (String entry : list) {
            String[] keyValue = entry.split(",");
            map.put(keyValue[0], keyValue[1]);
        }
        RequestData requestData = new RequestData();
        requestData.setData(map);
        return requestData;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage)
            throws IOException, HttpMessageNotWritableException {
        StringBuilder stringBuilder = new StringBuilder();
        Map<String, String> map = ((ResponseData) o).getData();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            stringBuilder.append(entry.getKey()).append(",").append(entry.getValue()).append(";");
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        outputMessage.getBody().write(stringBuilder.toString().getBytes());

    }
}
