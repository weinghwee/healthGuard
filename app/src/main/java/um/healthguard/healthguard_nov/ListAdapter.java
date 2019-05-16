package um.healthguard.healthguard_nov;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {

    Context context;
    ArrayList<exercise> workoutList;



    public ListAdapter(Context context, ArrayList<exercise> workoutList) {
        //super(context, R.layout.single_list_app_item, utilsArrayList);
        this.context = context;
        this.workoutList = workoutList;


    }

    @Override
    public int getCount() {
        return workoutList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        ViewHolder viewHolder;

        final View result;

        if (convertView == null) {

            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.plan, parent, false);
            viewHolder.plan_num = (TextView) convertView.findViewById(R.id.plan_name);
            viewHolder.plan_picture = (ImageView) convertView.findViewById(R.id.plan_img);

            result = convertView;

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }

        viewHolder.plan_num.setText(workoutList.get(position).name);
        viewHolder.plan_picture.setImageResource(workoutList.get(position).img_path);


//        viewHolder.plan_picture.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//                Intent intent = new Intent(context, displayExercise.class);
//                Bundle args = new Bundle();
//                args.putSerializable("ARRAYLIST",(Serializable)workoutList.get(position).myList);
//                intent.putExtra("BUNDLE",args);
//                context.startActivity(intent);
//
//
//            }
//        });

        return convertView;
    }

    private static class ViewHolder {

        TextView plan_num;
        ImageView plan_picture;

    }
}
