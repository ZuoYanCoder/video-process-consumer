package com.plumblossom.videotrans.video;

import com.plumblossom.videotrans.config.RabbitmqConfig;
import com.plumblossom.videotrans.video.common.CommonConstValue;
import com.plumblossom.videotrans.video.utils.BuildVideProcessParam;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: ZuoYanCoder
 * @Description:
 * @Date: 2020/10/13 11:16
 * @Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestVideoRabbitmq {

    @Autowired
    RabbitTemplate rabbitTemplate;



    @Test
    public void testProcessMessage(){
        String newFileName = "result-video";
        String storageFilePath = "C:\\SoftWare\\ProgramData\\UploadVideo\\mianshi\\";
        String sourceVideoPath = "C:\\SoftWare\\ProgramData\\UploadVideo\\mianshi\\1.mp4";

        String newVideoPath = storageFilePath + newFileName;
        String resolution = CommonConstValue.FLUENT_FOLDRE_NAME;
        String processMP4 = BuildVideProcessParam.buildProcessMP4Params(newFileName, storageFilePath, sourceVideoPath, newVideoPath, resolution);
        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_PROCESS_VIDEO,"",processMP4);

    }
}
