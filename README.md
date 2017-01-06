# IdeaPluginsAssistName
一个idea插件,帮助命名的插件

### 使用说明
工程尚未完成...

正在逐步更新...

### 开发的流程
一步一步写下开发流程,记录学习...

##### 开始创建
 - 1.安装 Intellij IDEA 开发工具
 - 2.打开 Intellij IDEA , 创建新的工程 'Create New Project'
 - 3.在左侧的选择栏 里 选择 'Intellij Platform Plus' 
    *(右边默认就好,不用选择;
          同时也注意下右边上部分的 Project SDK ,如果是空的话,点击它旁边的 New ,路径选择 Intellij IDEA 的安装目录,就可以了)*,点击 'Next'
 - 4.填好工程名称 和 目录 点击 'Finish'
 
 *此部分参考了此篇文章: http://www.jianshu.com/p/3ba18f88ba06* 
 
##### 开始尝试Demo
 - 先写个 hello 的 demo 吧
 - 参考了此网站内的文章: http://www.tuicool.com/articles/yeuyIj
 - 做出了个简单的Demo效果:
    ![image](src/pic/1.gif)
    
##### 思考
 - 虽然做出了一个插件,但是效果跟项目的需求不一致
     - 不想做菜单上的插件,想用个快捷方式,以及右键菜单的形式出现自己的插件
     - 需要根据选中的文本,进行操作
 - 有些地方的代码还不是很理解
 
#### 进一步的改进
 - 将插件改成右键和快捷键使用的方式
 - 有跟文本交互的实现
 - 参考了此网站内的文章:http://blog.csdn.net/huachao1001/article/details/53885981
 - 新建了个Action (HelloAction2),做出了个相应的Demo:
    ![image](src/pic/2.gif)
 

    