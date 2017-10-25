package method;

import entity.Dept;
import entity.Student;
import global.Global;

import java.util.*;

import static global.Global.map;

/**
 * Created by dell on 2017/10/21 0021.
 */
public class CreateMember {
    /*
    * 生成学生对象和部门对象
    * */
 /*

     生成学生学号（唯一）
     * */
    public  String createSid(int i){
        String id="";
        if(i<10)
        {id="17032700"+i;}
        if(i>=10&&i<100) {id="1703270"+i;}
        if(i>=100) {id="170327"+i;}
        return id;
    }
    /*
    * 生成学生姓名
    * */
    public String createSname(){
       String name="";
       String firstName[]={"赵", "钱","孙", "李","周", "吴", "郑", "王", "冯", "陈", "褚","卫","蒋","沈", "韩","杨",
     "朱", "秦", "尤", "许","何","吕", "施", "张","孔", "曹", "严", "华","金", "魏", "陶","姜","柏", "水", "窦", "章",
               "云", "苏", "潘", "葛", "奚", "范", "彭", "郎"
       };
        String lastName[]={"爱","梅","志","芳","光","隽","仙","燕","青","振","杰","卫","东","红","宇","福","平","红","敬","胜","智","水","连","建","云","志","梨","静","妃","飞","平","龙",
                "建","贤","格","虹","娟","腾","鹏","闽","娜","囧","武","少","新","蔚","祥","期","东","震","签","达","斌","艺","云","水","国","威","全"};
        Random random = new Random();
        int first = random.nextInt(firstName.length);
        int last1 = random.nextInt(lastName.length);
        int last2 = random.nextInt(lastName.length);
        name=firstName[first]+lastName[last1]+lastName[last2];
        return name;
    }
    //产生学生的志愿
    public int[] creatVolunter(){
        Random random = new Random ();
        int num=random.nextInt(4)+1;
        int[] volunter = new int[num];
        boolean[]  bool = new boolean[30];
        int randInt = 0;
        for(int i = 0; i < num ; i++) {
            do{
                randInt  = random.nextInt(20);
            }while(bool[randInt]);
            bool[randInt] = true;
            volunter[i]=randInt;
        }
        return volunter;
    }
     /*
     生成学生绩点
     * */
     public float createGrade(){
         Random random = new Random();
         float grade = random.nextFloat()*9+1;
         grade =  (float) ((int)((grade*10000))/10000.0);
         return grade;
     }
    /*生成学生时间
           * */
    public String[] createStime(){
        String time[]={"Mon 10:30-11:30","Mon 16:30-18:00","Mon 20:00-21:30",
                "Tue 10:30-11:30","Tue 16:30-18:00","Tue 20:00-21:30",
                "Web 10:30-11:30","Web 16:30-18:00","Web 20:00-21:30",
                "Thu 10:30-11:30","Thu 16:30-18:00","Thu 20:00-21:30",
                "Fri 10:30-11:30","Fri 16:30-18:00","Fri 20:00-21:30",
                "Sat 10:30-11:30","Sat 16:30-18:00","Sat 20:00-21:30",
                "Sun 10:30-11:30","Sun 16:30-18:00","Sun 20:00-21:30"};
        Random random = new Random();
        int[] volunter = new int[3];
        boolean[]  bool = new boolean[30];
        int randInt = 0;
        for(int i = 0; i < 3 ; i++) {
            do{
                randInt  = random.nextInt(time.length-1);
            }while(bool[randInt]);
            bool[randInt] = true;
            volunter[i]=randInt;
        }
        String Stime[]={time[volunter[0]],time[volunter[1]],time[volunter[2]]};
        return Stime;
    }
    /*生成部门标签
              * */
    public String[] createStags(){
        String tags[]={"singing","dancing","fighting","highing","painting","connecting","happy","grateful",
                "since","joking","studying","loving","basketing","books ","football ","flowers ","traveling",
                "reading","writing","hiking","skating","chatting "};
        Random random = new Random();
        int[] volunter = new int[3];
        boolean[]  bool = new boolean[30];
        int randInt = 0;
        for(int i = 0; i < 3 ; i++) {
            do{
                randInt  = random.nextInt(tags.length-1);
            }while(bool[randInt]);
            bool[randInt] = true;
            volunter[i]=randInt;
        }
        String Stags[]={tags[volunter[0]],tags[volunter[1]],tags[volunter[2]]};
        return Stags;
    }
    /*
        * 产生学生对象列表
        * */
    public List<Student> createAllStudent(String Sid[],Float SGrade[]){
        CreateMember cm = new CreateMember();
        List<Student> studentList= new ArrayList<>();
        for(int i=0;i<300;i++){
           Student s=new Student();
          s.setSt_id((Sid[i]));
            s.setSt_name(cm.createSname());
            s.setSt_volunter(cm.creatVolunter());
            try {
                s.setSt_grade(SGrade[i]);
            } catch(Exception e){
                }
            s.setSt_time(cm.createStime());
            s.setSt_interest(cm.createStags());
            studentList.add(s);
        }
        return studentList;
    }
    public List<Student> createAllSid(){
        CreateMember cm = new CreateMember();
        List<Student> tempdeptList= new ArrayList<>();
        for(int i=0;i<300;i++){
            Student st=new Student();
            st.setSt_id(cm.createSid(i));
            st.setSt_grade(cm.createGrade());
            tempdeptList.add(st);
        }
        return tempdeptList;
    }
    /*生成部门（唯一）
            * */
    public String createDid(int i){
        String id="";
        if(i<10)
        {id="A1000"+i;}
        if(i>=10&&i<100) {id="A100"+i;}
        return id;
    }
    /*生成部门标签
            * */
    public String[] createDtags(){
        String tags[]={"singing","dancing","fighting","highing","painting","connecting","happy","grateful",
                "since","joking","studying","loving","basketing","books ","football ","flowers ","traveling",
                "reading","writing","hiking","skating","chatting "};
        Random random = new Random();
        int[] volunter = new int[3];
        boolean[]  bool = new boolean[30];
        int randInt = 0;
        for(int i = 0; i < 3 ; i++) {
            do{
                randInt  = random.nextInt(tags.length-1);
            }while(bool[randInt]);
            bool[randInt] = true;
            volunter[i]=randInt;
        }
        String Dtags[]={tags[volunter[0]],tags[volunter[1]],tags[volunter[2]]};
        return Dtags;
    }
    /*生成部门时间
            * */
    public String[] createDtime(){
        String time[]={"Mon 10:30-11:30","Mon 16:30-18:00","Mon 20:00-21:30",
                "Tue 10:30-11:30","Tue 16:30-18:00","Tue 20:00-21:30",
                "Web 10:30-11:30","Web 16:30-18:00","Web 20:00-21:30",
                "Thu 10:30-11:30","Thu 16:30-18:00","Thu 20:00-21:30",
                "Fri 10:30-11:30","Fri 16:30-18:00","Fri 20:00-21:30",
                "Sat 10:30-11:30","Sat 16:30-18:00","Sat 20:00-21:30",
                "Sun 10:30-11:30","Sun 16:30-18:00","Sun 20:00-21:30"};
        Random random = new Random();
        int[] volunter = new int[3];
        boolean[]  bool = new boolean[30];
        int randInt = 0;
        for(int i = 0; i < 3 ; i++) {
            do{
                randInt  = random.nextInt(time.length-1);
            }while(bool[randInt]);
            bool[randInt] = true;
            volunter[i]=randInt;
        }

        String Dtime[]={time[volunter[0]],time[volunter[1]],time[volunter[2]]};
        return Dtime;
    }

    /*
    * 产生部门对象列表
    * */
    public List<Dept> createAllDept(){
        CreateMember cm = new CreateMember();
        List<Dept> deptList= new ArrayList<>();
        for(int i=0;i<20;i++){
         Dept d=new Dept();
            d.setDept_id(cm.createDid(i));
            d.setDept_tags(cm.createDtags());
            d.setDept_time(cm.createDtime());
            Random random = new Random();
            int num=random.nextInt(15);
            d.setDept_num(num);
            deptList.add(d);
        }
        return deptList;
    }

}
