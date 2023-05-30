package com.example.lmsapp4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ViewAdpterModel extends RecyclerView.Adapter<ViewAdpterModel.MyViewHolder> {

    Context context;
    ArrayList<SenderModel> list;

    public ViewAdpterModel(Context context, ArrayList<SenderModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.viewmodel,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        SenderModel senderModel=list.get(position);
        holder.name.setText(senderModel.getName().toString());
        holder.indexNo.setText(senderModel.getIndexNo().toString());
        holder.activityType.setText(senderModel.getActivityType().toString());
        holder.degreeType.setText(senderModel.getDegreeType().toString());
        holder.batchesName.setText(senderModel.getBatchesName().toString());
        holder.moduleNam.setText(senderModel.getModuleNam().toString());
        holder.stuMarks.setText(senderModel.getStuMarks().toString());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,indexNo,activityType,degreeType,batchesName,moduleNam,stuMarks;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nameview);
            indexNo=itemView.findViewById(R.id.indexnoview);
            activityType=itemView.findViewById(R.id.activityview);
            degreeType = itemView.findViewById(R.id.degreeview);
            batchesName = itemView.findViewById(R.id.batchview);
            moduleNam=itemView.findViewById(R.id.moduleview);
            stuMarks=itemView.findViewById(R.id.stumarksview);




        }
    }

}
