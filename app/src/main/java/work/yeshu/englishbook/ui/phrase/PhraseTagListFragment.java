package work.yeshu.englishbook.ui.phrase;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import work.yeshu.englishbook.R;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class PhraseTagListFragment extends Fragment{

    public static PhraseTagListFragment newInstance() {

        Bundle args = new Bundle();

        PhraseTagListFragment fragment = new PhraseTagListFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_phrase_tag_list, container, false);
        return view;
    }
}
