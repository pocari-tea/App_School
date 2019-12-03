package com.cookandroid.adapterviewexercise;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridViewEx extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        setTitle("그리드뷰 테스트");

        // 그리드뷰 - 형태(틀)와 관련된 것
        final GridView gv = (GridView) findViewById(R.id.gridView);
        MyGridAdapter myAdap = new MyGridAdapter(this);
        gv.setAdapter(myAdap);

        // 어댑터를 사용해서 연결지어줘야 하는데
        // 그리드뷰를 사용하기 위해서는 커스텀 어댑터가 필요
    }

    // 커스텀 어댑터 만듬. BoseAdapter를 상속받는 것으로다가
    public class MyGridAdapter extends BaseAdapter{
        // 2. 필요한 멤버 변수 및 생성자 선언
        Context ctx;
        final Integer posterId[] = {R.drawable.movie_image1, R.drawable.movie_image2,
                R.drawable.movie_image3, R.drawable.movie_image4,
                R.drawable.movie_image5, R.drawable.movie_image6,
                R.drawable.movie_image7, R.drawable.movie_image8,
                R.drawable.movie_image9, R.drawable.movie_image10,
                R.drawable.movie_image1, R.drawable.movie_image2,
                R.drawable.movie_image3, R.drawable.movie_image4,
                R.drawable.movie_image5, R.drawable.movie_image6,
                R.drawable.movie_image7, R.drawable.movie_image8,
                R.drawable.movie_image9, R.drawable.movie_image10};
        public MyGridAdapter(Context c){
            ctx = c;
        }

        // 빨간 전구로 추가하거나, Ctrl + i 로
        // 추상메소드의 기본 형태를 자동 완성시킬 수 있음.
        // 두개의 메소드를 우리의 입맛에 맞게 수정
        // getCount() - count 반환, getView() - view(보이는 것) 반환

        @Override
        public int getCount() {
            return posterId.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {
            // 입력 단자들 중 int i <- list의 position ( for문 돌듯)
            // 아랫줄부터의 내용들이 getCount()만큼 반복된다고 생각하면 된다
            ImageView iv = new ImageView(ctx);
            iv.setLayoutParams(new GridView.LayoutParams(200, 300));
            iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
            iv.setPadding(5, 5,5, 5);
            iv.setImageResource(posterId[i]);

            // GridView의 각 이미지마다 기능을 부여 (CLickListener 같은)
            final int position = i;
            iv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View)View.inflate(
                            GridViewEx.this,
                        R.layout.poster,
                        null);
                    AlertDialog.Builder dlg =
                            new AlertDialog.Builder(GridViewEx.this);
                    ImageView bigPoster = (ImageView)dialogView.findViewById(R.id.BigPost);
                    bigPoster.setImageResource(posterId[position]);

                    dlg.setView(dialogView);
                    dlg.setPositiveButton("닫기", null);
                    dlg.show();
                }
            });

            return iv;
        }
    }
}
