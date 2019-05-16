package um.healthguard.healthguard_nov;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private Activity activity ;
    private ArrayList<workout_plan> plans;

    public RecyclerViewAdapter(Activity mContext, ArrayList<workout_plan> plans){
        this.activity=mContext;
        this.plans=plans;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        LayoutInflater myInflater= LayoutInflater.from(activity);
        view=myInflater.inflate(R.layout.exercise,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int i) {

        holder.plan_name.setText(plans.get(i).plan_num);
        holder.plan_picture.setImageResource(plans.get(i).img_path);
        holder.planPoster.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(activity, displayExercise.class);
                intent.putParcelableArrayListExtra("key", (ArrayList<? extends Parcelable>)plans.get(i).myList);
                intent.putStringArrayListExtra("videoPaths", plans.get(i).myVideoPathList);

                activity.startActivity(intent);


            }
        });
//        File imgFile = new  File(exercises.get(i).img_path);
//
//        if(imgFile.exists()){
//
//            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
//
//            holder.exercise_picture.setImageBitmap(myBitmap);
//
//        }
//        holder.exercisePoster.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                Intent intent = new Intent(myContext, displayExercise.class);
//                myContext.startActivity(intent);
//
//
//            }
//        });


    }



    @Override
    public int getItemCount() {
        return plans.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView plan_name;
        CardView planPoster;
        ImageView plan_picture;

        public MyViewHolder(View myMovie){
            super(myMovie);
            plan_name=(TextView)myMovie.findViewById(R.id.exercise_name);
            planPoster=(CardView)myMovie.findViewById(R.id.cardViewExercise);
            plan_picture=(ImageView)myMovie.findViewById(R.id.exercise_img);
        }
    }


}
