package com.plumblossom.videotrans.video.factory;


import com.plumblossom.videotrans.video.command.CommandBuilder;

/**
 * @Author: ZuoYanCoder
 * @Description:
 * @Date: 2020/10/9 15:44
 * @Version: 1.0
 */
public abstract class AbstractH264VideoTrans extends VideoTrans{

    public AbstractH264VideoTrans(CommandBuilder commandBuilder){
        super.commandBuilder = commandBuilder;
    }



}
