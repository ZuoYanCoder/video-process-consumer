package com.plumblossom.videotrans.video.command;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZuoYanCoder
 * @Description:
 * @Date: 2020/10/10 9:34
 * @Version: 1.0
 */
public interface CommandBuilder {

    public List<String> buildH264Command(Map<String,String> params);

    public List<String> buildH265Command(Map<String,String> params);

    public List<String> buildCommand(Map<String,String> params);
}
