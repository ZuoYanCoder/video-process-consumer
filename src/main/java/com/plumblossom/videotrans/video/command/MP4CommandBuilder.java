package com.plumblossom.videotrans.video.command;



import com.plumblossom.videotrans.video.common.CommonConstValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description:
 * @Date: 2020/10/10 10:01
 * @Version: 1.0
 */
public class MP4CommandBuilder implements CommandBuilder {

    /**
     * MP4 H264 视频编码构建
     *
     * @param params
     * @return
     */
    @Override
    public List<String> buildH264Command(Map<String, String> params) {
        if (params == null) {
            return null;
        }
        params.put("libx", CommonConstValue.LIBX_H264);
        return buildCommand(params);
    }


    /**
     * MP4 H265 视频编码构建
     *
     * @param params
     * @return
     */
    @Override
    public List<String> buildH265Command(Map<String, String> params) {
        if (params == null) {
            return null;
        }
        params.put("libx", CommonConstValue.LIBX_H265);
        return buildCommand(params);
    }


    @Override
    public List<String> buildCommand(Map<String, String> params) {

        String ffmpeg_path = params.get(CommonConstValue.KEY_VIDEO_PARAMS_FFMPEG_PATH);

        // 转换的源视频的路径
        String source_video_path = params.get(CommonConstValue.KEY_VIDEO_PARAMS_SOURCE_VIDEO_PATH);

        // 转换的Mp4视频文件存放的路径
        String mp4folder_path = params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);

        // 设置转换过后的MP4文件名称
        String mp4_name = params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME);

        // 设置码率默认值
        String crf = params.get(CommonConstValue.KEY_VIDEO_PARAMS_CRF) == null ? CommonConstValue.DEFAULT_CRF_VALUE : params.get(CommonConstValue.KEY_VIDEO_PARAMS_CRF);

        // 设置分辨率
        String resolution = params.get(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION);

        // 设置压缩编码的编码格式
        String libx = params.get(CommonConstValue.KEY_VIDEO_PARAMS_LIBX);

        return buildCommand(ffmpeg_path, source_video_path, mp4folder_path, mp4_name, crf, resolution, libx);
    }


    /**
     * @param ffmpeg_path       FFmpeg 绝对路径
     * @param source_video_path 原始转换视频的地址
     * @param mp4folder_path    转换过后 MP4 的存放目录 x:/y/z/ 最后面加上反斜杠
     * @param mp4_name          转换过后 MP4 的视频的名称
     * @param crf               视频转码使用的码率参数
     * @param resolution        视频的分辨率
     * @param libx              指定使用 H264编码  还是使用 H265 编码  libx264  libx265
     * @return
     */
    public List<String> buildCommand(String ffmpeg_path, String source_video_path,
                                     String mp4folder_path, String mp4_name,
                                     String crf, String resolution,
                                     String libx) {
        List<String> command = new ArrayList<>();
        command.add(ffmpeg_path);

        command.add("-i");
        command.add(source_video_path);

        command.add("-vcodec");
        command.add(libx);

        // 设置压缩速度
        command.add("-preset");
        command.add("slow");

        // 设置码率
        command.add("-crf");
        command.add(crf);

        // 设置分辨率
        command.add("-s");
        command.add(resolution);

        // 设置音频编码方式
        command.add("-c:a");
        command.add("copy");

        // 设置新生成的mp4 文件
        command.add(mp4folder_path + mp4_name);
        return command;
    }


}
