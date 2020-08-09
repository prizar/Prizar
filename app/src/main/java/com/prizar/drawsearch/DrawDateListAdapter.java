package com.prizar.drawsearch;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.prizar.R;
import com.prizar.model.draws.DrawsDateList;

import java.util.List;

public class DrawDateListAdapter extends RecyclerView.Adapter<DrawDateListAdapter.SearchViewHolder> {
    Context context;
    List<DrawsDateList> drawdatesList;

    public interface Onclick {
        void onEvent(DrawsDateList drawdateList, int pos);
    }

    public DrawDateListAdapter(Context context, List<DrawsDateList> drawdatesList) {
        this.context = context;
        this.drawdatesList = drawdatesList; }

    View view;

    @Override
    public DrawDateListAdapter.SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        SearchViewHolder searchViewHolder = new SearchViewHolder(view);
        return searchViewHolder;
    }

    @Override
    public void onBindViewHolder(DrawDateListAdapter.SearchViewHolder holder, final int position) {
        final DrawsDateList drawsdatelist = drawdatesList.get(position);
        if (drawsdatelist.getDrawDate() != null) {
            holder.draw_date.setText(drawsdatelist.getDrawDate());
        }
        holder.list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return drawdatesList.size();
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        TextView draw_date;
        LinearLayout list_item;


        public SearchViewHolder(View itemView) {
            super(itemView);
            draw_date = itemView.findViewById(R.id.tv_name);
            list_item = itemView.findViewById(R.id.ll_item);

        }
    }
}



