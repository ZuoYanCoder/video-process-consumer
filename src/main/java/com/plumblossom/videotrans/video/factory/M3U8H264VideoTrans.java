package com.plumblossom.videotrans.video.factory;



import com.plumblossom.videotrans.video.command.CommandBuilder;
import com.plumblossom.videotrans.video.command.M3U8CommandBuilder;
import com.plumblossom.videotrans.video.common.CommonConstValue;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description: M3U8 使用 H264 视频转码
 * @Date: 2020/10/9 16:02
 * @Version: 1.0
 */
public class M3U8H264VideoTrans extends AbstractH264VideoTrans {


    public M3U8H264VideoTrans(CommandBuilder commandBuilder) {
        super(commandBuilder);
    }

    public M3U8H264VideoTrans(){
        super(new M3U8CommandBuilder());
    }

    @Override
    public String fluentTrans(Map<String, String> params) {

        params.put("resolution", CommonConstValue.FLUENT_RESOLUTION);
        List<String> h264Command = commandBuilder.buildH264Command(params);
        return super.hlsVideoUtil.generateM3u8(h264Command, params);
    }

    @Override
    public String hdTrans(Map<String, String> params) {

        params.put("resolution", CommonConstValue.HD_RESOLUTION);
        List<String> h264Command = commandBuilder.buildH264Command(params);
        return super.hlsVideoUtil.generateM3u8(h264Command, params);
    }

    @Override
    public String hqTrans(Map<String, String> params) {

        params.put("resolution", CommonConstValue.HQ_RESOLUTION);
        List<String> h264Command = commandBuilder.buildH264Command(params);
        return super.hlsVideoUtil.generateM3u8(h264Command, params);
    }

}
