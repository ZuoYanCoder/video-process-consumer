package com.plumblossom.videotrans.video.utils;



import com.plumblossom.videotrans.video.common.CommonConstValue;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2018/3/6.
 */
public class Mp4VideoUtil extends VideoUtil {


    public Mp4VideoUtil() {
    }

    //清除已生成的mp4
    private void clear_mp4(String mp4_path) {

        // 如果存在删除原来存在的文件
        File mp4File = new File(mp4_path);
        if (mp4File.exists() && mp4File.isFile()) {
            mp4File.delete();
        } else {
            // 如果不存在创建该文件夹
            mp4File.mkdirs();
        }
    }


    public String generateMp4(List<String> command, Map<String,String> videoInfo) {
        //清除已生成的mp4
        clear_mp4(videoInfo.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH));

        String outstring = null;
        try {
            ProcessBuilder builder = new ProcessBuilder();
            builder.command(command);
            //将标准输入流和错误输入流合并，通过标准输入流程读取信息
            builder.redirectErrorStream(true);
            Process p = builder.start();
            outstring = waitFor(p);

        } catch (Exception ex) {

            ex.printStackTrace();
        }

        Boolean check_video_time = this.check_video_time(
                videoInfo.get(CommonConstValue.KEY_VIDEO_PARAMS_SOURCE_VIDEO_PATH),
                videoInfo.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH)
        );

        if (!check_video_time) {
            return outstring;
        } else {
            return "success";
        }
    }


}
