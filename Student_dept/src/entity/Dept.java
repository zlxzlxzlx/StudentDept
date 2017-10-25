package entity;

import global.Global;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/10/21 0021.
 */
public class Dept {

    private  String Dept_id;  //部门编号
    private String [] Dept_tags=new String [5];  //部门标签
    private String [] Dept_time=new String [5];   //部门时间
    private int Dept_num; //部门人数
    private List<Student> myStudent = new ArrayList<Student>(); //当前部门下的学生
    private int st_id;
    public List<Student> getMyStudent() {
        return myStudent;
    }

    public void setMyStudent(List<Student> myStudent) {
        this.myStudent = myStudent;
    }


    public int getDept_num() {
        return Dept_num;
    }

    public void setDept_num(int dept_num) {
        Dept_num = dept_num;
    }
    public void setDept_id(String dept_id) {
        Dept_id = dept_id;
    }



    public void setDept_tags(String[] dept_tags) {
        Dept_tags = dept_tags;
    }

    public void setDept_time(String[] dept_time) {
        Dept_time = dept_time;
    }

    public void setSt_id(int st_id) {
        this.st_id = st_id;
    }

    public String getDept_id() {
        return Dept_id;
    }


    public String[] getDept_tags() {
        return Dept_tags;
    }

    public String[] getDept_time() {
        return Dept_time;
    }

    public int getSt_id() {
        return st_id;
    }
    public  void addStudent(Student  s){
        myStudent.add(s);
    }

}
