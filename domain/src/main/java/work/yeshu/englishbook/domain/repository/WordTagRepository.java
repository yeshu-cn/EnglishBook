package work.yeshu.englishbook.domain.repository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.domain.model.WordTag;

/**
 * Created by yeshu on 2017/11/1.
 */

public interface WordTagRepository {
    Completable addWordTag(String name);

    Single<List<WordTag>> getWordTagList();

    Completable deleteWordTag(String id);

    Completable updateWordTag(String name);
}
