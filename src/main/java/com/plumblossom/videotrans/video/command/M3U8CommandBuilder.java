package com.plumblossom.videotrans.video.command;



import com.plumblossom.videotrans.video.common.CommonConstValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description: M3U8 FFmpeg 命令 构建器
 * @Date: 2020/10/9 16:38
 * @Version: 1.0
 */
public class M3U8CommandBuilder implements CommandBuilder {

    /**
     *
     * @param ffmpeg_path            FFmpeg 绝对路径
     * @param source_video_path      原始转换视频的地址
     * @param hls_time               每个片段的时间
     * @param m3u8folder_path        转换过后 m3u8  存放目录 x:/y/z/ 最后面加上反斜杠
     * @param m3u8_name              转换过后 m3u8 视频的名称
     * @param crf                    视频转码使用的码率参数
     * @param resolution             视频的分辨率
     * @param libx           指定使用 H264编码  还是使用 H265 编码  libx264  libx265
     * @return
     */
    public List<String> buildCommand(String ffmpeg_path, String source_video_path,
                                               String hls_time, String m3u8folder_path,
                                               String m3u8_name,String crf, String resolution,
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

        // 设置每个片段的默认时间
        command.add("-hls_time");
        command.add(hls_time);


        // 设置播放列表保存的最多条目，设置为0会保存有所片信息，默认值为5
        command.add("-hls_list_size");
        command.add("0");

        // 设置每个ts的文件名称
        command.add("-hls_segment_filename");
        command.add(m3u8folder_path + m3u8_name.substring(0, m3u8_name.lastIndexOf(".")) + "_%05d.ts");

        command.add(m3u8folder_path + m3u8_name);

        return command;
    }


    /**
     * 构建 H264 视频编码的 m3u8 命令
     * @param params
     * @return
     */
    @Override
    public List<String> buildH264Command(Map<String, String> params) {
        if (params == null) {
            return null;
        }
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_LIBX, CommonConstValue.LIBX_H264);
        return buildCommand(params);
    }



    /**
     *  构建 H265 视频编码的 m3u8 命令
     * @param params
     * @return
     *
     */
    @Override
    public List<String> buildH265Command(Map<String, String> params) {
        if (params == null) {
            return null;
        }
        params.put(CommonConstValue.KEY_VIDEO_PARAMS_LIBX, CommonConstValue.LIBX_H265);
        return buildCommand(params);
    }

    /**
     *  通过 Map 构建视频处理命令
     *
     * @param params
     * @return
     */
    public List<String> buildCommand(Map<String,String> params){


        String ffmpeg_path = params.get(CommonConstValue.KEY_VIDEO_PARAMS_FFMPEG_PATH);

        // 转换的源视频的路径
        String source_video_path = params.get(CommonConstValue.KEY_VIDEO_PARAMS_SOURCE_VIDEO_PATH);

        // 转换的m3u8 视频文件存放的路径
        String m3u8folder_path = params.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH);

        // 设置每个切片的时间长度
        String hls_time = params.get(CommonConstValue.KEY_VIDEO_PARAMS_HLS_TIME) == null ? CommonConstValue.DEFAULT_HLS_TIME : params.get(CommonConstValue.KEY_VIDEO_PARAMS_HLS_TIME);

        String m3u8_name = params.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_FILE_NAME);

        // 设置码率默认值
        String crf = params.get(CommonConstValue.KEY_VIDEO_PARAMS_CRF) == null ? CommonConstValue.DEFAULT_CRF_VALUE : params.get(CommonConstValue.KEY_VIDEO_PARAMS_CRF);

        // 设置分辨率
        String resolution = params.get(CommonConstValue.KEY_VIDEO_PARAMS_RESOLUTION);

        // 设置压缩编码的编码格式
        String libx = params.get(CommonConstValue.KEY_VIDEO_PARAMS_LIBX);

        return buildCommand(ffmpeg_path, source_video_path, hls_time, m3u8folder_path, m3u8_name, crf, resolution, libx);
    }
}
