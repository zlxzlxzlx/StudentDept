package method;

import entity.Dept;
import entity.Student;
import global.Global;

import java.util.*;

/**
 * Created by dell on 2017/10/22 0022.
 */
public class Matching {
    public static void allocteStudent(int round) {
        Iterator<Student> studentIterator = Global.studentList.iterator();
        Map<String,String> DeptMap = new HashMap<String,String>();
        while (studentIterator.hasNext()) {
            Student student = studentIterator.next();
            int[] str = student.getSt_volunter();
            String [] Sinterest = student.getSt_interest();
            String [] time=student.getSt_time();
            String volunter = "";
            try{
                if (str[round]>=0&&str[round] < 10) {
                    volunter = "A1000" + str[round];
                }
                if (str[round] >= 10 && str[round] < 20) {
                    volunter = "A100" + str[round];
                }
                for (Dept dept : Global.deptList) {
                    // 学生第round个志愿与部门匹配
                    String [] dept_time=dept.getDept_time();
                    String [] Dinterest = dept.getDept_tags();
                    if (volunter!=""&&volunter.equals(dept.getDept_id())&&dept.getDept_num()>0) {
                    if(time[0].equals(dept_time[0])||time[0].equals(dept_time[1])||time[0].equals(dept_time[2])||time[1].equals(dept_time[0])
                                ||time[1].equals(dept_time[1])||time[1].equals(dept_time[2])||time[2].equals(dept_time[0])||time[2].equals(dept_time[1])||time[2].equals(dept_time[2])) {
                            if(Sinterest[0].equals(Dinterest[0])||Sinterest[0].equals(Dinterest[1])||Sinterest[0].equals(Dinterest[2])||Sinterest[1].equals(Dinterest[0])
                                    ||Sinterest[1].equals(Dinterest[1])||Sinterest[1].equals(Dinterest[2])||Sinterest[2].equals(Dinterest[0])||Sinterest[2].equals(Dinterest[1])||Sinterest[2].equals(Dinterest[2])){
                                dept.setDept_num(dept.getDept_num()-1);
                                dept.addStudent(student);
                                student.addDept(dept);
                            }

                        }
                    }
                }
            }catch(Exception e){
            }
        }

    }
}
