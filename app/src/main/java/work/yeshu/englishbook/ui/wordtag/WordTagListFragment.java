package work.yeshu.englishbook.ui.wordtag;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.ui.model.WordTagViewModel;
import work.yeshu.englishbook.ui.wordtag.detail.WordTagDetailActivity;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class WordTagListFragment extends Fragment implements WordTagListContract.View {
    private WordTagListContract.Presenter mPresenter;
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
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        mWordTagAdapter = new WordTagAdapter(new ArrayList<>(0));
        recyclerView.setAdapter(mWordTagAdapter);
        mWordTagAdapter.setListener(new WordTagAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(WordTagViewModel wordTagViewModel) {
                WordTagDetailActivity.start(getActivity(), wordTagViewModel.id);
            }
        });

        mPresenter = new WordTagListPresenter(this);
        mPresenter.subscribe();

        Toolbar toolbar = view.findViewById(R.id.toolbar);
        toolbar.setTitle("Word Tag List");
        toolbar.setTitleTextColor(Color.WHITE);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_word_tag_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getActivity(), AddWordTagActivity.class);
        startActivity(intent);
        return true;
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
