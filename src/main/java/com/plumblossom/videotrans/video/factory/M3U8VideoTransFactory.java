package com.plumblossom.videotrans.video.factory;

/**
 * @Author: ZuoYanCoder
 * @Description: M3U8 视频处理工厂
 * @Date: 2020/10/9 15:51
 * @Version: 1.0
 */
public class M3U8VideoTransFactory extends VideoTransFactory{


    @Override
    public VideoTrans getH264VideoTrans() {
        return new M3U8H264VideoTrans();
    }

    @Override
    public VideoTrans getH265VideoTrans() {

        return new M3U8H265VideoTrans();

    }
}
