package com.tao.data.thread;

import com.tao.data.config.Config;
import com.tao.data.dao.AccountDao;
import com.tao.data.entity.Account;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * DataThread
 *
 * @author Jiantao Yan
 * @title: DataThread
 * @date 2021/1/15 15:18
 */
@Slf4j
public class DataThread {

    private Thread thread;

    public void start() {
        thread =new Thread(() -> {
            while (true) {
                log.info("----------------->线程开始运行");
                AccountDao accountDao = Config.getAdminConfig().getAccountDao();
                List<Account> accountList = accountDao.findAll();
                for (Account account : accountList) {
                    account.setVersion(account.getVersion() + 1);
                    accountDao.save(account);
                }
           /* List<Account> accountList = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Account account = new Account();
//                account.setId(System.currentTimeMillis());
                account.setAge(i);
                account.setAppId(1L);
                account.setEmail(i + "aa@aa.com");
                account.setName("test" + i);
                account.setVersion(1);
                accountList.add(account);
            }
            accountDao.saveAll(accountList);*/
                try {
                    Thread.sleep(1000L);
                    log.info("--->线程睡眠");
//                TimeUnit.SECONDS.sleep(30L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });
        thread.setDaemon(true);
        thread.setName("myThread");
        thread.start();


    }


}
