package work.yeshu.englishbook.ui.word;

import io.reactivex.disposables.CompositeDisposable;
import work.yeshu.englishbook.data.word.WordTagRepositoryImpl;
import work.yeshu.englishbook.domain.interactor.word.GetWordTagListUseCase;
import work.yeshu.englishbook.ui.mapper.WordViewModelMapper;
import work.yeshu.englishbook.ui.mapper.WordViewModelMapperImpl;

/**
 * Created by yeshu on 2017/11/8.
 * desc:
 */
public class WordTagListPresenter implements WordTagListContract.Presenter {
    private WordTagListContract.View mView;

    private GetWordTagListUseCase mGetWordTagListUseCase;
    private CompositeDisposable mCompositeDisposable;
    private WordViewModelMapper mWordViewModelMapper;

    public WordTagListPresenter(WordTagListContract.View view) {
        mView = view;
        mView.setPresenter(this);
        mGetWordTagListUseCase = new GetWordTagListUseCase(new WordTagRepositoryImpl());
        mCompositeDisposable = new CompositeDisposable();
        mWordViewModelMapper = new WordViewModelMapperImpl();
    }

    @Override
    public void loadWordTagList() {
        mGetWordTagListUseCase.execute().subscribe(new )
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
