package work.yeshu.englishbook.ui.phrasetag;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.ui.model.PhraseTagViewModel;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class PhraseTagAdapter extends RecyclerView.Adapter<PhraseTagAdapter.ViewHolder> {
    private List<PhraseTagViewModel> mData;

    public PhraseTagAdapter(List<PhraseTagViewModel> data) {
        mData = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word_tag, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textName.setText(mData.get(position).name);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textName;

        public ViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.text_name);
        }
    }

}
