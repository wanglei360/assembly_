##原生组件化Demo

ProjectMain：主项目

ProjectLibrary：Library

ProjectDemo：Demo

configuration：各module中的依赖、版本号之类的统一存放处

三个项目都在使用文件目录最外层的同一个build.gradle.kts，在各自项目中的settings.gradle.kts中设置的

三个项目都可独立运行，该Demo中打包使用的项目是ProjectMain

该Demo中因为三个项目相互依赖，打包时会进入同一个apk,所以命名时要注意，不能有重复命名，否则出现奇奇怪怪的问题

