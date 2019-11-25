package demo.Service;

import demo.pojo.User;

import java.util.Map;

public interface UserService {
    Map<String,Object> FindUserById(int id);//根据id查询用户信息
    Map<String,Object> FindUserByNo(String no);//根据学号查询用户信息
    Map<String,Object> FindUserByName(String name);//根据姓名查询用户信息
    Map<String,Object> FindAllUser();//查找所有用户
    Map<String,Object> Register(User user);//注册用户,若注册成功，返回ture
    Map<String,Object> upDate(String shenFenZheng,String newPassword);
    Map<String,Object> FindUserByuno(String uno);//通过学号查询用户密码
    Map<String,Object> CheckUserNo(String no);
}