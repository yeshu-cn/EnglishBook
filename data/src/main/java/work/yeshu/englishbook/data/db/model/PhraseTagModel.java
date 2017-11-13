package work.yeshu.englishbook.data.db.model;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.UUID;

import work.yeshu.englishbook.data.db.definition.AppDatabase;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */

@Table(database = AppDatabase.class, allFields = true)
public class PhraseTagModel extends BaseModel{

    @PrimaryKey
    public String id;
    public String name;

    public PhraseTagModel() {
    }

    public PhraseTagModel(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public PhraseTagModel(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
