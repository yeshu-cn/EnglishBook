package work.yeshu.englishbook.ui.wordtag;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.ui.model.WordTagViewModel;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class WordTagAdapter extends RecyclerView.Adapter<WordTagAdapter.ViewHolder> {
    private List<WordTagViewModel> mData;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(WordTagViewModel wordTagViewModel);
    }

    public WordTagAdapter(List<WordTagViewModel> data) {
        mData = data;
    }

    public void updateData(List<WordTagViewModel> data) {
        if (null != data) {
            mData = data;
            notifyDataSetChanged();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word_tag, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final WordTagViewModel wordTag = mData.get(position);
        holder.textName.setText(wordTag.name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onItemClick(wordTag);
                }
            }
        });
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

    public void setListener(OnItemClickListener listener) {
        mListener = listener;
    }
}
