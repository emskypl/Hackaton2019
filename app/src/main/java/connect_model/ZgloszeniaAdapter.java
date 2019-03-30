package connect_model;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.hackaton2019.R;

import java.util.List;


public class ZgloszeniaAdapter extends RecyclerView.Adapter<connect_model.ZgloszeniaAdapter.ZgloszeniaViewHolder> {


    //this context we will use to inflate the layout
    private Context ctx;

    //we are storing all the post in a list
    private List<Zgloszenia> zgloszeniaList;

    //getting the context and product list with constructor
    public ZgloszeniaAdapter(Context ctx, List<Zgloszenia> zgloszeniaList) {
        this.ctx = ctx;
        this.zgloszeniaList = zgloszeniaList;
    }

    @Override
    public connect_model.ZgloszeniaAdapter.ZgloszeniaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(ctx);
        View view = inflater.inflate(R.layout.problem_record_layout, null);
        return new connect_model.ZgloszeniaAdapter.ZgloszeniaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(connect_model.ZgloszeniaAdapter.ZgloszeniaViewHolder holder, int position) {
        //getting the product of the specified position
        Zgloszenia zgloszenia = zgloszeniaList.get(position);
        //binding the data with the viewholder views
        holder.textViewTitle.setText(String.valueOf(zgloszenia.getNotificationName()));
        holder.textViewDescription.setText(String.valueOf(zgloszenia.getDescription()));
        holder.textViewData.setText(String.valueOf(zgloszenia.getNotificationTime()));
        holder.textViewStatus.setText(String.valueOf(zgloszenia.getIdStatus()));
    }


    @Override
    public int getItemCount() {
        return zgloszeniaList.size();
    }

    class ZgloszeniaViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewDescription, textViewData, textViewStatus;

        public ZgloszeniaViewHolder(View itemView) {
            super(itemView);
            textViewTitle= itemView.findViewById(R.id.textViewNotificationName);
            textViewDescription= itemView.findViewById(R.id.textViewNotificationType);
            textViewData = itemView.findViewById(R.id.textViewNotificationData);
            textViewStatus = itemView.findViewById(R.id.textViewNotificationStatus);

        }
    }
}