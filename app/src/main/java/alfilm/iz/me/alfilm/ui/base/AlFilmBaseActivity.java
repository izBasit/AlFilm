package alfilm.iz.me.alfilm.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Actionbar will provide back arrow by default
 * Created by jarvis on 28/05/17.
 */

public abstract class AlFilmBaseActivity extends BaseActivity {


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);

        Timber.d("In Alfilm base");
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
