package com.plumblossom.videotrans.consumer;

import com.alibaba.fastjson.JSON;
import com.plumblossom.videotrans.config.RabbitmqConfig;
import com.plumblossom.videotrans.video.common.CommonConstValue;
import com.plumblossom.videotrans.video.factory.M3U8VideoTransFactory;
import com.plumblossom.videotrans.video.factory.VideoTrans;
import com.plumblossom.videotrans.video.factory.VideoTransFactory;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description: Rabbitmq 消息队列处理的消费者端
 * @Date: 2020/10/9 10:27
 * @Version: 1.0
 */

@Component
public class M3U8VideoProcessHandler {

    private static final Logger log = LoggerFactory.getLogger(M3U8VideoProcessHandler.class);

    private static final String FILE_SUFFIX = ".m3u8";

    @RabbitListener(queues = {RabbitmqConfig.QUEUE_M3U8_H264_FLUENT},containerFactory = "customContainerFactory")
    public void receivedM3U8H264FluentProcessTask(String msg, Message message, Channel channel){
        // 记录提交转码视频请求
        log.info("[M3U8] [h264] [fluent] [command]:" + msg);
        Map params = JSON.parseObject(msg, Map.class);
        VideoTransFactory videoTransFactory = new M3U8VideoTransFactory();
        VideoTrans videoTrans = videoTransFactory.getH264VideoTrans();

        // 生成新的转码视频目录
        String storage_path = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);
        String h264Path = storage_path + "M3U8"+File.separator + "H264" + File.separatorChar;
        String newFileName = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME) + FILE_SUFFIX;
        String fluentPath = h264Path +"fluent" +File.separator;
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, newFileName);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH,fluentPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, fluentPath + newFileName);

        String result = videoTrans.fluentTrans(params);
        // 记录结果
        log.info(msg + "["+result+"]");
    }



    @RabbitListener(queues = {RabbitmqConfig.QUEUE_M3U8_H264_HD},containerFactory = "customContainerFactory")
    public void receivedM3U8H264HDProcessTask(String msg, Message message, Channel channel) {
        // 记录提交转码视频请求
        log.info("[M3U8] [h264] [hd] [command]:" + msg);
        Map params = JSON.parseObject(msg, Map.class);
        VideoTransFactory videoTransFactory = new M3U8VideoTransFactory();
        VideoTrans videoTrans = videoTransFactory.getH264VideoTrans();

        // 生成新的转码视频目录
        String storage_path = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);
        String h264Path = storage_path + "M3U8" + File.separator + "H264" + File.separatorChar;
        String newFileName = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME) + FILE_SUFFIX;
        String hdPath = h264Path + "hd" + File.separator;
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, newFileName);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH, hdPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, hdPath + newFileName);
        String result = videoTrans.hdTrans(params);
        // 记录结果
        log.info(msg + "[" + result + "]");

    }



    @RabbitListener(queues = {RabbitmqConfig.QUEUE_M3U8_H264_HQ},containerFactory = "customContainerFactory")
    public void receivedM3U8H264HQProcessTask(String msg, Message message, Channel channel) {
        // 记录提交转码视频请求
        log.info("[M3U8] [h264] [hq] [command]:" + msg);
        Map params = JSON.parseObject(msg, Map.class);
        VideoTransFactory videoTransFactory = new M3U8VideoTransFactory();
        VideoTrans videoTrans = videoTransFactory.getH264VideoTrans();

        // 生成新的转码视频目录
        String storage_path = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);
        String h264Path = storage_path + "M3U8" + File.separator + "H264" + File.separatorChar;
        String newFileName = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME) + FILE_SUFFIX;
        String hqPath = h264Path + "hq" + File.separator;
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, newFileName);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH, hqPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, hqPath + newFileName);
        String result = videoTrans.hqTrans(params);
        // 记录结果
        log.info(msg + "[" + result + "]");

    }




    @RabbitListener(queues = {RabbitmqConfig.QUEUE_M3U8_H265_FLUENT},containerFactory = "customContainerFactory")
    public void receivedM3U8H265FluentProcessTask(String msg, Message message, Channel channel){
        // 记录提交转码视频请求
        log.info("[M3U8] [h265] [fluent] [command]:" + msg);
        Map params = JSON.parseObject(msg, Map.class);
        VideoTransFactory videoTransFactory = new M3U8VideoTransFactory();
        VideoTrans videoTrans = videoTransFactory.getH265VideoTrans();

        // 生成新的转码视频目录
        String storage_path = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);
        String h265Path = storage_path + "M3U8"+File.separator + "H265" + File.separatorChar;
        String newFileName = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME) + FILE_SUFFIX;
        String fluentPath = h265Path +"fluent" +File.separator;
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, newFileName);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH,fluentPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, fluentPath + newFileName);

        String result = videoTrans.fluentTrans(params);
        // 记录结果
        log.info(msg + "["+result+"]");
    }



    @RabbitListener(queues = {RabbitmqConfig.QUEUE_M3U8_H265_HD},containerFactory = "customContainerFactory")
    public void receivedM3U8H265HDProcessTask(String msg, Message message, Channel channel) {
        // 记录提交转码视频请求
        log.info("[M3U8] [h265] [hd] [command]:" + msg);
        Map params = JSON.parseObject(msg, Map.class);
        VideoTransFactory videoTransFactory = new M3U8VideoTransFactory();
        VideoTrans videoTrans = videoTransFactory.getH265VideoTrans();

        // 生成新的转码视频目录
        String storage_path = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);
        String h265Path = storage_path + "M3U8" + File.separator + "H265" + File.separatorChar;
        String newFileName = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME) + FILE_SUFFIX;
        String hdPath = h265Path + "hd" + File.separator;
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, newFileName);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH, hdPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, hdPath + newFileName);
        String result = videoTrans.hdTrans(params);
        // 记录结果
        log.info(msg + "[" + result + "]");

    }



    @RabbitListener(queues = {RabbitmqConfig.QUEUE_M3U8_H265_HQ},containerFactory = "customContainerFactory")
    public void receivedM3U8H265HQProcessTask(String msg, Message message, Channel channel) {
        // 记录提交转码视频请求
        log.info("[M3U8] [h265] [hq] [command]:" + msg);
        Map params = JSON.parseObject(msg, Map.class);
        VideoTransFactory videoTransFactory = new M3U8VideoTransFactory();
        VideoTrans videoTrans = videoTransFactory.getH265VideoTrans();

        // 生成新的转码视频目录
        String storage_path = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);
        String h265Path = storage_path + "M3U8" + File.separator + "H265" + File.separatorChar;
        String newFileName = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME) + FILE_SUFFIX;
        String hqPath = h265Path + "hq" + File.separator;
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, newFileName);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH, hqPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, hqPath + newFileName);
        String result = videoTrans.hqTrans(params);
        // 记录结果
        log.info(msg + "[" + result + "]");
    }


}
