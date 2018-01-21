package com.dailyart.bookstoreapplication.insert;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.dailyart.bookstoreapplication.R;
import com.dailyart.bookstoreapplication.booklist.BooksContract;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment implements AddContract.View{

    public static final String ARGUMENT_EDIT_TASK_ID = "EDIT_TASK_ID";

    private AddContract.Presenter presenter;

    private EditText idEditText;
    private EditText pressEditText;
    private EditText bookEditText;
    private EditText authorEditText;




    public AddFragment() {
        // Required empty public constructor
    }

    public static AddFragment newInstance(){
        return new AddFragment();
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
    }

    @Override
    public void setPresenter(AddContract.Presenter presenter) {
        this.presenter = checkNotNull(presenter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add, container, false);
        idEditText = (EditText)view.findViewById(R.id.id);
        pressEditText = (EditText) view.findViewById(R.id.press);
        bookEditText = (EditText) view.findViewById(R.id.name);
        authorEditText = (EditText) view.findViewById(R.id.author);

        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_edit_book_done);

        fab.setImageResource(R.drawable.ic_edit);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                presenter.saveBook(idEditText.getText().toString(),pressEditText.getText().toString(), bookEditText.getText().toString(),
                        authorEditText.getText().toString());
            }
        });
    }

    @Override
    public void showBook() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }

}
