package work.yeshu.englishbook.domain.interactor.word;

import java.util.List;

import io.reactivex.Single;
import work.yeshu.englishbook.domain.interactor.type.SingleUseCaseWithParameter;
import work.yeshu.englishbook.domain.model.Word;
import work.yeshu.englishbook.domain.repository.WordRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class GetWordListByTagUseCase implements SingleUseCaseWithParameter<String, List<Word>>{
    private final WordRepository mWordRepository;

    public GetWordListByTagUseCase(WordRepository wordRepository) {
        mWordRepository = wordRepository;
    }


    @Override
    public Single<List<Word>> execute(String tagId) {
        return mWordRepository.getWordListByTag(tagId);
    }
}
