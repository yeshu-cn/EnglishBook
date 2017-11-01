package work.yeshu.englishbook.domain.interactor.phrase;

import java.util.List;

import io.reactivex.Single;
import work.yeshu.englishbook.domain.interactor.type.SingleUseCase;
import work.yeshu.englishbook.domain.model.PhraseTag;
import work.yeshu.englishbook.domain.repository.PhraseTagRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class GetPhraseTagListUseCase implements SingleUseCase<List<PhraseTag>>{
    private final PhraseTagRepository mPhraseTagRepository;

    public GetPhraseTagListUseCase(PhraseTagRepository phraseTagRepository) {
        mPhraseTagRepository = phraseTagRepository;
    }

    @Override
    public Single<List<PhraseTag>> execute() {
        return mPhraseTagRepository.getPhraseTagList();
    }
}
