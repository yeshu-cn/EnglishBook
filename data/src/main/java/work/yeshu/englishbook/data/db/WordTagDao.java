package work.yeshu.englishbook.data.db;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.data.db.model.WordTagModel;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public interface WordTagDao {
    Completable addWordTag(String name);

    Single<List<WordTagModel>> getWordTagList();

    Completable deleteWordTag(String id);

    Completable updateWordTag(String name);
}
