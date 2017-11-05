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
public class PhraseModel extends BaseModel{

    @PrimaryKey
    public String id;
    public String content;
    public String notes;
    public String tagId;
}
