package com.example.bottomnagivationviewtest;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

//fragment는 onCreateView로 생성한다.
public class Frag2 extends Fragment {
    private View rootView;

    private ArrayList<ImageData> arrayList;
    private ImageAdapter imageAdapter;
    private RecyclerView recyclerView;
    //  private LinearLayoutManager linearLayoutManager;

    private TextView img_name;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //xml파일과 연결 시도
        rootView = inflater.inflate(R.layout.frag2, container, false);

        //리싸이클러뷰 갖고오기
        recyclerView = (RecyclerView) rootView.findViewById(R.id.rv2);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        //데이터넣을 array생성
        arrayList = new ArrayList<>();
        arrayList.add(new ImageData(R.drawable.im3,"코코"));
        arrayList.add(new ImageData(R.drawable.img,"귀여웡"));
        arrayList.add(new ImageData(R.drawable.img2,"라이언"));
        arrayList.add(new ImageData(R.drawable.ic_baseline_sentiment_satisfied_24,"웃는상"));
        arrayList.add(new ImageData(R.drawable.ic_baseline_sentiment_satisfied_alt_24,"우는상"));
        arrayList.add(new ImageData(R.drawable.ic_baseline_sentiment_dissatisfied_24,"무표정"));
        arrayList.add(new ImageData(R.drawable.lion,"개"));
        arrayList.add(new ImageData(R.drawable.monkey,"string"));
        arrayList.add(new ImageData(R.drawable.mouse,"strwerg"));
        arrayList.add(new ImageData(R.drawable.rabbit,"strqwering"));
        arrayList.add(new ImageData(R.drawable.dog,"strewing"));





            //데이터 넣을 어뎁터 생성
        imageAdapter = new ImageAdapter(arrayList);
        recyclerView.setAdapter(imageAdapter);
        imageAdapter.notifyDataSetChanged();
        //리사이클러뷰에 어뎁터 넣기
        return rootView;
    }
}