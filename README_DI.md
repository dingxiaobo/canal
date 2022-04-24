1. 从Canal 1.1.4 源码分支fork

2. 打包命令

```
mvn clean deploy -DskipTests
```

# version

## 1.1.4.0

### 暴露 MHEARTBEAT

## 1.1.4.1

### SO_TIMEOUT

调大BioSocketChannel.SO_TIMEOUT参数，避免友邦30个实时同步任务同时DUMP同一个实例

## 1.1.4.2

### 解析 FORMAT_DESCRIPTION

`EntryProtocol.proto` 里添加一种 FORMAT_DESCRIPTION，让下游可以感知到日志切换

#### 如何编译canal里的protobuf
下载 proto compiler 3.6.1 版本，并赋予运行权限

在工程目录下执行 
```bash
~/app/protoc-3.6.1-osx-x86_64/bin/protoc  --java_out=protocol/src/main/java -I=protocol/src/main/java/com/alibaba/otter/canal/protocol AdminProtocol.proto 
~/app/protoc-3.6.1-osx-x86_64/bin/protoc  --java_out=protocol/src/main/java -I=protocol/src/main/java/com/alibaba/otter/canal/protocol CanalProtocol.proto 
~/app/protoc-3.6.1-osx-x86_64/bin/protoc  --java_out=protocol/src/main/java -I=protocol/src/main/java/com/alibaba/otter/canal/protocol EntryProtocol.proto
~/app/protoc-3.6.1-osx-x86_64/bin/protoc  --java_out=protocol/src/main/java EntryProtocol.proto 
 
```


## 1.1.4.3

修复，指定一个明明存在的时间戳位点时，报错找不到位点

## 1.1.4.4

对外透出`UniqueKey`，在源表无主键的时候，用唯一索引来做并发

## 1.1.4.5

分离构造方法和初始化方法

## 1.1.4.6

支持并行解析参数 `parallelThreadSize` 可配，避免出现开启并行解析 多个实时同步任务运行在一台机器上，到是机器CPU飙高被挂起的问题。



## 1.1.4.7

透出 PREV_GTID

`EntryProtocol.proto` 里添加一种 PREVIOUSGTIDS，让下游可以感知到日志切换
