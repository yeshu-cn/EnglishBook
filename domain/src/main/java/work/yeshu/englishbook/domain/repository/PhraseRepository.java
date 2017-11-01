package work.yeshu.englishbook.domain.repository;

import java.util.List;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.SingleUseCase;
import work.yeshu.englishbook.domain.model.Phrase;

/**
 * Created by yeshu on 2017/11/1.
 */

public interface PhraseRepository {
    Completable addPhrase(String content, String notes);

    Completable updatePhrase(String notes);

    Completable deletePhrase(String id);

    SingleUseCase<List<Phrase>> getPhraseListByTag(String tagId);
}
