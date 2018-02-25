package com.phinmaregistraronlinecourse.adapter;

/**
 * Created by Manipon on 02/22/2018.
 */

public class UserData {
    private int id;
    private String emp_id, firstname, middlename,lastname,email,username,password,image;
    private String module1,module2,module3,module4,module5,module6,module7;

    public UserData(int id, String emp_id, String firstname, String middlename, String lastname,String email,String username ,String password,String image, String module1, String module2, String module3, String module4, String module5, String module6, String module7) {
        this.id = id;
        this.emp_id = emp_id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.image = image;
        this.module1 = module1;
        this.module2 = module2;
        this.module3 = module3;
        this.module4 = module4;
        this.module5 = module5;
        this.module6 = module6;
        this.module7 = module7;

    }

    public int getId() {
        return id;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }
    public String getLastname() {
        return lastname;
    }
    public String getEmail() {
        return email;
    }
    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getImage() {
        return image;
    }
    public String getModule1() {
        return module1;
    }
    public String getModule2() {
        return module2;
    }
    public String getModule3() {
        return module3;
    }
    public String getModule4() {
        return module4;
    }
    public String getModule5() {
        return module5;
    }
    public String getModule6() {
        return module6;
    }
    public String getModule7() {
        return module7;
    }
}
