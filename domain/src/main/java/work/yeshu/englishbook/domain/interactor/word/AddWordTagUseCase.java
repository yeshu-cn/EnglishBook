package work.yeshu.englishbook.domain.interactor.word;

import io.reactivex.Completable;
import work.yeshu.englishbook.domain.interactor.type.CompletableUseCaseWithParameter;
import work.yeshu.englishbook.domain.repository.WordTagRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class AddWordTagUseCase implements CompletableUseCaseWithParameter<String>{
    private final WordTagRepository mWordTagRepository;

    public AddWordTagUseCase(WordTagRepository wordTagRepository) {
        mWordTagRepository = wordTagRepository;
    }

    @Override
    public Completable execute(String name) {
        return mWordTagRepository.addWordTag(name);
    }
}
