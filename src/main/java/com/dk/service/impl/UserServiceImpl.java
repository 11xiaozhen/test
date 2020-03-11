package com.dk.service.impl;

import com.dk.mapper.TbUserMapper;
import com.dk.pojo.TbUser;
import com.dk.pojo.TbUserExample;
import com.dk.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public void deleteAll(Integer[] ids) {
        tbUserMapper.deleteAll(ids);
    }

    @Override
    public void deleteUser(Integer id) {
        tbUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public TbUser getInfoById(Integer id) {
        return tbUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateUser(TbUser tbUser) {
        tbUserMapper.updateByPrimaryKeySelective(tbUser);
    }

    @Override
    public void addUser(TbUser tbUser) {
        tbUserMapper.insertSelective(tbUser);
    }

    @Override
    public PageInfo<TbUser> getInfo(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<TbUser> list = tbUserMapper.selectByExample(new TbUserExample());
        PageInfo<TbUser> page = new PageInfo<>(list);
        return page;
    }
}
