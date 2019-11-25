package demo.pojo;

import org.springframework.stereotype.Component;

@Component
public class Login {
    private String uname;
    private String uno;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    @Override
    public String toString() {
        return "Login{" +
                "uname='" + uname + '\'' +
                ", uno='" + uno + '\'' +
                '}';
    }
}
