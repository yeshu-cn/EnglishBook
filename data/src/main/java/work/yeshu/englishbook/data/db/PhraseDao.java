package work.yeshu.englishbook.data.db;

import java.util.List;

import io.reactivex.Completable;
import work.yeshu.englishbook.data.db.model.PhraseModel;
import work.yeshu.englishbook.domain.interactor.type.SingleUseCase;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public interface PhraseDao {
    Completable addPhrase(String content, String notes);

    Completable updatePhrase(String notes);

    Completable deletePhrase(String id);

    SingleUseCase<List<PhraseModel>> getPhraseListByTag(String tagId);
}
