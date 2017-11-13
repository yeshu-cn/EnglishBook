package work.yeshu.englishbook.data.converter;

import work.yeshu.englishbook.data.db.model.PhraseModel;
import work.yeshu.englishbook.data.db.model.PhraseTagModel;
import work.yeshu.englishbook.domain.model.Phrase;
import work.yeshu.englishbook.domain.model.PhraseTag;

/**
 * Created by yeshu on 2017/11/13.
 * desc:
 */
public class PhraseModelConverterImpl implements PhraseModelConverter {
    @Override
    public Phrase phraseModelToDomain(PhraseModel phraseModel) {
        return new Phrase(phraseModel.id, phraseModel.content, phraseModel.notes, phraseModel.tagId);
    }

    @Override
    public PhraseTag phraseTagModelToDomain(PhraseTagModel phraseTagModel) {
        return new PhraseTag(phraseTagModel.id, phraseTagModel.name);
    }

    @Override
    public PhraseModel domainToPhraseModel(Phrase phrase) {
        return new PhraseModel(phrase.id, phrase.content, phrase.notes, phrase.tagId);
    }

    @Override
    public PhraseTagModel domainToPhraseTagModel(PhraseTag phraseTag) {
        return new PhraseTagModel(phraseTag.id, phraseTag.name);
    }
}
