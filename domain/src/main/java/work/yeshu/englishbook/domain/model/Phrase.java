package work.yeshu.englishbook.domain.model;

/**
 * Created by yeshu on 2017/11/1.
 */

public class Phrase {
    public String id;
    public String content;
    public String notes;
    public String tagId;

    public Phrase(String id, String content, String notes, String tagId) {
        this.id = id;
        this.content = content;
        this.notes = notes;
        this.tagId = tagId;
    }
}
