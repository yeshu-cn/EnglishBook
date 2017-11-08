package work.yeshu.englishbook.ui.word;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.ui.model.WordTagViewModel;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class WordTagListFragment extends Fragment implements WordTagListContract.View{
    private WordTagListContract.Presenter mPresenter;


    public static WordTagListFragment newInstance() {
        
        Bundle args = new Bundle();
        
        WordTagListFragment fragment = new WordTagListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_word_tag_list, container, false);
        mPresenter = new WordTagListPresenter(this);
        mPresenter.loadWordTagList();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void showWordTagList(List<WordTagViewModel> list) {

    }

    @Override
    public void setPresenter(WordTagListContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
