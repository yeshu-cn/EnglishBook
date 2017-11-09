package work.yeshu.englishbook.domain.model;

/**
 * Created by yeshu on 2017/11/1.
 */

public class Word {
    public String id;
    public String spell;
    public String notes;
    public String tagId;

    public Word(String id, String spell, String notes, String tagId) {
        this.id = id;
        this.spell = spell;
        this.notes = notes;
        this.tagId = tagId;
    }
}
