package work.yeshu.englishbook.data.converter;

import work.yeshu.englishbook.data.db.model.PhraseModel;
import work.yeshu.englishbook.data.db.model.PhraseTagModel;
import work.yeshu.englishbook.domain.model.Phrase;
import work.yeshu.englishbook.domain.model.PhraseTag;

/**
 * Created by yeshu on 2017/11/13.
 * desc:
 */
public interface PhraseModelConverter {

    Phrase phraseModelToDomain(PhraseModel phraseModel);

    PhraseTag phraseTagModelToDomain(PhraseTagModel phraseTagModel);

    PhraseModel domainToPhraseModel(Phrase phrase);

    PhraseTagModel domainToPhraseTagModel(PhraseTag phraseTag);
}
