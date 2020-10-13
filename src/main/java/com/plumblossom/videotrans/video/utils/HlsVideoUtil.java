package com.plumblossom.videotrans.video.utils;


import com.plumblossom.videotrans.video.common.CommonConstValue;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 此文件用于视频文件处理，步骤如下：
 * 1、生成mp4
 * 2、生成m3u8
 *
 */
public class HlsVideoUtil extends  VideoUtil {

    // 指定FFmpeg 路径
    public HlsVideoUtil(String ffmpeg_path){
        super(ffmpeg_path);
    }

    public HlsVideoUtil(){
        super(CommonConstValue.FFMPEG_PATH);
    }


    /**
     * 清除原来已经存在m3u8及ts文件
     * @param m3u8_path
     */
    private void clear_m3u8(String m3u8_path){
        //删除原来已经生成的m3u8及ts文件
        File m3u8dir = new File(m3u8_path);
        if(!m3u8dir.exists()){
            m3u8dir.mkdirs();
        }
       /* if(m3u8dir.exists()&&m3u8_path.indexOf("/hls/")>=0){//在hls目录方可删除，以免错误删除
            String[] children = m3u8dir.list();
            //删除目录中的文件
            for (int i = 0; i < children.length; i++) {
                File file = new File(m3u8_path, children[i]);
                file.delete();
            }
        }else{
            m3u8dir.mkdirs();
        }*/

    }


    /**
     *  通过自定义构建的命令来进行视频编码
     * @param command  构建的命令
     * @param videoInfo 视频的信息【包括：转码视频存放的地址 源视频的路径地址、转换后的视频路径地址】
     *                  key: m3u8folder_path
     *                  key: source_video_path
     *                  key: new_video_path
     * @return          视频转码之后的结果
     */
    public String generateM3u8(List<String> command, Map<String,String> videoInfo){

        //清理m3u8文件目录
        clear_m3u8(videoInfo.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH));

        // 指定生成 xxx.m3u8 的全路径
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
        //通过查看视频时长判断是否成功  // m3u8folder_path + m3u8_name
        Boolean check_video_time = check_video_time(
                videoInfo.get(CommonConstValue.KEY_VIDEO_PARAMS_SOURCE_VIDEO_PATH),
                videoInfo.get(CommonConstValue.KEY_VIDEO_PARAMS_NEW_VIDEO_PATH)
        );

        if(!check_video_time){
            return outstring;
        }

        //通过查看m3u8列表判断是否成功 仅支持本地
        if (!videoInfo.get(CommonConstValue.KEY_VIDEO_PARAMS_STORAGE_FOLDER_PATH).startsWith("http"))
        {
            List<String> ts_list = get_ts_list(videoInfo.get("new_video_path"));
            if(ts_list == null){
                return outstring;
            }
        }

        return "success";
    }

    /**
     *  通过给定的本地的文件系统上的m3u8 文件路径，获取ts文件列表
     * @param m3u8file_path
     * @return
     */
    public List<String> get_ts_list(String m3u8file_path) {

        if (StringUtils.isEmpty(m3u8file_path))
        {
            return null;
        }
//        String m3u8_name = video_name.substring(0, video_name.lastIndexOf("."))+".m3u8";
        List<String> fileList = new ArrayList<String>();
        List<String> tsList = new ArrayList<String>();
        BufferedReader br = null;
        String str = null;
        String bottomline = "";
        try {
            br = new BufferedReader(new FileReader(m3u8file_path));
            while ((str = br.readLine()) != null) {
                bottomline = str;
                if(bottomline.endsWith(".ts")){
                    tsList.add(bottomline);
                }
                //System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br!=null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        if (bottomline.contains("#EXT-X-ENDLIST")) {
            fileList.addAll(tsList);
            return fileList;
        }
        return null;

    }

}
