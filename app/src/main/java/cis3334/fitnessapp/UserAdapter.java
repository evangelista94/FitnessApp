package cis3334.fitnessapp;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by evangelistachicheko on 4/27/17.
 */


public class UserAdapter extends ArrayAdapter<User> {

    private List<User> userList;            // The list of users to display
    private Context context;                // The original activity that displays this
    private int layoutResource;                   // the layout to use

    /**
     *   Basic constructor
     * @param context - The activity calling this
     * @param resource  The layout to use to display
     * @param userList  The list of users to display
     */
    public UserAdapter(Context context, int resource, List<User> userList) {
        super(context, resource, userList);
        this.context = context;
        this.layoutResource = resource;
        this.userList = userList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get the users we are displaying
        User user = userList.get(position);
        View view;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        view = inflater.inflate(R.layout.user_row_layout, null);

        TextView tvName=(TextView)view.findViewById(R.id.textViewName);
        TextView tvAge = (TextView)view.findViewById(R.id.textViewAge);
        TextView tvWeight=(TextView)view.findViewById(R.id.textViewWeight);
        TextView tvHeight=(TextView)view.findViewById(R.id.textViewHeight);
        TextView tvBloodPressure=(TextView)view.findViewById(R.id.textViewBloodPressure);
        TextView tvHeartRate=(TextView)view.findViewById(R.id.textViewHeartRate);
        TextView tvDate=(TextView)view.findViewById(R.id.textViewDate);
        tvName.setText(user.getName());
        tvAge.setText(user.getAge());
        tvWeight.setText(user.getWeight());
        tvHeight.setText(user.getHeight());
        tvBloodPressure.setText(user.getBloodPressure());
        tvHeartRate.setText(user.getHeartRate());
        tvDate.setText(user.getDate());

        return(view);
    }


}