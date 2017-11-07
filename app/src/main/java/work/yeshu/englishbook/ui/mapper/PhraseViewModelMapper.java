package work.yeshu.englishbook.ui.mapper;

import java.util.List;

import work.yeshu.englishbook.domain.model.Phrase;
import work.yeshu.englishbook.domain.model.PhraseTag;
import work.yeshu.englishbook.ui.model.PhraseTagViewModel;
import work.yeshu.englishbook.ui.model.PhraseViewModel;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public interface PhraseViewModelMapper {

    PhraseViewModel mapPhraseToViewModel(Phrase phrase);

    List<PhraseViewModel> mapPhrasesToViewModels(List<Phrase> phrases);

    PhraseTagViewModel mapPhraseTagToViewModel(PhraseTag phraseTag);

    List<PhraseTagViewModel> mapPhraseTagsToViewModels(List<PhraseTag> phraseTags);
}
