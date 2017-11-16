package work.yeshu.englishbook.ui.wordtag;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import work.yeshu.englishbook.R;
import work.yeshu.englishbook.base.BaseActivity;
import work.yeshu.englishbook.data.converter.WordModelConverterImpl;
import work.yeshu.englishbook.data.word.WordTagRepositoryImpl;
import work.yeshu.englishbook.domain.interactor.word.AddWordTagUseCase;

public class AddWordTagActivity extends BaseActivity {
    private AddWordTagUseCase mAddWordTagUseCase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word_tag);

        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Add word tag");

        mAddWordTagUseCase = new AddWordTagUseCase(new WordTagRepositoryImpl(new WordModelConverterImpl()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_word_tag, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
//            case android.R.id.home:
//                //finish();
//                return true;
            case R.id.action_add:
                addTestTagData();
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }

    }

    public void addTestTagData() {
        String data = getString(R.string.testTag);
        String[] tags = data.split(" ");
        for (int i=0; i<tags.length;i++) {
            System.out.println("---->" + tags[i]);
            mAddWordTagUseCase.execute(tags[i]).subscribe();
        }


    }
}
