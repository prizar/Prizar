package com.prizar.drawsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prizar.R;
import com.prizar.model.drawsearch.DrawList;

import java.util.List;

public class BondListAdapter extends RecyclerView.Adapter<BondListAdapter.SearchViewHolder> {
    Context context;
    List<DrawList> drawList;

    public interface Onclick {
        void onEvent(DrawList drawList, int pos);
    }

    public BondListAdapter(Context context, List<DrawList> drawList) {
        this.context = context;
        this.drawList = drawList; }

    View view;

    @Override
    public BondListAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.draw_list, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(BondListAdapter.SearchViewHolder holder, final int position) {
        final DrawList drawLists = drawList.get(position);
        if (drawLists.getCity() != null) {
            holder.city.setText(drawLists.getCity());
        }
        if (drawLists.getDenominations() != null) {
            holder.denominations.setText(drawLists.getDenominations());
        }
        if (drawLists.getDrawDate() != null) {
            holder.draw_date.setText(drawLists.getDrawDate());
        }
        if (drawLists.getPrizeNumber() != null) {
            holder.prize_number.setText(drawLists.getPrizeNumber());
        }
//        holder.removeImg.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawList.remove(position);
//                notifyDataSetChanged();
//            }
//        });

        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return drawList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView city;
        TextView denominations;
        TextView draw_date;
        TextView prize_number;
        ImageView removeImg;
        LinearLayout list_item;

        public SearchViewHolder(View itemView) {
            super(itemView);
            city = itemView.findViewById(R.id.city);
            denominations = itemView.findViewById(R.id.denominations);
            draw_date = itemView.findViewById(R.id.drawdate);
            prize_number = itemView.findViewById(R.id.prize_number);
            removeImg = itemView.findViewById(R.id.img_remove);
            list_item = itemView.findViewById(R.id.list_item);
        }
    }
}



