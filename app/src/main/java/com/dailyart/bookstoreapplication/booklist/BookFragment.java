package com.dailyart.bookstoreapplication.booklist;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.dailyart.bookstoreapplication.R;
import com.dailyart.bookstoreapplication.bookdb.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BookFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment implements BooksContract.View{

    private BookAdapter bookAdapter;
    private BooksContract.Presenter bookPresenter;

    public BookFragment() {
        // Required empty public constructor
    }


    public static BookFragment newInstance() {
        BookFragment fragment = new BookFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bookAdapter = new BookAdapter(new ArrayList<Book>(0));
    }


    @Override
    public void onResume() {
        super.onResume();
        bookPresenter.start();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.books_frag, container, false);

        ListView listView = (ListView) root.findViewById(R.id.booksList);
        listView.setAdapter(bookAdapter);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab_add_book);
        fab.setImageResource(R.drawable.ic_add);
        fab.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                bookPresenter.addBook();
            }
        });
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void setPresenter(BooksContract.Presenter presenter) {
        this.bookPresenter = presenter;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        bookPresenter.result(requestCode,resultCode);
    }



    @Override
    public void showSuccessfullySavedMessage() {
        Toast.makeText(getContext(), "add successfullly!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showAddTask() {
        Intent intent = new Intent(getContext(), AddBookActivity.class);
        startActivityForResult(intent, AddBookActivity.REQUEST_ADD_TASK);
    }

    private static class BookAdapter extends BaseAdapter {
        private List<Book> books;

        private BookAdapter(List<Book> books) {
            this.books = books;
        }

        public void replaceData(List<Book> books) {
            this.books = books;
            notifyDataSetChanged();
        }

        public void setList(List<Book> books) {
            this.books = books;
        }

        @Override
        public int getCount() {
            return books.size();
        }

        @Override
        public Book getItem(int i) {
            return books.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View rowView = view;
            if (rowView == null) {
                LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
                rowView = inflater.inflate(R.layout.book_item, viewGroup, false);
            }

            Book book = getItem(i);
            TextView pressTextView = (TextView) rowView.findViewById(R.id.press);
            TextView nameTextView = (TextView) rowView.findViewById(R.id.name);
            TextView authorTextView = (TextView) rowView.findViewById(R.id.author);

            pressTextView.setText(book.getPress());
            nameTextView.setText(book.getBookName());
            authorTextView.setText(book.getAuthor());
            return rowView;
        }
    }
}
