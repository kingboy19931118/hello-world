import requests  # 预先安装requests库

response = requests.get('https://www.baidu.com/')  # 发送Http请求
response.encoding = "utf-8"  # 将下载内容编码为utf-8格式，否则乱码
print(response.text)  # 打印网页内容
print(response.status_code)  # 打印状态码，200代表正常