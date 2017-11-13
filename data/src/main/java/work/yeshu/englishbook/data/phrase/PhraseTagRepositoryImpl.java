package work.yeshu.englishbook.data.phrase;

import com.annimon.stream.Collectors;
import com.annimon.stream.Stream;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;
import work.yeshu.englishbook.data.converter.PhraseModelConverter;
import work.yeshu.englishbook.data.db.model.PhraseTagModel;
import work.yeshu.englishbook.data.db.model.PhraseTagModel_Table;
import work.yeshu.englishbook.domain.model.PhraseTag;
import work.yeshu.englishbook.domain.repository.PhraseTagRepository;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */
public class PhraseTagRepositoryImpl implements PhraseTagRepository {

    private PhraseModelConverter mPhraseModelConverter;

    @Override
    public Completable addPhraseTag(String name) {
        return Completable.fromAction(() -> {
            innerAddPhraseTag(name);
        });
    }

    @Override
    public Completable updatePhraseTag(PhraseTag phraseTag) {
        return Completable.fromAction(() -> {
            mPhraseModelConverter.domainToPhraseTagModel(phraseTag).save();
        });
    }

    @Override
    public Single<List<PhraseTag>> getPhraseTagList() {
        return Single.just(Stream.of(SQLite.select()
                .from(PhraseTagModel.class)
                .queryList())
                .map(mPhraseModelConverter::phraseTagModelToDomain)
                .collect(Collectors.toList()));
    }

    @Override
    public Completable deletePhraseTag(String id) {
        return Completable.fromAction(() -> {
            innerDeletePhraseTag(id);
        });
    }

    private void innerAddPhraseTag(String name) {
        PhraseTagModel phraseTagModel = new PhraseTagModel();
        phraseTagModel.save();
    }


    private boolean innerDeletePhraseTag(String id) {
        PhraseTagModel phraseTagModel = SQLite.select().from(PhraseTagModel.class).where(PhraseTagModel_Table.id.eq(id)).querySingle();
        if (null != phraseTagModel) {
            return phraseTagModel.delete();
        }

        return false;
    }
}
