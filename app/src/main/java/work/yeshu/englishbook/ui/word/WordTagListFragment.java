package work.yeshu.englishbook.ui.word;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.ui.model.WordTagViewModel;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class WordTagListFragment extends Fragment implements WordTagListContract.View{
    private WordTagListContract.Presenter mPresenter;
    private EditText mInputTagName;
    private Button mBtnAddTag;
    private WordTagAdapter mWordTagAdapter;

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
        mInputTagName = view.findViewById(R.id.input_tag_name);
        mBtnAddTag = view.findViewById(R.id.btn_add_tag);

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        mWordTagAdapter = new WordTagAdapter(new ArrayList<>(0));
        recyclerView.setAdapter(mWordTagAdapter);

        mPresenter = new WordTagListPresenter(this);
        mPresenter.subscribe();

        mBtnAddTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.addWordTag(mInputTagName.getText().toString().trim());
            }
        });


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.unsubscribe();
    }

    @Override
    public void showWordTagList(List<WordTagViewModel> list) {
        mWordTagAdapter.updateData(list);
    }

    @Override
    public void setPresenter(WordTagListContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
