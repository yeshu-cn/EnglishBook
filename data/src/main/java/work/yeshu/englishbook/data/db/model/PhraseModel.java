package work.yeshu.englishbook.data.db.model;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import work.yeshu.englishbook.data.db.definition.AppDatabase;

/**
 * Created by yeshu on 2017/11/3.
 * desc:
 */

//所有的Model都必须有一个公共无参构造。在查询时我们将会使用到这个构造函数
@Table(database = AppDatabase.class, allFields = true)
public class PhraseModel extends BaseModel{

    @PrimaryKey
    public String id;
    public String content;
    public String notes;
    public String tagId;

    public PhraseModel() {
    }



    public PhraseModel(String id, String content, String notes, String tagId) {
        this.id = id;
        this.content = content;
        this.notes = notes;
        this.tagId = tagId;
    }
}
