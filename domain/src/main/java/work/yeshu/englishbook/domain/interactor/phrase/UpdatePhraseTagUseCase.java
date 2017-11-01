package work.yeshu.englishbook.domain.interactor.phrase;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.CompletableUseCaseWithParameter;
import work.yeshu.englishbook.domain.repository.PhraseTagRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class UpdatePhraseTagUseCase implements CompletableUseCaseWithParameter<String>{
    private final PhraseTagRepository mPhraseTagRepository;

    public UpdatePhraseTagUseCase(PhraseTagRepository phraseTagRepository) {
        mPhraseTagRepository = phraseTagRepository;
    }

    @Override
    public Completable execute(String name) {
        return mPhraseTagRepository.updatePhraseTag(name);
    }
}
