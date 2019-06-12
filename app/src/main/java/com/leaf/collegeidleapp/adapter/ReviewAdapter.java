package com.leaf.collegeidleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.leaf.collegeidleapp.R;
import com.leaf.collegeidleapp.bean.Review;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * 评论的适配器
 * @author autumn_leaf
 */
public class ReviewAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater layoutInflater;

    private LinkedList<Review> reviews = new LinkedList<>();
    HashMap<Integer,View> location = new HashMap<>();


    public ReviewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setData(LinkedList<Review> reviews) {
        this.reviews = reviews;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return reviews.size();
    }

    @Override
    public Object getItem(int position) {
        return reviews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /**
     * 获取视图
     * @param position 位置
     * @param convertView 当前的视图
     * return convertView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if(location.get(position) == null) {
            convertView = layoutInflater.inflate(R.layout.layout_commodity_review,null);
            Review review = (Review) getItem(position);
            holder = new ViewHolder(convertView,review);
            location.put(position,convertView);
            convertView.setTag(holder);
        }else {
            convertView = location.get(position);
            holder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }

    /**
     * 静态ViewHolder类
     */
    static class ViewHolder {

        TextView tvStuId,tvTime,tvContent;

        public ViewHolder(View itemView, Review review) {
            tvStuId = itemView.findViewById(R.id.tv_number);
            tvTime = itemView.findViewById(R.id.tv_current_time);
            tvContent = itemView.findViewById(R.id.tv_comment);
            tvStuId.setText(review.getStuId());
            tvTime.setText(review.getCurrentTime());
            tvContent.setText(review.getContent());
        }
    }
}
