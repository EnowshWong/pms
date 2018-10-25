package com.pms.service.impl;

import com.pms.common.pojo.PmsResult;
import com.pms.common.utils.CookieUtils;
import com.pms.mapper.PmsUserStuMapper;
import com.pms.mapper.PmsUserTeaMapper;
import com.pms.pojo.*;
import com.pms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    @Value("${COOKIE_EXPID}")
    private String COOKIE_EXPID;

    @Override
    public List<StuPlan> getStuPlanListByExpId(long expId) {
        List<StuPlan> list = pmsUserStuMapper.findStuPlanListByExpId(expId);
        return list;
    }

    @Override
    public PmsResult stuRegister(PmsUserStu pmsUserStu,HttpServletRequest request,HttpServletResponse response) {
        //查询username是否重复
        PmsUserStuExample example = new PmsUserStuExample();
        PmsUserStuExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(pmsUserStu.getUsername());
        List<PmsUserStu> list = pmsUserStuMapper.selectByExample(example);
        if (list.size() > 0) {
            return PmsResult.build(400, "用户名重复");
        }
        Date date = new Date();
        pmsUserStu.setCreated(date);
        pmsUserStu.setUpdated(date);
        //密码md5加密
        pmsUserStu.setPassword(DigestUtils.md5DigestAsHex(pmsUserStu.getPassword().getBytes()));
//        //将新插入数据的主键返回到对象中
        pmsUserStuMapper.insert(pmsUserStu);
//        System.out.println(pmsUserStu.getId());
//        //存入用户id
//        CookieUtils.setCookie(request, response, COOKIE_ID, pmsUserStu.getId() + "");
        return PmsResult.ok();
    }

    @Override
    public PmsResult teaRegister(PmsUserTea pmsUserTea) {
        //查询username和邮箱是否重复
        PmsUserTeaExample example = new PmsUserTeaExample();
        PmsUserTeaExample.Criteria criteria = example.createCriteria();
        criteria.andUsernameEqualTo(pmsUserTea.getUsername());
        criteria.andEmailEqualTo(pmsUserTea.getEmail());
        List<PmsUserTea> list = pmsUserTeaMapper.selectByExample(example);
        if (list.size() > 0) {
            return PmsResult.build(400, "用户名或邮箱重复");
        }
        Date date = new Date();
        pmsUserTea.setCreated(date);
        pmsUserTea.setUpdated(date);
        //密码md5加密
        pmsUserTea.setPassword(DigestUtils.md5DigestAsHex(pmsUserTea.getPassword().getBytes()));
        pmsUserTeaMapper.insert(pmsUserTea);
        return PmsResult.ok();
    }

    @Override
    public PmsResult login(String username, String password, int identity, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        if (identity == 1) {//学生登陆
            PmsUserStuExample example = new PmsUserStuExample();
            PmsUserStuExample.Criteria criteria = example.createCriteria();
            if (username == null)
                return PmsResult.build(400, "用户名为空");
            criteria.andUsernameEqualTo(username);
            List<PmsUserStu> list = pmsUserStuMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                return PmsResult.build(400, "用户名错误");
            }
            PmsUserStu pmsUserStu = list.get(0);
            //如果密码错误
            if (!pmsUserStu.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
                return PmsResult.build(400, "密码错误");
            }
            //存入用户id
            CookieUtils.setCookie(request, response, COOKIE_ID, pmsUserStu.getId() + "");
            //存入用户身份
            CookieUtils.setCookie(request, response, COOKIE_IDENTITY, identity + "");
            //存入用户所属实验室id
            CookieUtils.setCookie(request,response,COOKIE_EXPID,pmsUserStu.getExpId()+"");
            //判断学生是否加入了实验室
            if (pmsUserStu.getExpId()==null)
                return PmsResult.build(500,"未加入实验室");
            return PmsResult.ok(pmsUserStu);
        } else if (identity == 2) {//教师登陆
            PmsUserTeaExample example = new PmsUserTeaExample();
            PmsUserTeaExample.Criteria criteria = example.createCriteria();
            if (username == null)
                return PmsResult.build(400, "用户名为空");
            criteria.andUsernameEqualTo(username);
            List<PmsUserTea> list = pmsUserTeaMapper.selectByExample(example);
            if (list == null || list.size() == 0) {
                return PmsResult.build(400, "用户名错误");
            }
            PmsUserTea pmsUserTea = list.get(0);
            //如果密码错误
            if (!pmsUserTea.getPassword().equals(DigestUtils.md5DigestAsHex(password.getBytes()))) {
                return PmsResult.build(400, "密码错误");
            }
            //存入用户id
            CookieUtils.setCookie(request, response, COOKIE_ID, pmsUserTea.getId() + "");
            //存入用户身份
            CookieUtils.setCookie(request, response, COOKIE_IDENTITY, String.valueOf(identity));
            return PmsResult.ok(pmsUserTea);
        }
        return PmsResult.build(400, "未传入参数identity");
    }

    @Override
    public PmsResult sucJoin(long stuId, long expId, long tutorId,HttpServletRequest request,HttpServletResponse response) {
        PmsUserStu userStu = new PmsUserStu();
        userStu.setId(stuId);
        userStu.setExpId(expId);
        userStu.setTutorId(tutorId);
        pmsUserStuMapper.updateByPrimaryKeySelective(userStu);
        //记录EXP_ID
        CookieUtils.setCookie(request,response,COOKIE_EXPID,expId+"");
        return PmsResult.ok();
    }

    @Override
    public List<PmsUserStu> getStulistByExpId(long expId) {
        PmsUserStuExample example = new PmsUserStuExample();
        PmsUserStuExample.Criteria criteria = example.createCriteria();
        criteria.andExpIdEqualTo(expId);
        List<PmsUserStu> list = pmsUserStuMapper.selectByExample(example);
        return list;
    }

    @Override
    public PmsResult stuUpdate(PmsUserStu pmsUserStu) {
        pmsUserStuMapper.updateByPrimaryKeySelective(pmsUserStu);
        return PmsResult.ok();
    }

    @Override
    public PmsResult logout(HttpServletRequest request, HttpServletResponse response) {
        //删除cookie,返回首页
        Cookie[] cookies = request.getCookies();
        if (cookies.length > 0) {
            CookieUtils.deleteCookie(request, response, "COOKIE_ID");
            CookieUtils.deleteCookie(request, response, "COOKIE_IDENTITY");
            CookieUtils.deleteCookie(request, response, "COOKIE_NICKNAME");
        }
        return PmsResult.ok();
    }

    @Override
    public PmsUserStu getStuById(long stuId) {
        PmsUserStu pmsUserStu = pmsUserStuMapper.selectByPrimaryKey(stuId);
        return pmsUserStu;
    }

    @Override
    public List<PmsUserTea> getTeaList() {
        PmsUserTeaExample example=new PmsUserTeaExample();
        List<PmsUserTea> list = pmsUserTeaMapper.selectByExample(example);
        return list;
    }

    @Override
    public PmsUserTea getTeaById(long id) {
        PmsUserTea tea = pmsUserTeaMapper.selectByPrimaryKey(id);
        return tea;
    }

    @Override
    public StuInfo getStuInfoById(long id) {
        StuInfo stu = pmsUserStuMapper.findStuInfoById(id);
        return stu;
    }

    @Override
    public List<PmsUserStu> getStuListWithoutExp() {
        PmsUserStuExample example=new PmsUserStuExample();
        PmsUserStuExample.Criteria criteria=example.createCriteria();
        criteria.andExpIdIsNull();
        List<PmsUserStu> list = pmsUserStuMapper.selectByExample(example);
        //取8条数据
        if (list.size()>=8)
            return list.subList(0,7);
        else return list;
    }
}
