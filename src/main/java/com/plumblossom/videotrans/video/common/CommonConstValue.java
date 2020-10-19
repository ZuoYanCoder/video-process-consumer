package com.plumblossom.videotrans.video.common;


/**
 * @Author: ZuoYanCoder
 * @Description:
 * @Date: 2020/10/10 11:55
 * @Version: 1.0
 */
public class CommonConstValue {

    /**
     * 指定FFmpge 路径
     */
    public static final String FFMPEG_PATH = "C:\\SoftWare\\FFmpeg\\ffmpeg-4.3.1-win64-static\\bin\\ffmpeg.exe";

    /**
     * 流畅分辨率
     */
    public static final String FLUENT_RESOLUTION = "720*480";

    public static final String FLUENT_FOLDRE_NAME = "fluent";

    /**
     * 高清分辨率
     */
    public static final String HD_RESOLUTION = "1280*720";


    public static final String HD_FOLDRE_NAME = "hd";


    /**
     * 超清分辨率
     */
    public static final String HQ_RESOLUTION = "1920*1080";

    /**
     * 超清视频文件夹存放目录名称
     */
    public static final String HQ_FOLDRE_NAME = "hq";

    /**
     * 视频编码 H264
     */
    public static final String LIBX_H264 = "libx264";

    /**
     * 视频编码 H265
     */
    public static final String LIBX_H265 = "libx265";

    /**
     * 默认m3u8切片时间
     */
    public static final String DEFAULT_HLS_TIME = "10";


    public static final String DEFAULT_CRF_VALUE = "22";
    /**
     * 视频转换成功 状态
     */
    public static final String VIDEO_TRANS_SUCCESS = "success";

    /**
     * 系统上FFmpeg 的安装路径 key
     */
    public static final String KEY_VIDEO_PARAMS_FFMPEG_PATH = "ffmpeg_path";

    /**
     * 编码过后新生成的文件名 key
     *
     */
    public static final String KEY_VIDEO_PARAMS_NEW_FILE_NAME = "new_file_name";

    /**
     * 每个切片的时间长度 key
     */
    public static final String KEY_VIDEO_PARAMS_HLS_TIME = "hls_time";

    /**
     * 码率 key
     */
    public static final String KEY_VIDEO_PARAMS_CRF = "crf";

    /**
     * 视频分辨率 key
     */
    public static final String KEY_VIDEO_PARAMS_RESOLUTION = "resolution";

    /**
     * 视频压缩编码方式 key
     */
    public static final String KEY_VIDEO_PARAMS_LIBX = "libx";

    /**
     * 原视频全路径 key
     */
    public static final String KEY_VIDEO_PARAMS_SOURCE_VIDEO_PATH = "source_video_path";

    /**
     * 新生成视频全路径 key
     */
    public static final String KEY_VIDEO_PARAMS_NEW_VIDEO_PATH = "new_video_path";

    /**
     * 新生成视频保存路径 key
     */
    public static final String KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH = "storage_folder_path";

    /**
     * 视频文件id
     */
    public static final String KEY_VIDEO_PARAMS_VIDEO_ID = "video_id" ;
}
