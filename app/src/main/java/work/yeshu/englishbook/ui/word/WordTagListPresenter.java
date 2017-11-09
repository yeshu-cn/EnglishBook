package work.yeshu.englishbook.ui.word;

import android.util.Log;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import work.yeshu.englishbook.data.converter.WordModelConverterImpl;
import work.yeshu.englishbook.data.word.WordTagRepositoryImpl;
import work.yeshu.englishbook.domain.interactor.word.AddWordTagUseCase;
import work.yeshu.englishbook.domain.interactor.word.GetWordTagListUseCase;
import work.yeshu.englishbook.ui.mapper.WordViewModelMapper;
import work.yeshu.englishbook.ui.mapper.WordViewModelMapperImpl;
import work.yeshu.englishbook.ui.model.WordTagViewModel;

/**
 * Created by yeshu on 2017/11/8.
 * desc:
 */
public class WordTagListPresenter implements WordTagListContract.Presenter {
    private static final String TAG = WordTagListPresenter.class.getName();

    private WordTagListContract.View mView;

    private GetWordTagListUseCase mGetWordTagListUseCase;
    private AddWordTagUseCase mAddWordTagUseCase;
    private CompositeDisposable mCompositeDisposable;
    private WordViewModelMapper mWordViewModelMapper;

    public WordTagListPresenter(WordTagListContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mGetWordTagListUseCase = new GetWordTagListUseCase(new WordTagRepositoryImpl(new WordModelConverterImpl()));
        mAddWordTagUseCase = new AddWordTagUseCase(new WordTagRepositoryImpl(new WordModelConverterImpl()));

        mCompositeDisposable = new CompositeDisposable();
        mWordViewModelMapper = new WordViewModelMapperImpl();
    }

    @Override
    public void loadWordTagList() {
        mCompositeDisposable.add(mGetWordTagListUseCase.execute()
                                        .map(mWordViewModelMapper::mapWordTagsToViewModels)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(Schedulers.trampoline())
                                        .doOnSuccess(new Consumer<List<WordTagViewModel>>() {
            @Override
            public void accept(List<WordTagViewModel> list) throws Exception {
                Log.i(TAG, "word tag list size is:" + list.size());
                mView.showWordTagList(list);
            }
        }).subscribe());
    }

    @Override
    public void addWordTag(String name) {
        /*
        mCompositeDisposable.add(mAddWordTagUseCase.execute(name).subscribeOn(Schedulers.io()).doOnComplete(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "add success");
            }
        }).subscribe());
        */
        Log.i(TAG, "---->" + Thread.currentThread().getId());
        mCompositeDisposable.add(mAddWordTagUseCase.execute(name)
                                                    .observeOn(Schedulers.io())
                                                    .subscribe(new Action() {
            @Override
            public void run() throws Exception {
                Log.i(TAG, "add word tag success");
                Log.i(TAG, "add word return thread ---->" + Thread.currentThread().getId());
                //loadWordTagList();
            }
        }));
    }

    @Override
    public void subscribe() {
        loadWordTagList();
    }

    @Override
    public void unsubscribe() {
        mCompositeDisposable.clear();
    }

}
