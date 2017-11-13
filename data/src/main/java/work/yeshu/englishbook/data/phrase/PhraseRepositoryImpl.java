package work.yeshu.englishbook.data.phrase;

import com.annimon.stream.Stream;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.data.converter.PhraseModelConverter;
import work.yeshu.englishbook.data.db.model.PhraseModel;
import work.yeshu.englishbook.data.db.model.PhraseModel_Table;
import work.yeshu.englishbook.domain.model.Phrase;
import work.yeshu.englishbook.domain.repository.PhraseRepository;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public class PhraseRepositoryImpl implements PhraseRepository {

    private PhraseModelConverter mPhraseModelConverter;

    public PhraseRepositoryImpl(PhraseModelConverter phraseModelConverter) {
        mPhraseModelConverter = phraseModelConverter;
    }

    @Override
    public Completable addPhrase(Phrase phrase) {
        return Completable.fromAction(() -> {
            mPhraseModelConverter.domainToPhraseModel(phrase).save();
        });
    }

    @Override
    public Completable updatePhrase(Phrase phrase) {
        return Completable.fromAction(() -> {
            mPhraseModelConverter.domainToPhraseModel(phrase).update();
        });
    }

    @Override
    public Completable deletePhrase(String id) {
        return Completable.fromAction(() -> {
            innerDelete(id);
        });
    }

    @Override
    public Single<List<Phrase>> getPhraseListByTag(String tagId) {
        List<PhraseModel> phraseModelList = SQLite.select().from(PhraseModel.class).where(PhraseModel_Table.tagId.eq(tagId)).queryList();
        return Single.just(Stream.of(phraseModelList).map(mPhraseModelConverter::phraseModelToDomain).toList());
    }

    private boolean innerDelete(String id) {
        PhraseModel model = SQLite.select().from(PhraseModel.class).where(PhraseModel_Table.id.eq(id)).querySingle();
        if (null == model) {
            return false;
        }

        return model.delete();
    }
}
