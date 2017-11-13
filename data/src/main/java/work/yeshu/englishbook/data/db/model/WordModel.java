package work.yeshu.englishbook.data.db.model;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import work.yeshu.englishbook.data.db.definition.AppDatabase;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */

@Table(database = AppDatabase.class, allFields = true)
public class WordModel extends BaseModel {

    @PrimaryKey
    public String id;
    public String spell;
    public String notes;
    public String tagId;

    public WordModel() {
    }



    public WordModel(String id, String spell, String notes, String tagId) {
        this.id = id;
        this.spell = spell;
        this.notes = notes;
        this.tagId = tagId;
    }
}
