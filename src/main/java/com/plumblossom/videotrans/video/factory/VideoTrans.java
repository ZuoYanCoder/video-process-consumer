package com.plumblossom.videotrans.video.factory;



import com.plumblossom.videotrans.video.command.CommandBuilder;
import com.plumblossom.videotrans.video.common.CommonConstValue;
import com.plumblossom.videotrans.video.utils.HlsVideoUtil;
import com.plumblossom.videotrans.video.utils.Mp4VideoUtil;

import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description: 定义视频转换清晰度公共接口
 * @Date: 2020/10/9 15:30
 * @Version: 1.0
 */
public abstract class VideoTrans {

    // 生成执行FFmpeg 的命令
    protected CommandBuilder commandBuilder;

    // hls 视频转化类
    protected HlsVideoUtil hlsVideoUtil;

    // mp4 视频转换类
    protected Mp4VideoUtil mp4VideoUtil;


    public VideoTrans() {
        this.hlsVideoUtil = new HlsVideoUtil(CommonConstValue.FFMPEG_PATH);
        this.mp4VideoUtil = new Mp4VideoUtil();

    }

    public abstract String fluentTrans(Map<String, String> params);

    public abstract String hdTrans(Map<String, String> params);

    public abstract String hqTrans(Map<String, String> params);


}
