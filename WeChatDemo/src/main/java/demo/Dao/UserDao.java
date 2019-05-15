package demo.Dao;

import demo.pojo.User;

import java.util.Map;


public interface UserDao {
    Map<String,Object> FindUserById(int id);//根据id查询用户信息
    Map<String,Object> FindUserByNo(String no);//根据学号查询用户信息
    Map<String,Object> FindUserByName(String name);//根据姓名查询用户信息
    Map<String,Object> FindAllUser();//查找所有用户
    Map<String,Object> Register(User user);//注册用户,若注册成功，返回ture
    Map<String,Object> upDate(String shenFenZheng,String newPassword);//修改密码时通过身份证号修改
    Map<String,Object> FindUserByShenFenZheng(String shenFenZheng);//获取身份证号并判断是否在数据库中
}