# hackon_workshops

## 第一次workshop：制作java爬虫
[ReadURL.java](https://github.com/Bruceshark/hackon_workshop/blob/master/ReadURL.java) & [readbin.java](https://github.com/Bruceshark/hackon_workshop/blob/master/readBin.java) 取自楼副教授在第一次hack_on workshop中所讲的java图片收集爬虫。

简要来说，readbin.java用于根据输入的图片网址来保存图片，ReadURL.java用于搜寻图片url。

ReadURL中暂时将被爬取网页设置为杭十四中校网中的某一篇新闻，下载两个文件后，您可以根据您想收集图片的网站url来自行更改url以及查询内容，如gif。

## 第二次workshop：socket网络通信编程入门
[SocketTry.java](https://github.com/Bruceshark/hackon_workshop/blob/master/SocketTry.java) 取自楼副教授在第二次hack_on workshop中所讲的server端模拟。

程序首先创建服务器端server和客户端client，然后让两者连接。
然后使用变量ps作为客户端的输出通道，变量br作为输入通道；根据filename变量查找文件然后输出。
最后关闭服务器和客户端。

下载、运行[SocketTry.java](https://github.com/Bruceshark/hackon_workshop/blob/master/SocketTry.java)后，您可以在浏览器中输入地址127.0.0.1:9999来访问创建的服务器，也可以在源文件的文件夹中放一张图，如pic.jpg，然后输入地址127.0.0.1:9999/pic.jpg来访问此图片，同时你会发现程序监听了你的访问并把记录显示了出来。

*important*：浏览器请用IE！不要用其它浏览器如chrome、firefox！！！

## 第三次workshop：用socket制作简易局域网内聊天室
[MultiChat.java](https://github.com/Bruceshark/hackon_workshop/blob/master/MultiChat.java) 和 [MultiChatServer.java](https://github.com/Bruceshark/hackon_workshop/blob/master/MultiChatServer.java) 取自楼副教授在第三次hack_on workshop中所讲的使用socket制作局域网内的聊天室。

*欢迎提出宝贵意见。一些问题可以直接qq：954272777
Bruce
