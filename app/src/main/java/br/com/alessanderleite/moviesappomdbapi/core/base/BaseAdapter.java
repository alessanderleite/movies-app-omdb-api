package br.com.alessanderleite.moviesappomdbapi.core.base;

import android.content.Context;
import android.support.annotation.IntDef;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

import br.com.alessanderleite.moviesappomdbapi.core.utils.ContentState;

import static br.com.alessanderleite.moviesappomdbapi.core.base.BaseAdapter.ViewTypes.*;

public abstract class BaseAdapter<T> extends BaseRecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected final int EMPTY_STATE_SIZE = 1;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({BLANK, EMPTY_VIEW, ITEM_VIEW, ERROR_VIEW})
    public @interface ViewTypes {
        int BLANK = 0;
        int EMPTY_VIEW = 1;
        int ITEM_VIEW = 2;
        int ERROR_VIEW = 4;
    }
    protected ContentState contentState;

    protected Context context;

    private List<T> dataSource;

    public BaseAdapter(Context context) {
        this.context = context;
    }

    public T getCurrentItem(int position) {
        if (getItemViewType(position) == ITEM_VIEW) {
            return getDataSource().get(position);
        }

        return null;
    }

    @Override
    public int getItemViewType(int position) {
        switch (contentState) {
            case HAS_RESULTS:
                return ITEM_VIEW;
            case ERROR:
                return ERROR_VIEW;
            case EMPTY:
                return EMPTY_VIEW;
            default:
                return BLANK;
        }
    }

    protected final LayoutInflater getLayoutInflater() {
        if (context != null) {
            return LayoutInflater.from(context);
        } else {
            throw new IllegalStateException("Cannot inflate views without an activity context! "
                    + "Please set this adapter's activity context to allow it to inflate views.");
        }
    }

    public void setContentState(ContentState state) {
        contentState = state;
    }

    public final ContentState getContentState() {
        return contentState;
    }

    public final List<T> getDataSource() {
        return dataSource;
    }

    public final void setDataSource(List<T> dataSource) {
        this.dataSource = dataSource;

        if (dataSource != null) {
            if (dataSource != null) {
                if (dataSource.size() == 0) {
                    setContentState(ContentState.EMPTY);
                } else {
                    setContentState(ContentState.HAS_RESULTS);
                }
            } else {
                setContentState(ContentState.BLANK);
            }
        }
    }
}
