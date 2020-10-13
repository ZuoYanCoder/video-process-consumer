package com.plumblossom.videotrans.video.factory;





import com.plumblossom.videotrans.video.command.CommandBuilder;
import com.plumblossom.videotrans.video.command.MP4CommandBuilder;
import com.plumblossom.videotrans.video.common.CommonConstValue;

import java.util.List;
import java.util.Map;


/**
 * @Author: ZuoYanCoder
 * @Description: MP4 H265 视频转码
 * @Date: 2020/10/9 16:02
 * @Version: 1.0
 */
public class MP4H265VideoTrans extends AbstractH265VideoTrans {

    public MP4H265VideoTrans(CommandBuilder commandBuilder) {
        super(commandBuilder);
    }


    public MP4H265VideoTrans(){
        super(new MP4CommandBuilder());
    }


    @Override
    public String fluentTrans(Map<String, String> params) {

        params.put(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION, CommonConstValue.FLUENT_RESOLUTION);
        List<String> h265Command = commandBuilder.buildH265Command(params);
        return super.mp4VideoUtil.generateMp4(h265Command, params);
    }

    @Override
    public String hdTrans(Map<String, String> params) {

        params.put(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION, CommonConstValue.HD_RESOLUTION);
        List<String> h265Command = commandBuilder.buildH265Command(params);
        return super.mp4VideoUtil.generateMp4(h265Command, params);
    }

    @Override
    public String hqTrans(Map<String, String> params) {

        params.put(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION, CommonConstValue.HQ_RESOLUTION);
        List<String> h265Command = commandBuilder.buildH265Command(params);
        return super.mp4VideoUtil.generateMp4(h265Command, params);
    }

}
