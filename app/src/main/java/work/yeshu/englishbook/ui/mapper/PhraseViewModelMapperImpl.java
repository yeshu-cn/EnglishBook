package work.yeshu.englishbook.ui.mapper;

import com.annimon.stream.Stream;

import java.util.List;

import work.yeshu.englishbook.domain.model.Phrase;
import work.yeshu.englishbook.domain.model.PhraseTag;
import work.yeshu.englishbook.ui.model.PhraseTagViewModel;
import work.yeshu.englishbook.ui.model.PhraseViewModel;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class PhraseViewModelMapperImpl implements PhraseViewModelMapper {
    @Override
    public PhraseViewModel mapPhraseToViewModel(Phrase phrase) {
        return new PhraseViewModel(phrase.id, phrase.content, phrase.notes, phrase.tagId);
    }

    @Override
    public List<PhraseViewModel> mapPhrasesToViewModels(List<Phrase> phrases) {
        return Stream.of(phrases)
                .map(this::mapPhraseToViewModel)
                .toList();
    }

    @Override
    public PhraseTagViewModel mapPhraseTagToViewModel(PhraseTag phraseTag) {
        return new PhraseTagViewModel(phraseTag.id, phraseTag.name);
    }

    @Override
    public List<PhraseTagViewModel> mapPhraseTagsToViewModels(List<PhraseTag> phraseTags) {
        return Stream.of(phraseTags)
                .map(this::mapPhraseTagToViewModel)
                .toList();
    }
}
