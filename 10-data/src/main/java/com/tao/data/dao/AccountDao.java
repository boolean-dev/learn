package com.tao.data.dao;

import com.tao.data.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


/**
 * AccountDao
 *
 * @author Jiantao Yan
 * @title: AccountDao
 * @date 2021/1/15 15:10
 */
@Repository
public interface AccountDao extends JpaRepository<Account, Long> {

}
