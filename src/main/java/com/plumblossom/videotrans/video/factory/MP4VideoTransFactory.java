package com.plumblossom.videotrans.video.factory;

/**
 * @Author: ZuoYanCoder
 * @Description: MP4 视频编码转换工程
 * @Date: 2020/10/9 15:51
 * @Version: 1.0
 */
public class MP4VideoTransFactory extends VideoTransFactory{

    @Override
    public VideoTrans getH264VideoTrans() {
        return new MP4H264VideoTrans();
    }

    @Override
    public VideoTrans getH265VideoTrans() {
        return new MP4H265VideoTrans();
    }
}
