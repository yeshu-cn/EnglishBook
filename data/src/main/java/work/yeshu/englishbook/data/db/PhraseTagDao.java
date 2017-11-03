package work.yeshu.englishbook.data.db;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.data.db.model.PhraseTagModel;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public interface PhraseTagDao {
    Completable addPhraseTag(String name);

    Completable updatePhraseTag(String name);

    Single<List<PhraseTagModel>> getPhraseTagList();

    Completable deletePhraseTag(String id);
}
