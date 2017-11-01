package work.yeshu.englishbook.domain.repository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.domain.model.PhraseTag;

/**
 * Created by yeshu on 2017/11/1.
 */

public interface PhraseTagRepository {

    Completable addPhraseTag(String name);

    Completable updatePhraseTag(String name);

    Single<List<PhraseTag>> getPhraseTagList();

    Completable deletePhraseTag(String id);
}
