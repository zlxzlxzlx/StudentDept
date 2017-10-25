package method;



import entity.Student;
import global.Global;

import java.util.*;



/**
 * Created by dell on 2017/10/22 0022.
 */


/*对学生绩点进行排序*/
public class SetStudentGrade {

    public  static  Map<Float,String> setStudentGrade( ){

        Map<Float,String> map = new TreeMap<Float,String >(
                new Comparator<Float>() {
                    public int compare(Float obj1, Float obj2) {
                        // 降序排序
                        return obj2.compareTo(obj1);
                    }
                });

        for (int i = 0; i < Global.tempdeptList.size(); i++) {
            String id = Global.tempdeptList.get(i).getSt_id();
            map.put(Global.tempdeptList.get(i).getSt_grade(),id );
        }
        return map;

    }

}
