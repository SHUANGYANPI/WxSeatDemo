package demo.pojo;

import org.springframework.stereotype.Component;

@Component("user")
public class User {
    private int uid;
    private String name;
    private String no;
    private String sex;
    private String phone;
    private String QQ;
    private String password;
    private String shenfenzheng;

    public int getUid() {
        return uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getShenfenzheng() {
        return shenfenzheng;
    }

    public void setShenfenzheng(String shenfenzheng) {
        this.shenfenzheng = shenfenzheng;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", name='" + name + '\'' +
                ", no='" + no + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", QQ='" + QQ + '\'' +
                ", password='" + password + '\'' +
                ", shenfenzheng='" + shenfenzheng + '\'' +
                '}';
    }
}
