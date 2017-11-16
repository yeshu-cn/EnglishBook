package work.yeshu.englishbook.ui.wordtag.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import work.yeshu.englishbook.R;
import work.yeshu.englishbook.base.BaseActivity;
import work.yeshu.englishbook.data.converter.WordModelConverterImpl;
import work.yeshu.englishbook.data.word.WordTestRepositoryImpl;
import work.yeshu.englishbook.domain.interactor.word.GetWordListByTagUseCase;
import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.ui.mapper.WordViewModelMapperImpl;

public class WordTagDetailActivity extends BaseActivity {
    private static final String EXTRA_ID = "id";
    private static final String EXTRA_NAME = "name";

    private WordAdapter mWordAdapter;
    private GetWordListByTagUseCase mGetWordListByTagUseCase;
    private CompositeDisposable mCompositeDisposable;
    private WordViewModelMapperImpl mWordViewModelMapper;

    public static void start(Activity activity, String name, String tagId) {
        Intent intent = new Intent(activity, WordTagDetailActivity.class);
        intent.putExtra(EXTRA_NAME, name);
        intent.putExtra(EXTRA_ID, tagId);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_tag_detail);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        toolbar.setTitle(getIntent().getStringExtra(EXTRA_NAME));
        setSupportActionBar(toolbar);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        mWordAdapter = new WordAdapter();
        recyclerView.setAdapter(mWordAdapter);

        mGetWordListByTagUseCase = new GetWordListByTagUseCase(new WordTestRepositoryImpl(new WordModelConverterImpl()));
        mCompositeDisposable = new CompositeDisposable();
        mWordViewModelMapper = new WordViewModelMapperImpl();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        String tagId = getIntent().getStringExtra("data");
        mCompositeDisposable.add(mGetWordListByTagUseCase.execute(tagId).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).doOnSuccess(new Consumer<List<Word>>() {
            @Override
            public void accept(List<Word> words) throws Exception {
                mWordAdapter.updateData(mWordViewModelMapper.mapWordsToViewModels(words));
            }
        }).subscribe());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mCompositeDisposable.clear();
    }
}
