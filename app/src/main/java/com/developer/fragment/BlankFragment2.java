package com.developer.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class BlankFragment2 extends Fragment {

    EditText ed;
    Button bt;
    FragmentBListener listener;

    public interface FragmentBListener{
        void onInputBSent(CharSequence input);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank2, container, false);
        ed =v.findViewById(R.id.editText);
        bt = v.findViewById(R.id.btn);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence input = ed.getText();
                listener.onInputBSent(input);
            }
        });
        return v;
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof FragmentBListener)
        {
            listener = (FragmentBListener) context;
        }
        else
        {
            Log.i("TAG", "Error ");
        }
    }
    public void updateChar(CharSequence inp)
    {
        ed.setText(inp);
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}