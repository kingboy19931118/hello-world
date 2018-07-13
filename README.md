# 自建梯子：


## 1.vultr购买服务器 https://www.vultr.com/?ref=7303716
## 2.建议购买/Debian 7 x64/centOs/unbutu
## 3.xshell 远程连接到服务器/ssh
***
## 4.安装wget(Web Get)
apt-get install wget    | yum -y install wget
## 5.拷贝安装一键管理脚本
wget -N --no-check-certificate https://softs.fun/Bash/ssr.sh && chmod +x ssr.sh && bash ssr.sh
OR
wget -N --no-check-certificate https://raw.githubusercontent.com/ToyoDAdoubi/doubi/master/ssr.sh && chmod +x ssr.sh && bash ssr.sh
之后输入1，安装ShadowsocksR服务端，并且会提示你输入ShadowsocksR的 端口/密码/加密方式/ 协议/混淆（混淆和协议是通过输入数字选择的） 等参数。
## 6.管理脚本的命令：
bash ssr.sh

建议的配置
端口：443
加密：chacha20
协议：auth_sha1_v4
混淆：http_simple
## 7.安装libsodium，chacha20加密协议
## 8.安装BBR和封禁垃圾端口
注意：是否终止内核时选择NO
## 9.download ShadowsocksR 
windows地址：https://github.com/shadowsocksr-backup/shadowsocksr-csharp/releases
mac地址：https://github.com/qinyuhang/ShadowsocksX-NG-R/releases
ios地址：https://github.com/j-proxy/iossos
linux地址：https://github.com/the0demiurge/CharlesScripts/blob/master/charles/bin/ssr
安卓地址：https://github.com/shadowsocksr-backup/shadowsocksr-android/releases

Do some changes! thank you
