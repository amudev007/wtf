package www.pointed.com.bootstrap.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import www.pointed.com.bootstrap.R;
import www.pointed.com.bootstrap.model.ListItem;

/**
 * Created by cw on 29-Aug-16.
 */
public class FuckAdapter  extends RecyclerView.Adapter<FuckAdapter.FuckHolder> {

    private List<ListItem> listData;
    private LayoutInflater inflater;

    public FuckAdapter(List<ListItem> listData, Context c){
        inflater = LayoutInflater.from(c);
        this.listData = listData;
    }

    @Override
    public FuckHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new FuckHolder(view);
    }

    @Override
    public void onBindViewHolder(FuckHolder holder, int position) {
        ListItem item = listData.get(position);
        holder.title.setText(item.getTitle());
        holder.icon.setImageResource(item.getImageResId());
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class FuckHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private ImageView icon;
        private View container;

        public FuckHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.lbl_item_text);
            icon = (ImageView)itemView.findViewById(R.id.im_item_icon);
//We'll need the container later on, when we add an View.OnClickListener
            container = itemView.findViewById(R.id.cont_item_root);
        }
    }


}
