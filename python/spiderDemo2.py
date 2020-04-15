import urllib2

response = urllib2.urlopen('https://www.baidu.com/')
# response.encoding = "utf-8"
print response.read
# print(response.status_code)