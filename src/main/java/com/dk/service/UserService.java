package com.dk.service;

import com.dk.pojo.TbUser;
import com.github.pagehelper.PageInfo;

public interface UserService {
    PageInfo<TbUser> getInfo(Integer pageNum, Integer pageSize);

    void addUser(TbUser tbUser);

    void updateUser(TbUser tbUser);

    TbUser getInfoById(Integer id);

    void deleteUser(Integer id);

    void deleteAll(Integer[] ids);
}
