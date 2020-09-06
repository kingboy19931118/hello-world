# 自建梯子：


* vultr购买服务器 https://www.vultr.com/?ref=7303716  <br/>
* 建议购买/Debian 7 x64/centOs/unbutu  <br/>
* xshell 远程连接到服务器/ssh  <br/>
* 安装wget(Web Get)  <br/>
> apt-get install wget | yum -y install wget  <br/>
* 拷贝安装一键管理脚本  <br/>
> wget -N --no-check-certificate https://softs.fun/Bash/ssr.sh && chmod +x ssr.sh && bash ssr.sh  <br/>
> wget -N --no-check-certificate https://raw.githubusercontent.com/ToyoDAdoubi/doubi/master/ssr.sh && chmod +x ssr.sh && bash ssr.sh<br/>
> 之后输入1，安装ShadowsocksR服务端，并且会提示你输入ShadowsocksR的 端口/密码/加密方式/ 协议/混淆（混淆和协议是通过输入数字选择的） 等参数。<br/>

* 管理脚本的命令：<br/>
> bash ssr.sh  <br/>
> 建议的配置  <br/>
>> 端口：443  <br/>
>> 加密：chacha20  <br/>
>> 协议：auth_sha1_v4  <br/>
>> 混淆：http_simple  <br/>
* 安装libsodium，chacha20加密协议<br/>
* 安装BBR和封禁垃圾端口<br/>
> 注意：是否终止内核时选择NO<br/>
* download ShadowsocksR <br/>
> windows地址：https://github.com/shadowsocksr-backup/shadowsocksr-csharp/releases<br/>
> mac地址：https://github.com/qinyuhang/ShadowsocksX-NG-R/releases<br/>
> ios地址：https://github.com/j-proxy/iossos<br/>
> linux地址：https://github.com/the0demiurge/CharlesScripts/blob/master/charles/bin/ssr<br/>
> 安卓地址：https://github.com/shadowsocksr-backup/shadowsocksr-android/releases<br/>

Do some changes! thank you
