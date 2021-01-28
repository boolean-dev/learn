package com.tao.data.config;

import com.tao.data.dao.AccountDao;
import com.tao.data.thread.DataThread;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 配置类
 *
 * @author Jiantao Yan
 * @title: Config
 * @date 2021/1/15 15:23
 */
@Component
public class Config implements InitializingBean, DisposableBean {

    private static Config config = null;

    public static Config getAdminConfig() {
        return config;
    }

    @Autowired
    private AccountDao accountDao;

    @Override
    public void afterPropertiesSet() throws Exception {
        config = this;
        DataThread dataThread = new DataThread();
        dataThread.start();

    }

    @Override
    public void destroy() throws Exception {
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }
}
