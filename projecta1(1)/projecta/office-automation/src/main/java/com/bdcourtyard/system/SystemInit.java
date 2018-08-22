package com.bdcourtyard.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * Created by cxx on 2018/7/9.
 */
@Component(value = "systemInits")
public class SystemInit implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOG = LoggerFactory.getLogger(SystemInit.class);

    /**
     * 启动状态位
     */
    private volatile static boolean isStart = false;

    private static void setIsStart(boolean isStart) {
        SystemInit.isStart = isStart;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (!isStart) {
            if (LOG.isInfoEnabled()) {
                LOG.info("============init system...=============");
            }
            //ConfigManager.initConf();
//            MsgPush.getInstance();
            //状态位复位
            SystemInit.setIsStart(true);
        }
    }
}
