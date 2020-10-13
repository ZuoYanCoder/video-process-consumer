package com.plumblossom.videotrans.video.factory;

/**
 * @Author: ZuoYanCoder
 * @Description:
 * @Date: 2020/10/9 15:49
 * @Version: 1.0
 */
public abstract class VideoTransFactory {

    // 获取H264 的工厂
    public abstract VideoTrans getH264VideoTrans();

    // 获取H265 的工厂
    public abstract VideoTrans getH265VideoTrans();

}
