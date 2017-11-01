package work.yeshu.englishbook.domain.interactor.word;

import java.util.List;

import io.reactivex.Single;
import work.yeshu.englishbook.domain.interactor.type.SingleUseCase;
import work.yeshu.englishbook.domain.model.WordTag;
import work.yeshu.englishbook.domain.repository.WordTagRepository;

/**
 * Created by yeshu on 2017/11/1.
 */

public class GetWordTagListUseCase implements SingleUseCase<List<WordTag>>{
    private WordTagRepository mWordTagRepository;

    public GetWordTagListUseCase(WordTagRepository wordTagRepository) {
        mWordTagRepository = wordTagRepository;
    }

    @Override
    public Single<List<WordTag>> execute() {
        return mWordTagRepository.getWordTagList();
    }
}
