package method;

import entity.Dept;
import entity.Student;
import global.Global;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

/**
 * Created by dell on 2017/10/22 0022.
 */


/*
* 输出工具类
* */
public class PrintUtils {
 //打印所有的学生对象
    public static void printStudent(List<Student> stulist) throws IOException {
        FileOutputStream fs = new FileOutputStream(new File("D:\\StudentText.txt"));
        PrintStream p = new PrintStream(fs);
        for (int i = 0; i < stulist.size(); i++) {
            p.println("----------------------------");
            p.println("学生学号：" + stulist.get(i).getSt_id());
            p.println("学生姓名：" + stulist.get(i).getSt_name());
            p.println("学生绩点：" + stulist.get(i).getSt_grade());
            String a = "";
            String b = "";
            String c = "";
            for (int j = 0; j < stulist.get(i).getSt_volunter().length; j++) {
                String id = "";
                if (stulist.get(i).getSt_volunter()[j] < 10) {
                    id = "A1000" + stulist.get(i).getSt_volunter()[j];
                }
                if (stulist.get(i).getSt_volunter()[j] >= 10 && stulist.get(i).getSt_volunter()[j] < 100) {
                    id = "A100" + stulist.get(i).getSt_volunter()[j];
                }
                a += id + ",";
            }
            p.println("学生志愿：" + a);
            for (int j = 0; j < 3; j++) {
                b += stulist.get(i).getSt_interest()[j] + ",";
            }
            p.println("学生兴趣" + "," + b);
            for (int j = 0; j < 3; j++) {
                c += stulist.get(i).getSt_time()[j] + ",";
            }
            p.println("学生空闲时间" + "," + c);
        }


    }
    //打印所有的部门对象
    public static  void printDept(List<Dept> deptlist,int d_num[])throws IOException{
        FileOutputStream fs1 = new FileOutputStream(new File("D:\\DeptText.txt"));
        PrintStream p = new PrintStream(fs1);
        int sum=0,j=-1,sum1=0;
        for(int i=0;i<d_num.length;i++){
            sum=sum+d_num[i];
        }
        p.println("部门纳新总人数："+sum);
        p.println("各个部门纳新人数：");
        for(Dept d:deptlist){
            p.println(d.getDept_id()+":"+d_num[++j]);
            sum1+=d.getDept_num();
        }
        p.println("剩余部门总人数："+sum1);
        p.println("----------------------------------");
         int i=-1;
        for(Dept d:deptlist){
            p.println("部门名称："+d.getDept_id());
            p.println("部门纳新人数："+d_num[++i]);
            p.println("部门剩余人数："+d.getDept_num());
            p.println("加入"+d.getDept_id()+"部门的学生信息");
            for(Student s:d.getMyStudent()){
                p.println("学生学号："+s.getSt_id()+" "+"学生姓名："+s.getSt_name()+" "+"学生绩点："+s.getSt_grade());
            }
            p.println("-----------------------------------------------------------------");
        }

    }
    //打印纳新部门人数和学生人数
    public static  void printNum(List<Dept> deptlist,int d_num[])throws IOException{
        FileOutputStream fs1 = new FileOutputStream(new File("D:\\DeptText.txt"));
        PrintStream p = new PrintStream(fs1);
        int sum=0,j=-1,sum1=0;
        for(int i=0;i<d_num.length;i++){
            sum=sum+d_num[i];
        }
        p.println("部门纳新总人数："+sum);
        p.println("各个部门纳新人数：");
        for(Dept d:deptlist){
            p.println(d.getDept_id()+":"+d_num[++j]+"人");
            sum1+=d.getDept_num();
        }
        p.println("剩余部门总人数："+sum1);
    }
    //打印分配好的学生对象
    public static  void printStudentDept(List<Student> studentList)throws IOException{
        //System.out.println("综合人数："+ Global.countStu);
        FileOutputStream fs2 = new FileOutputStream(new File("D:\\StudentDeptText.txt"));
        PrintStream p = new PrintStream(fs2);
        int count=0;
        for(Student s:studentList){

            for(Dept d:s.getMyDept()){
                try{
                    if(d.getDept_id()!=""||d.getDept_id()!=null){
                        p.println("学生学号："+s.getSt_id());
                        p.println("学生姓名："+s.getSt_name());
                        p.println("学生绩点："+s.getSt_grade());
                        p.println("所加入的部门");
                        p.println("部门编号："+d.getDept_id());
                        p.println("-----------------------------------------------------------------");
                        count++;
                    }
                }catch(Exception e){
                }

            }
        }
    }
}
