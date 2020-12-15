package com.hclg.question.service.impl;

import com.hclg.question.auth.TokenGenerator;
import com.hclg.question.dao.SysTokenDao;
import com.hclg.question.dao.UserDao;
import com.hclg.question.pojo.SysToken;
import com.hclg.question.pojo.User;
import com.hclg.question.service.ShiroService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShiroServiceImpl implements ShiroService {
    @Resource
    private UserDao userDao;
    @Resource
    private SysTokenDao sysTokenDao;
    /**
     * 根据username查找用户
     *
     * @param username
     * @return User
     */
    @Override
    public User findByUsername(String username) {
        User user = userDao.findByUsername(username);
        return user;
    }

    //12小时后过期
    private final static int EXPIRE = 3600 * 12;
//    private final static int EXPIRE = 5;

    @Override
    /**
     * 生成一个token
     *@param  [userId]
     *@return Result
     */
    public Map<String, Object> createToken(Integer userId) {
        Map<String, Object> result = new HashMap<>();
        //生成一个token
        String token = TokenGenerator.generateValue();
        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);
        //判断是否生成过token
        SysToken tokenEntity = sysTokenDao.findByUserId(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //保存token
            sysTokenDao.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);
            //更新token
            sysTokenDao.update(tokenEntity);
        }
        result.put("token", token);
        result.put("expire", EXPIRE);
        return result;
    }

    @Override
    public void logout(String token) {
        SysToken byToken = findByToken(token);
        //生成一个token
        token = TokenGenerator.generateValue();
        //修改token
        SysToken tokenEntity = new SysToken();
        tokenEntity.setUserId(byToken.getUserId());
        tokenEntity.setToken(token);
        sysTokenDao.save(tokenEntity);
    }

    @Override
    public SysToken findByToken(String accessToken) {
        return sysTokenDao.findByToken(accessToken);

    }

    @Override
    public User findByUserId(Integer userId) {
        return userDao.findByUserId(userId);
    }









    @Override
    public List<User> queryAllUsers() {
        return userDao.queryAllUsers();
    }

    @Override
    public Integer insertOneUser(User user) {
        List<User> users = userDao.queryAllUsers();
        if ("admin".equals(user.getUsername())){
            return -1;
        }
        for (User user1 : users) {
            if (user.getUsername().equals(user1.getUsername())){
                return -2;
            }
        }
        return userDao.insertOneUser(user);
    }

    @Override
    public Integer deleteOneUser(Integer userId) {
        return userDao.deleteOneUser(userId);
    }

    @Override
    public Integer updatePassword(User user) {
        return userDao.updatePassword(user);
    }

}
