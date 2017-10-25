import entity.Dept;
import entity.Student;
import global.Global;
import javafx.event.ActionEvent;
import method.CreateMember;
import method.Matching;
import method.PrintUtils;
import method.SetStudentGrade;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Set;

import static global.Global.map;

public   class Main extends JFrame implements ActionListener{

    JLabel interestLabel = new JLabel("选择匹配条件：");
    JCheckBox badmintonCheck = new JCheckBox("绩点优先");
    JCheckBox tableTtennisCheck = new JCheckBox("可用时间");
    JCheckBox singCheck = new JCheckBox("兴趣标签");
    JTextArea textArea = new JTextArea(5, 25);
    Main() {

        super("学生部门匹配算法");
        Container contentPane = getContentPane();

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 1));

        Box box1 = Box.createHorizontalBox();
        Box box2 = Box.createHorizontalBox();

        box1.add(Box.createHorizontalStrut(3));
        box1.add(interestLabel);
        box1.add(badmintonCheck);
        box1.add(tableTtennisCheck);
        box1.add(singCheck);

        box2.add(Box.createHorizontalStrut(3));

        northPanel.add(box1);
        northPanel.add(box2);
        contentPane.add(northPanel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(textArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        badmintonCheck.addActionListener(this);
        tableTtennisCheck.addActionListener(this);
        singCheck.addActionListener(this);


        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
    }
    int  d_num[]=new int [20];

    public   void actionPerformed (java.awt.event.ActionEvent e) {
        CreateMember cm = new CreateMember();
        Global.deptList = cm.createAllDept();
        Global.tempdeptList = cm.createAllSid();//存放学号，绩点进行排序
        map= SetStudentGrade.setStudentGrade();
        Set<Float> keySet =  map.keySet();
        Iterator<Float> iter = keySet.iterator();
        String Sid[]=new String [300];
        Float SGrade[]=new Float [300];
        int i=0,k=0;
        while (iter.hasNext()) {
            Float key = iter.next();
            Sid[i]=map.get(key);
            SGrade[k]=key;
            i++;
            k++;
        }
        Global.studentList = cm.createAllStudent(Sid,SGrade);//生成所有学生信息
        try {
            PrintUtils.printStudent( Global.studentList); //打印学生信息
        } catch (Exception a) {
            a.printStackTrace();
        }
        for(int j=0;j<20;j++){
            d_num[j]=Global.deptList.get(j).getDept_num();
        }
          if (badmintonCheck.isSelected() == true) {
            if (tableTtennisCheck.isSelected() == true) {
                if (singCheck.isSelected() == true) {
                    textArea.setText("");
                    for(int round=0;round<5;round++){
                        Matching.allocteStudent(round);//分配算法
                    }
                    c();
                    a();
                    try {
                        PrintUtils.printDept( Global.deptList,d_num);//打印部门信息
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                    b();
                    try {
                        PrintUtils.printStudentDept( Global.studentList); //打印学生信息
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                }
            }
        }
        else  {
            return;
        }
    }

  public  void a(){
      int l=-1;

      for(Dept d:Global.deptList){
          textArea.append("部门名称："+d.getDept_id()+"\n");
          textArea.append("部门纳新人数："+d_num[++l]+"\n");
          textArea.append("部门剩余人数："+d.getDept_num()+"\n");
          textArea.append("加入"+d.getDept_id()+"部门的学生信息"+"\n");
          for(Student s:d.getMyStudent()){
              textArea.append("学生学号："+s.getSt_id()+" "+"学生姓名："+s.getSt_name()+" "+"学生绩点："+s.getSt_grade()+"\n");
          }
          textArea.append("-----------------------------------------------------------------"+"\n");
      }
  }
    public  void b(){
        for(Student s:Global.studentList){
            textArea.append("学生学号："+s.getSt_id()+"\n");
            textArea.append("学生姓名："+s.getSt_name()+"\n");
            textArea.append("学生绩点："+s.getSt_grade()+"\n");
            for(Dept d:s.getMyDept()){
                try{
                    if(d.getDept_id()!=""||d.getDept_id()!=null){
                        textArea.append("部门编号："+d.getDept_id()+"\n");
                    }
                }catch(Exception e){
                }
            }
            textArea.append("-----------------------------------------------------------------"+"\n");
        }
  }
    public  void c(){
        int sum=0,j=-1,sum1=0;
        for(int i=0;i<d_num.length;i++){
            sum=sum+d_num[i];
        }
        for(Dept d:Global.deptList){
            sum1+=d.getDept_num();
        }
        textArea.append("部门纳新总人数："+sum+"\n");
        textArea.append("剩余部门总人数："+sum1+"\n");
  }
    public  static void main(String[] args) {
          new Main();

    }

}
