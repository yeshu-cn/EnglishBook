package work.yeshu.englishbook.ui.model;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class PhraseViewModel {
    public String id;
    public String content;
    public String notes;
    public String tagId;

    public PhraseViewModel(String id, String content, String notes, String tagId) {
        this.id = id;
        this.content = content;
        this.notes = notes;
        this.tagId = tagId;
    }
}
