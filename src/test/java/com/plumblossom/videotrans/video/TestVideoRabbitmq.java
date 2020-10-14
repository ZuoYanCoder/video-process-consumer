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


   /* @Test
    public void testProcessMessage(){
        String newFileName = "cutout-kuaiji";
        String storageFilePath = "C:\\SoftWare\\ProgramData\\UploadVideo\\cut\\";
        String sourceVideoPath = "C:\\SoftWare\\ProgramData\\UploadVideo\\cut\\cutout.mp4";

        String newVideoPath = storageFilePath + newFileName;
        String resolution = CommonConstValue.FLUENT_FOLDRE_NAME;
        String processMP4 = BuildVideProcessParam.buildProcessMP4Params(newFileName, storageFilePath, sourceVideoPath, newVideoPath, resolution);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_PROCESS_VIDEO,"",processMP4);

        newFileName = "testing-video";
        storageFilePath = "C:\\SoftWare\\ProgramData\\UploadVideo\\testing\\";
        sourceVideoPath = "C:\\SoftWare\\ProgramData\\UploadVideo\\testing\\cutout.mp4";

        newVideoPath = storageFilePath + newFileName;
        resolution = CommonConstValue.FLUENT_FOLDRE_NAME;
        processMP4 = BuildVideProcessParam.buildProcessMP4Params(newFileName, storageFilePath, sourceVideoPath, newVideoPath, resolution);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_PROCESS_VIDEO,"",processMP4);

        newFileName = "test-2-video";
        storageFilePath = "C:\\SoftWare\\ProgramData\\UploadVideo\\test2\\";
        sourceVideoPath = "C:\\SoftWare\\ProgramData\\UploadVideo\\test2\\cutout.mp4";

        newVideoPath = storageFilePath + newFileName;
        resolution = CommonConstValue.FLUENT_FOLDRE_NAME;
        processMP4 = BuildVideProcessParam.buildProcessMP4Params(newFileName, storageFilePath, sourceVideoPath, newVideoPath, resolution);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_PROCESS_VIDEO,"",processMP4);


        newFileName = "test-3-video";
        storageFilePath = "C:\\SoftWare\\ProgramData\\UploadVideo\\test3\\";
        sourceVideoPath = "C:\\SoftWare\\ProgramData\\UploadVideo\\test3\\cutout.mp4";

        newVideoPath = storageFilePath + newFileName;
        resolution = CommonConstValue.FLUENT_FOLDRE_NAME;
        processMP4 = BuildVideProcessParam.buildProcessMP4Params(newFileName, storageFilePath, sourceVideoPath, newVideoPath, resolution);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_PROCESS_VIDEO,"",processMP4);


        newFileName = "test-4-video";
        storageFilePath = "C:\\SoftWare\\ProgramData\\UploadVideo\\test4\\";
        sourceVideoPath = "C:\\SoftWare\\ProgramData\\UploadVideo\\test4\\cutout.mp4";

        newVideoPath = storageFilePath + newFileName;
        resolution = CommonConstValue.FLUENT_FOLDRE_NAME;
        processMP4 = BuildVideProcessParam.buildProcessMP4Params(newFileName, storageFilePath, sourceVideoPath, newVideoPath, resolution);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_PROCESS_VIDEO,"",processMP4);


        newFileName = "test-5-video";
        storageFilePath = "C:\\SoftWare\\ProgramData\\UploadVideo\\test5\\";
        sourceVideoPath = "C:\\SoftWare\\ProgramData\\UploadVideo\\test5\\cutout.mp4";

        newVideoPath = storageFilePath + newFileName;
        resolution = CommonConstValue.FLUENT_FOLDRE_NAME;
        processMP4 = BuildVideProcessParam.buildProcessMP4Params(newFileName, storageFilePath, sourceVideoPath, newVideoPath, resolution);
//        rabbitTemplate.convertAndSend(RabbitmqConfig.EXCHANGE_PROCESS_VIDEO,"",processMP4);


    }*/
}
