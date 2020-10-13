package com.plumblossom.videotrans.video.factory;



import com.plumblossom.videotrans.video.command.CommandBuilder;
import com.plumblossom.videotrans.video.command.MP4CommandBuilder;
import com.plumblossom.videotrans.video.common.CommonConstValue;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description: MP4 H264 视频转码
 * @Date: 2020/10/9 16:02
 * @Version: 1.0
 */
public class MP4H264VideoTrans extends AbstractH264VideoTrans {


    public MP4H264VideoTrans(CommandBuilder commandBuilder) {
        super(commandBuilder);
    }


    public MP4H264VideoTrans(){
        super(new MP4CommandBuilder());
    }


    @Override
    public String fluentTrans(Map<String, String> params) {

        params.put(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION, CommonConstValue.FLUENT_RESOLUTION);
        List<String> h264Command = commandBuilder.buildH264Command(params);
        return super.mp4VideoUtil.generateMp4(h264Command, params);
    }

    @Override
    public String hdTrans(Map<String, String> params) {

        params.put(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION, CommonConstValue.HD_RESOLUTION);
        List<String> h264Command = commandBuilder.buildH264Command(params);
        return super.mp4VideoUtil.generateMp4(h264Command, params);
    }

    @Override
    public String hqTrans(Map<String, String> params) {

        params.put(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION, CommonConstValue.HQ_RESOLUTION);
        List<String> h264Command = commandBuilder.buildH264Command(params);
        return super.mp4VideoUtil.generateMp4(h264Command, params);
    }

}
