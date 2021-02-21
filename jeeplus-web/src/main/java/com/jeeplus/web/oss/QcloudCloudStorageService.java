package com.jeeplus.web.oss;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jeeplus.web.common.exception.RRException;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.request.UploadFileRequest;
import com.qcloud.cos.sign.Credentials;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * 腾讯云存储
 * @author:yuzp17311
 * @version:v1.0
 * @date: 2017-03-30 15:00.
 */
public class QcloudCloudStorageService extends CloudStorageService {

    private COSClient client;

    public QcloudCloudStorageService(CloudStorageConfig config) {
        this.config=config;
        init();
    }

    private void init(){
        Credentials credentials = new Credentials(config.getQcloudAppId(), config.getQcloudSecretId(),
                config.getQcloudSecretKey());

        //初始化客户端配置

        ClientConfig clientConfig = new ClientConfig();
        //设置bucket所在的区域，比如华南园区：gz 华北园区：tj 华东园区：sh

        clientConfig.setRegion(config.getQcloudRegion());

        client = new COSClient(clientConfig, credentials);
    }

    @Override
    public String upload(byte[] data, String path) {
        //腾讯云必需要以"/"开头

        if(!path.startsWith("/")) {
            path = "/" + path;
        }

        //上传到腾讯云

        UploadFileRequest request = new UploadFileRequest(config.getQcloudBucketName(), path, data);
        String response = client.uploadFile(request);

        JSONObject jsonObject = JSON.parseObject(response);
        if(jsonObject.getIntValue("code") != 0) {
            throw new RRException("文件上传失败，" + jsonObject.getString("message"));
        }

        return config.getQcloudDomain() + path;
    }

    @Override
    public String upload(InputStream inputStream, String path) {
        try {
            byte[] data = IOUtils.toByteArray(inputStream);
            return this.upload(data, path);
        } catch (IOException e) {
            throw new RRException("上传文件失败", e);
        }
    }

    @Override
    public String upload(byte[] data) {
        return upload(data, getPath(config.getQcloudPrefix()));
    }

    @Override
    public String upload(InputStream inputStream) {
        return upload(inputStream, getPath(config.getQcloudPrefix()));
    }

}
