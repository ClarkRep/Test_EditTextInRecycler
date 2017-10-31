package com.example.zhaodanyang.testedittextinrecyclerview;

import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class TaskCheckItemAdapter extends MultiSelectRecyclerAdapter<TaskCheckItemEntity.ItemEntity> {

    OnLoseFocusListener onLoseFocusListener;
    boolean valid;

    @Override
    public int bindView(int viewtype) {
        return R.layout.adapter_item_task_check_layout;
    }

    @Override
    public void onBindSelectableHolder(final ViewHolder holder, final TaskCheckItemEntity.ItemEntity itemEntity, boolean selected, final int position) {
        final EditText nameView = holder.obtainView(R.id.check_item_name_tv);
        Spannable spannable = new SpannableString(itemEntity.name);
        Linkify.addLinks(spannable, Linkify.WEB_URLS);
        final CharSequence text = TextUtils.concat(spannable, "\u200B");

        InputFilter[] filters = {new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {

                return String.valueOf(" " + source);
            }
        }};
        nameView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        nameView.setFilters(filters);
        nameView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean hasFocus) {
                if (!hasFocus) {
                    nameView.setMovementMethod(LinkMovementMethod.getInstance());
                    if (TextUtils.equals(nameView.getText(), itemEntity.name)) {
                        //如果内容没有改变，就不走接口了。
                        return;
                    }
                    if (onLoseFocusListener != null) {
                        onLoseFocusListener.loseFocus(itemEntity, position, nameView.getText().toString());
                    }
                } else {
                    nameView.setMovementMethod(null);
                }
            }
        });
        //屏蔽回车键 回车键表示完成
        nameView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER) {
                    holder.itemView.setFocusable(true);
                    holder.itemView.setFocusableInTouchMode(true);
                    holder.itemView.requestFocus();//请求焦点
                    holder.itemView.findFocus();//获取焦点
                    SystemUtils.hideSoftKeyBoard(textView.getContext(), textView);
                    return true;
                }
                return false;
            }
        });
        nameView.setText(text);
    }


    public interface OnLoseFocusListener {
        void loseFocus(TaskCheckItemEntity.ItemEntity itemEntity, int position, String name);
    }

}
