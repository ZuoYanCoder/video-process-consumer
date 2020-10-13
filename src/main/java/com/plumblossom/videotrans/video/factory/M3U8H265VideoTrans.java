package com.plumblossom.videotrans.video.factory;


import com.plumblossom.videotrans.video.command.CommandBuilder;
import com.plumblossom.videotrans.video.command.M3U8CommandBuilder;
import com.plumblossom.videotrans.video.common.CommonConstValue;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description: M3U8 使用 H265 视频转码
 * @Date: 2020/10/9 16:02
 * @Version: 1.0
 */
public class M3U8H265VideoTrans extends AbstractH265VideoTrans {


    public M3U8H265VideoTrans(CommandBuilder commandBuilder){
        super(commandBuilder);
    }

    public M3U8H265VideoTrans(){
        super(new M3U8CommandBuilder());
    }

    @Override
    public String fluentTrans(Map<String, String> params) {

        params.put("resolution", CommonConstValue.FLUENT_RESOLUTION);
        List<String> h265Command = commandBuilder.buildH265Command(params);
        return super.hlsVideoUtil.generateM3u8(h265Command, params);
    }

    @Override
    public String hdTrans(Map<String, String> params) {

        params.put("resolution", CommonConstValue.HD_RESOLUTION);
        List<String> h265Command = commandBuilder.buildH265Command(params);
        return super.hlsVideoUtil.generateM3u8(h265Command, params);
    }

    @Override
    public String hqTrans(Map<String, String> params) {
        params.put("resolution", CommonConstValue.HQ_RESOLUTION);
        List<String> h265Command = commandBuilder.buildH265Command(params);
        return super.hlsVideoUtil.generateM3u8(h265Command, params);
    }

}
