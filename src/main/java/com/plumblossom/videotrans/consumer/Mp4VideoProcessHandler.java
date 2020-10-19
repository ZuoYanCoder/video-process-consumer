package com.plumblossom.videotrans.consumer;

import com.alibaba.fastjson.JSON;
import com.plumblossom.videotrans.config.RabbitmqConfig;
import com.plumblossom.videotrans.video.common.CommonConstValue;
import com.plumblossom.videotrans.video.factory.MP4VideoTransFactory;
import com.plumblossom.videotrans.video.factory.VideoTrans;
import com.plumblossom.videotrans.video.factory.VideoTransFactory;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description: Rabbitmq 消息队列处理的消费者端
 * @Date: 2020/10/9 10:27
 * @Version: 1.0
 */

@Component
public class Mp4VideoProcessHandler {

    private static final Logger log = LoggerFactory.getLogger(Mp4VideoProcessHandler.class);

    private static final String FILE_SUFFIX = ".mp4";

    @Autowired
    RabbitTemplate rabbitTemplate;


    @RabbitListener(queues = {RabbitmqConfig.QUEUE_MP4_H265_FLUENT},containerFactory = "customContainerFactory")
    public void receivedMP4H265FluentProcessTask(String msg, Message message, Channel channel){
        // 记录提交转码视频请求
        log.info("[mp4] [h265] [fluent] [command]:" + msg);
        Map params = JSON.parseObject(msg, Map.class);
        VideoTransFactory videoTransFactory = new MP4VideoTransFactory();
        VideoTrans videoTrans = videoTransFactory.getH265VideoTrans();

        // 生成新的转码视频目录
        String storage_path = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);
        String h265Path = storage_path + "Mp4"+File.separator + "H265" + File.separatorChar;
        String newFileName = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME) + FILE_SUFFIX;
        String fluentPath = h265Path +"fluent" +File.separator;
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, newFileName);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH,fluentPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, fluentPath + newFileName);

        String result = videoTrans.fluentTrans(params);
        // 记录结果
        log.info(msg + "["+result+"]");

        // 获取转码视频的Id
        String videoId = (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_VIDEO_ID);
        // 视频Id
        Integer vId = new Integer(videoId);

        Map<String, String> videoTransInfo = new HashMap<>();
        videoTransInfo.put(CommonConstValue.KEY_VIDEO_PARAMS_VIDEO_ID, Integer.toString(vId));

        videoTransInfo.put("video_type", "0");
        videoTransInfo.put("video_Encode", "1");
        videoTransInfo.put("video_resolution", "0");
        videoTransInfo.put("video_storage_path", (String) params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH));

        videoTransInfo.put("video_trans_status", "3");

        if (result.equals("success")){
            videoTransInfo.put("video_trans_status", "2");
        }
        videoTransInfo.put("video_trans_message", result);

        String processStatus = JSON.toJSONString(videoTransInfo);

        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_PROCESSED_STATUS, "",processStatus );
    }


}
