package com.example.bottomnagivationviewtest;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//fragment는 onCreateView로 생성한다.
public class Frag1 extends Fragment {
    private View rootView;

    private ArrayList<MainData> arrayList;
    private MainAdapter mainAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    EditText et_name;
    EditText et_number;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //xml파일과 연결 시도
        rootView = inflater.inflate(R.layout.frag1,container,false);

        et_name = (EditText)rootView.findViewById(R.id.et_name);
        et_number = (EditText)rootView.findViewById(R.id.et_number);

        //리싸이클러뷰 갖고오기
        recyclerView = (RecyclerView)rootView.findViewById(R.id.rv);

        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        //데이터넣을 array생성
        arrayList = new ArrayList<>();
        //데이터 넣을 어뎁터 생성
        mainAdapter = new MainAdapter(arrayList);
        //리사이클러뷰에 어뎁터 넣기
        recyclerView.setAdapter(mainAdapter);
        Button btn_add =(Button)rootView.findViewById(R.id.btn_add);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = et_name.getText().toString();
                String number = et_number.getText().toString();

                MainData mainData = new MainData(R.drawable.ic_launcher_background,name,number);
                arrayList.add(mainData);
                mainAdapter.notifyDataSetChanged();
            }
        });

        return rootView;
    }
}