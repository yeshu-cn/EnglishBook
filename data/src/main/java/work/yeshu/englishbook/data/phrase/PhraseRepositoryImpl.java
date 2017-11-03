package work.yeshu.englishbook.data.phrase;

import java.util.List;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.SingleUseCase;
import work.yeshu.englishbook.domain.model.Phrase;
import work.yeshu.englishbook.domain.repository.PhraseRepository;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public class PhraseRepositoryImpl implements PhraseRepository {
    @Override
    public Completable addPhrase(String content, String notes) {
        return null;
    }

    @Override
    public Completable updatePhrase(String notes) {
        return null;
    }

    @Override
    public Completable deletePhrase(String id) {
        return null;
    }

    @Override
    public SingleUseCase<List<Phrase>> getPhraseListByTag(String tagId) {
        return null;
    }
}
