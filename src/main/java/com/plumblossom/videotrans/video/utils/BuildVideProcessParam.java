package com.plumblossom.videotrans.video.utils;

import com.alibaba.fastjson.JSON;
import com.plumblossom.videotrans.video.common.CommonConstValue;


import java.util.HashMap;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description:
 * @Date: 2020/10/10 17:50
 * @Version: 1.0
 */
public class BuildVideProcessParam {

    /**
     *  通过制定参数生成处理 m3u8 视频的 json字符串
     * @param m3u8FolderPath
     * @param sourceVideoPath
     * @param m3u8name
     * @param hls_time
     * @param crf
     * @return
     */
    public static String buildProcessM3U8Params(String m3u8FolderPath, String sourceVideoPath,
                                                String m3u8name, String hls_time, String crf) {
        // 构建生成 m3u8 视频的map参数
        Map<String, String> params = new HashMap<>();
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_FFMPEG_PATH,CommonConstValue.FFMPEG_PATH);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_SOURCE_VIDEO_PATH, sourceVideoPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH, m3u8FolderPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, m3u8name);

        // 对hls进行非空处理
        if (null == hls_time){
            hls_time = "10";
        }
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_HLS_TIME, hls_time);
        // 对crf进行非null 处理
        if (null == crf){
            crf = "22";
        }
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_CRF, crf);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, m3u8FolderPath + m3u8name);
        String message = JSON.toJSONString(params);
        return message;
    }


    /**
     *  通过给定的参数生成处理 MP4 的视频命令
     * @param newFileName
     * @param storage_video_path
     * @param sourceVideoPath
     * @param newVideoPath
     * @return
     */
    public static String buildProcessMP4Params(String newFileName,String storage_video_path,String sourceVideoPath,String newVideoPath,String resolution) {
        Map<String, String> params = new HashMap<>();
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME, newFileName);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH, storage_video_path);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_SOURCE_VIDEO_PATH, sourceVideoPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_FFMPEG_PATH, CommonConstValue.FFMPEG_PATH);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH, newVideoPath);
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION, resolution);
        String message = JSON.toJSONString(params);
        return message;
    }


}
