package com.jwala.recyclerviewbasicexampleonclick;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<EmployeeModel> employeeModelList;
    private OnClickListener mOnClickListener;

    public RecyclerViewAdapter(Context context, List<EmployeeModel> employeeModelList, OnClickListener mOnClickListener) {
        this.context = context;
        this.employeeModelList = employeeModelList;
        this.mOnClickListener = mOnClickListener;
    }

//    public RecyclerViewAdapter(Context context, List<EmployeeModel> employeeModelList) {
//        this.context = context;
//        this.employeeModelList = employeeModelList;
//    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inflating_layout, viewGroup, false);
        return new ViewHolder(view, mOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EmployeeModel employee = employeeModelList.get(position);
        holder.tv_id.setText(String.valueOf(employee.getId()));
        holder.tv_name.setText(employee.getName());
        holder.iv_image.setImageResource(employee.getImage());

    }

    @Override
    public int getItemCount() {
        return employeeModelList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_id;
        private TextView tv_name;
        private ImageView iv_image;
        private OnClickListener onClickListener;


        public ViewHolder(@NonNull View itemView, OnClickListener onClickListener) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_name = itemView.findViewById(R.id.tv_name);
            iv_image = itemView.findViewById(R.id.iv_image);
           this.onClickListener = onClickListener;

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnClickListener {
        void onItemClick(int position);
    }

}
