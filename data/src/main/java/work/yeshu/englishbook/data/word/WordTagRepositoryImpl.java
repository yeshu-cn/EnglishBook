package work.yeshu.englishbook.data.word;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.domain.model.WordTag;
import work.yeshu.englishbook.domain.repository.WordTagRepository;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public class WordTagRepositoryImpl implements WordTagRepository{

    @Override
    public Completable addWordTag(String name) {
        return null;
    }

    @Override
    public Single<List<WordTag>> getWordTagList() {
        return null;
    }

    @Override
    public Completable deleteWordTag(String id) {
        return null;
    }

    @Override
    public Completable updateWordTag(String name) {
        return null;
    }
}
