package um.healthguard.healthguard_nov;

import java.util.ArrayList;

public class workout_plan {
    int img_path;
    String plan_num;
    ArrayList<exercise> myList;
    ArrayList<String> myVideoPathList;

    workout_plan(int a, String b, ArrayList<exercise> c, ArrayList<String> d){
        img_path=a;
        plan_num=b;
        myList=c;
        myVideoPathList=d;


    }
}
