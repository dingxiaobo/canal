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

