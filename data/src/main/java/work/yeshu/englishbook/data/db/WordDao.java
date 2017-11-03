package work.yeshu.englishbook.data.db;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.data.db.model.WordModel;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public interface WordDao {
    Single<List<WordModel>> getWordListByTag(String tagId);

    Completable updateWord(String notes);

    Completable addWord(String spell, String notes);

    Completable deleteWord(String id);
}
