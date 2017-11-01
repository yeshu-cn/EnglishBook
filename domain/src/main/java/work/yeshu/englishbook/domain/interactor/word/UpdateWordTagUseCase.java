package work.yeshu.englishbook.domain.interactor.word;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.CompletableUseCaseWithParameter;
import work.yeshu.englishbook.domain.repository.WordTagRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class UpdateWordTagUseCase implements CompletableUseCaseWithParameter<String>{
    private final WordTagRepository mWordTagRepository;

    public UpdateWordTagUseCase(WordTagRepository wordTagRepository) {
        mWordTagRepository = wordTagRepository;
    }

    @Override
    public Completable execute(String name) {
        return mWordTagRepository.updateWordTag(name);
    }
}
