package entity;

import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2017/10/21 0021.
 */
public class Student {
    private String St_id; //学号
    private String St_name;  //名字
    private float St_grade;  //成绩
    private int [] St_volunter = new int[5];  //学生志愿
    private String [] St_interest=new String [5]; //兴趣标签
    private String [] St_time=new String [5]; //可用时间段
    private List<Dept> myDept = new ArrayList<Dept>(); //当前学生所在部门
    private  String [] Dept_id=new String [5]; // 已选中部门编号
    public void setMyDept(List<Dept> myDept) {
        this.myDept = myDept;
    }
    public List<Dept> getMyDept() {
        return myDept;
    }

    public void setDept_id(String[] dept_id) {
        Dept_id = dept_id;
    }
    public String[] getDept_id() {
        return Dept_id;
    }
    public void setSt_id(String st_id) {
        St_id = st_id;
    }
    public void setSt_name(String st_name) {
        St_name = st_name;
    }
    public void setSt_grade(float st_grade) {
        St_grade = st_grade;
    }

    public void setSt_volunter(int[] st_volunter) {
        St_volunter = st_volunter;
    }

    public void setSt_interest(String[] st_interest) {
        St_interest = st_interest;
    }

    public void setSt_time(String[] st_time) {
        St_time = st_time;
    }



    public String getSt_id() {
        return St_id;
    }

    public String getSt_name() {
        return St_name;
    }

    public float getSt_grade() {
        return St_grade;
    }

    public int[] getSt_volunter() {
        return St_volunter;
    }

    public String[] getSt_interest() {
        return St_interest;
    }

    public String[] getSt_time() {
        return St_time;
    }


    public  void addDept(Dept  d){
        myDept.add(d);
    }

}
