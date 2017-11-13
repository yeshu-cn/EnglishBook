package work.yeshu.englishbook.domain.repository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.domain.model.Phrase;

/**
 * Created by yeshu on 2017/11/1.
 */

public interface PhraseRepository {
    Completable addPhrase(Phrase phrase);

    Completable updatePhrase(Phrase phrase);

    Completable deletePhrase(String id);

    Single<List<Phrase>> getPhraseListByTag(String tagId);
}
