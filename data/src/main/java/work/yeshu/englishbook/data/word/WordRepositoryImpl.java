package work.yeshu.englishbook.data.word;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.domain.repository.WordRepository;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public class WordRepositoryImpl implements WordRepository{

    @Override
    public Single<List<Word>> getWordListByTag(String tagId) {
        return null;
    }

    @Override
    public Completable updateWord(String notes) {
        return null;
    }

    @Override
    public Completable addWord(String spell, String notes) {
        return null;
    }

    @Override
    public Completable deleteWord(String id) {
        return null;
    }
}
