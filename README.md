# video-process-consumer



FFmpeg 处理视频客户端 【每个分支分别处理一种不同视频的编码任务】



**解决方案:** 

总计有12个分支，每个分支是一种编码转换客户端。监听Rabbitmq消息队列中的处理视频任务，最终将项目打包成jar放置在
服务器上运行 

![运行效果](D:\code\video-process-consumer\imgs\FFmpeg处理视频任务.png)



但是现阶段还存在的问题是 服务器内存资源还没有利用到位，思路是启动3倍数量的这种编码客户端，配置Rabbitmq 多消费者的并行处理，而不是现在使用的平均分配轮询处理



使用Jenkins远程拉取GitHub上的不同分支，解决本地手动不停切换项目分支执行Maven打包命令，通过Jenkins拉取分支自动执行打包，打包完成后连接到Jenkins服务器上下载打包好的jar包执行





**Windwos服务器上批量启动Rabbitmq 客户端的bat 脚本**

````shell
@echo off
start cmd /k java -jar video-process-m3u8-264-fluent.jar
start cmd /k java -jar video-process-m3u8-264-hd.jar
start cmd /k java -jar video-process-m3u8-264-hq.jar
start cmd /k java -jar video-process-m3u8-265-fluent.jar
start cmd /k java -jar video-process-m3u8-265-hd.jar
start cmd /k java -jar video-process-m3u8-265-hq.jar
start cmd /k java -jar video-process-mp4-264-fluent.jar
start cmd /k java -jar video-process-mp4-264-hd.jar
start cmd /k java -jar video-process-mp4-264-hq.jar
start cmd /k java -jar video-process-mp4-265-fluent.jar
start cmd /k java -jar video-process-mp4-265-hd.jar
start cmd /k java -jar video-process-mp4-265-hq.jar
pause
````







