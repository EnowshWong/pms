package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.common.utils.CookieUtils;
import com.pms.common.utils.JsonUtils;
import com.pms.mapper.PmsUserStuMapper;
import com.pms.mapper.PmsUserTeaMapper;
import com.pms.pojo.PmsUserStu;
import com.pms.pojo.PmsUserStuExample;
import com.pms.pojo.PmsUserTea;
import com.pms.pojo.PmsUserTeaExample;
import com.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * @author:wong
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private PmsUserStuMapper pmsUserStuMapper;

    @Autowired
    private PmsUserTeaMapper pmsUserTeaMapper;

    @Value("${COOKIE_NICKNAME}")
    private String COOKIE_NICKNAME;
    @Value("${COOKIE_IDENTITY}")
    private String COOKIE_IDENTITY;
    @Value("${COOKIE_ID}")
    private String COOKIE_ID;

    @Override
    public PmsResult stuRegister(PmsUserStu pmsUserStu) {
        //查询username是否重复
        PmsUserStuExample example=new PmsUserStuExample();
        PmsUserStuExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(pmsUserStu.getUsername());
        List<PmsUserStu> list = pmsUserStuMapper.selectByExample(example);
        if (list.size()>0){
            return PmsResult.build(400,"用户名重复");
        }
        Date date=new Date();
        pmsUserStu.setCreated(date);
        pmsUserStu.setUpdated(date);
        //密码md5加密
        pmsUserStu.setPassword(DigestUtils.md5DigestAsHex(pmsUserStu.getPassword().getBytes()));
        pmsUserStuMapper.insert(pmsUserStu);
        return PmsResult.ok();
    }

    @Override
    public PmsResult teaRegister(PmsUserTea pmsUserTea) {
        //查询username和邮箱是否重复
        PmsUserTeaExample example=new PmsUserTeaExample();
        PmsUserTeaExample.Criteria criteria=example.createCriteria();
        criteria.andUsernameEqualTo(pmsUserTea.getUsername());
        criteria.andEmailEqualTo(pmsUserTea.getEmail());
        List<PmsUserTea> list = pmsUserTeaMapper.selectByExample(example);
        if (list.size()>0){
            return PmsResult.build(400,"用户名或邮箱重复");
        }
        Date date=new Date();
        pmsUserTea.setCreated(date);
        pmsUserTea.setUpdated(date);
        //密码md5加密
        pmsUserTea.setPassword(DigestUtils.md5DigestAsHex(pmsUserTea.getPassword().getBytes()));
        pmsUserTeaMapper.insert(pmsUserTea);
        return PmsResult.ok();
    }

    @Override
    public PmsResult login(String username, String password, int identity, HttpServletRequest request, HttpServletResponse response) {
            if (identity==1){//学生登陆
            PmsUserStuExample example=new PmsUserStuExample();
            PmsUserStuExample.Criteria criteria=example.createCriteria();
            if (username==null)
                return PmsResult.build(400,"用户名为空");
            criteria.andUsernameEqualTo(username);
            List<PmsUserStu> list = pmsUserStuMapper.selectByExample(example);
            if (list==null||list.size()==0){
                return PmsResult.build(400,"用户名错误");
            }
            PmsUserStu pmsUserStu=list.get(0);
            //如果密码错误
            if (!pmsUserStu.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
                return PmsResult.build(400,"密码错误");
            }
            //存入用户信息
            CookieUtils.setCookie(request,response,COOKIE_NICKNAME,pmsUserStu.getNickname());
            //存入用户id
            CookieUtils.setCookie(request,response,COOKIE_ID,pmsUserStu.getId()+"");
            //存入用户身份
            CookieUtils.setCookie(request,response,COOKIE_IDENTITY,identity+"");
            return PmsResult.ok(identity);
        }
        else if (identity==2){//教师登陆
            PmsUserTeaExample example=new PmsUserTeaExample();
            PmsUserTeaExample.Criteria criteria=example.createCriteria();
            if (username==null)
                return PmsResult.build(400,"用户名为空");
            criteria.andUsernameEqualTo(username);
            List<PmsUserTea> list = pmsUserTeaMapper.selectByExample(example);
            if (list==null||list.size()==0){
                return PmsResult.build(400,"用户名错误");
            }
            PmsUserTea pmsUserTea=list.get(0);
            //如果密码错误
            if (!pmsUserTea.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
                return PmsResult.build(400,"密码错误");
            }
            //存入用户信息
            CookieUtils.setCookie(request,response,COOKIE_NICKNAME,pmsUserTea.getNickname());
            //存入用户id
            CookieUtils.setCookie(request,response,COOKIE_ID,pmsUserTea.getId()+"");
            //存入用户身份
            CookieUtils.setCookie(request,response,COOKIE_IDENTITY,String.valueOf(identity));
            return PmsResult.ok(identity);
        }
        return PmsResult.build(400,"未传入参数identity");
    }

    @Override
    public PmsResult sucJoin(long stuId, long expId, long tutorId) {
        PmsUserStu userStu=new PmsUserStu();
        userStu.setId(stuId);
        userStu.setExpId(expId);
        userStu.setTutorId(tutorId);
        pmsUserStuMapper.updateByPrimaryKeySelective(userStu);
        return PmsResult.ok();
    }

    @Override
    public List<PmsUserStu> getStulistByExpId(long expId) {
        PmsUserStuExample example=new PmsUserStuExample();
        PmsUserStuExample.Criteria criteria=example.createCriteria();
        criteria.andExpIdEqualTo(expId);
        List<PmsUserStu> list = pmsUserStuMapper.selectByExample(example);
        return list;
    }
}
