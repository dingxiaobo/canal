package com.alibaba.otter.canal.server.embedded;

import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.alibaba.otter.canal.instance.manager.model.Canal;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.HAMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.IndexMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.MetaMode;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.SourcingType;
import com.alibaba.otter.canal.instance.manager.model.CanalParameter.StorageMode;

/**
 * @author 枭博
 * @date 2021/11/03
 */
public class CanalServerWithEmbedded_FormatDescriptionTest extends BaseCanalServerWithEmbededTest {
    @Override
    protected Canal buildCanal() {
        Canal canal = new Canal();
        canal.setId(1L);
        canal.setName(DESTINATION);
        canal.setDesc("test");

        CanalParameter parameter = new CanalParameter();

        parameter.setMetaMode(MetaMode.MEMORY);
        parameter.setHaMode(HAMode.HEARTBEAT);
        parameter.setIndexMode(IndexMode.MEMORY);

        parameter.setStorageMode(StorageMode.MEMORY);
        parameter.setMemoryStorageBufferSize(32 * 1024);

        parameter.setSourcingType(SourcingType.MYSQL);
        String ip = "47.102.195.228";
        int port = 3357;

        parameter.setDbAddresses(Arrays.asList(new InetSocketAddress(ip, port),
            new InetSocketAddress(ip, port)));
        parameter.setDbUsername("root");
        parameter.setDbPassword("34i3b#1323jf");
        //parameter.setPositions(Arrays.asList("{\"journalName\":\"mysql-bin.000002\",\"position\":4}"));
        parameter.setPositions(Arrays.asList("{\"timestamp\":"+(System.currentTimeMillis() - TimeUnit.DAYS.toMillis(100)) + "}"));

        parameter.setSlaveId(1234L);

        parameter.setDefaultConnectionTimeoutInSeconds(30);
        parameter.setConnectionCharset("UTF-8");
        parameter.setConnectionCharsetNumber((byte)33);
        parameter.setReceiveBufferSize(8 * 1024);
        parameter.setSendBufferSize(8 * 1024);
        parameter.setExposeHeartBeatEvent(true);

        canal.setCanalParameter(parameter);
        return canal;
    }
}
