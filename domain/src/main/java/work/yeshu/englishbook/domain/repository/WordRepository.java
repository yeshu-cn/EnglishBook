package work.yeshu.englishbook.domain.repository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.domain.model.Word;

/**
 * Created by yeshu on 2017/11/1.
 */

public interface WordRepository {

    Single<List<Word>> getWordListByTag(String tagId);

    Completable updateWord(Word word);

    Completable addWord(Word word);

    Completable deleteWord(String id);
}
