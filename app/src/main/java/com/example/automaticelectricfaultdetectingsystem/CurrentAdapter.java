package com.example.automaticelectricfaultdetectingsystem;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import static android.content.ContentValues.TAG;

public class CurrentAdapter extends RecyclerView.Adapter<CurrentAdapter.CurrentViewHolder> {
    String noLoad = "No load";
    String good = "System safe";
    String lowVoltage = "Low Voltage or Burnt Wire";
    String excessVoltage = "High voltage";

    private List<CurrentValue> currentValueList;

    public CurrentAdapter(CurrentFeeds feeds) {
        this.currentValueList = feeds.getFeeds();

        for (CurrentValue Original : currentValueList){
            Log.v("Current Adapter", "current value ==>"+Original.getField1());
            Log.v("Current Adapter", "current status ==>"+Original.getField2());
            Log.v("Current Adapter", "current time ==>"+Original.getCreated_at().toString());
        }
    }

    @NonNull
    @Override
    public CurrentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.display,parent,false);
        return new CurrentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrentViewHolder holder, int position) {
        CurrentValue myCurrentClass = currentValueList.get(position);
        holder.binding(myCurrentClass);
    }

    @Override
    public int getItemCount() {
        Log.v("CurrentAdapter", "List size ==>"+currentValueList.size());
        return currentValueList.size();

    }

    public class CurrentViewHolder extends RecyclerView.ViewHolder {

        TextView currentValue;
        TextView currentStatus;
        TextView createdTime;

        public CurrentViewHolder(@NonNull View itemView) {
            super(itemView);
            currentValue = itemView.findViewById(R.id.current_value);
            currentStatus = itemView.findViewById(R.id.current_status);
            createdTime = itemView.findViewById(R.id.time_created);
        }

        public void binding(CurrentValue myCurrentClass){
            currentValue.setText(myCurrentClass.getField1());
            Log.v("MainActivity", "Current value ==>" +currentValue);

            int statusNumber = Integer.valueOf(myCurrentClass.getField2());

            if (statusNumber == 5) {
                currentStatus.setText(noLoad);
                Log.v("MainActivity", "Current Status ==>" +currentStatus);
            }

            else if (statusNumber == 0) {
                currentStatus.setText(good);
            }

            else if (statusNumber==1) {
                currentStatus.setText(lowVoltage);
            }

           else if (statusNumber == 2){
                currentStatus.setText(excessVoltage);
           }else{
               currentStatus.setText("Signal not Identified");
            }

            createdTime.setText(myCurrentClass.getCreated_at().toString());

        }
    }
}
