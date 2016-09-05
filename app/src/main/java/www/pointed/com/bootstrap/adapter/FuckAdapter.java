package www.pointed.com.bootstrap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import www.pointed.com.bootstrap.R;
import www.pointed.com.bootstrap.model.ListItem;

/**
 * Created by cw on 29-Aug-16.
 */
public class FuckAdapter  extends RecyclerView.Adapter<FuckAdapter.FuckHolder> {

    private List<ListItem> listData;
    private LayoutInflater inflater;

    private ItemClickCallback itemClickCallback;

    public void setListData(ArrayList listData) {
        this.listData = listData;
    }


    public interface ItemClickCallback {
        void onItemClick(int p);
        void onSecondaryIconClick(int p);
    }

    public void setItemClickCallback(final ItemClickCallback itemClickCallback) {
        this.itemClickCallback = itemClickCallback;
    }

    public FuckAdapter(List<ListItem> listData, Context c){
        inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public FuckHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_item, parent, false);
        return new FuckHolder(view);
    }

    @Override
    public void onBindViewHolder(FuckHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.subTitle.setText(item.getSubTitle());
    /*    if (item.isFavourite()){
            holder.secondaryIcon.setImageResource(R.drawable.ic_star_rate_black_18dp);
        } else {
            holder.secondaryIcon.setImageResource(R.drawable.ic_star_rate_black_18dp);
        }*/
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class FuckHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView thumbnail;
        ImageView secondaryIcon;
        TextView title;
        TextView subTitle;
        View container;
        Button load;
        public FuckHolder(View itemView) {
            super(itemView);
            thumbnail = (ImageView)itemView.findViewById(R.id.im_item_icon);
          /*  secondaryIcon = (ImageView)itemView.findViewById(R.id.im_item_icon_secondary);
            secondaryIcon.setOnClickListener(this);*/
            load = (Button)itemView.findViewById(R.id.btn_card_load);
            load.setOnClickListener(this);
            subTitle = (TextView)itemView.findViewById(R.id.lbl_item_sub_title);
            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            container = (View)itemView.findViewById(R.id.cont_item_root);
            container.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.btn_card_load){
                itemClickCallback.onItemClick(getAdapterPosition());
            } else {
//                itemClickCallback.onSecondaryIconClick(getAdapterPosition());
            }

        }
    }


}
