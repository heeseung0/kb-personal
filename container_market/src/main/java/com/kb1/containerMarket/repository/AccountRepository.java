package com.kb1.containerMarket.repository;

import com.kb1.containerMarket.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AccountRepository {
    public User findUserByID(String username) throws Exception;
    public int saveUser(User user) throws Exception;
    public int updateUser(User user) throws Exception;
}
