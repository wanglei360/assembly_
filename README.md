## 原生组件化Demo


**ProjectMain**：主项目

**ProjectLibrary**：Library

**ProjectDemo**：Demo

**configuration**：各module中的依赖、版本号之类的统一存放处


clone代码，第一次运行项目时，会在各个项目中生成空的build.gradle文件，没有用，三个项目都在使用文件目录最外层的同一个build.gradle.kts，在各自项目中的settings.gradle.kts中设置的，不会自动生成gradle.properties文件和gradle文件夹，所以仓库中包含这些

三个项目都可独立运行，该Demo中打包使用的项目是ProjectMain，在该项目中的`app->build.gradle.kts`文件的`android->signingConfigs`中指定了签名文件，看客老爷自己生成吧！放在该项目的根目录即可，然后别忘了修改`android->signingConfigs`中的配置

![MacDown logo](https://raw.githubusercontent.com/wanglei360/assembly_/master/ProjectMain/img/441650443097_.pic.jpg)
按照图片找到这个选项，点击，就会生成apk了，会报一个关于`output-metadata.json`的错，不用管它

该Demo中因为三个项目相互依赖，打包时会进入同一个apk,所以命名时要注意，不能有重复命名，否则出现奇奇怪怪的报错

import prject ProjectMain 直接run就行
