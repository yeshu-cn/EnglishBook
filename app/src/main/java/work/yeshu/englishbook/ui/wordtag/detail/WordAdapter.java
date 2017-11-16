package work.yeshu.englishbook.ui.wordtag.detail;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.ui.model.WordViewModel;

/**
 * Created by yeshu on 2017/11/16.
 * desc:
 */
public class WordAdapter extends RecyclerView.Adapter<WordAdapter.ViewHolder> {
    private List<WordViewModel> mWordList = new ArrayList<>();

    public WordAdapter() {

    }

    public void updateData(List<WordViewModel> list) {
        if (null == list) {
            return;
        }
        mWordList = list;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_word, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WordViewModel word = mWordList.get(position);
        holder.textSpell.setText(word.spell);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView textSpell;
        ImageView btnPlay;

        public ViewHolder(View itemView) {
            super(itemView);
            textSpell = itemView.findViewById(R.id.text_spell);
            btnPlay = itemView.findViewById(R.id.btn_play);
        }
    }
}
