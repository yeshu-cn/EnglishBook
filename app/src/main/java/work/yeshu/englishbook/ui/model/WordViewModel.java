package work.yeshu.englishbook.ui.model;

/**
 * Created by yeshu on 2017/11/7.
 * desc:
 */
public class WordViewModel {
    public String id;
    public String spell;
    public String notes;
    public String tagId;

    public WordViewModel(String id, String spell, String notes, String tagId) {
        this.id = id;
        this.spell = spell;
        this.notes = notes;
        this.tagId = tagId;
    }
}
