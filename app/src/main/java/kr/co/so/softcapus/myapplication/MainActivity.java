package kr.co.so.softcapus.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2;
    Fragmentt f1 = new Fragmentt();
    BtnFragment1 btnFragment1;
    BtnFragment2 btnFragment2 ;
    int num = 0;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        setLisner();
    }

    private void init(){
        btn1 =(Button)findViewById(R.id.btn1);
        btn2 =(Button)findViewById(R.id.btn2);
        bundle = new Bundle();
        btnFragment1 = new BtnFragment1();
        btnFragment2 = new BtnFragment2();
    }
    private void setLisner(){
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                bundle.putInt("num",++num);
                btnFragment1.setArguments(bundle);
                FragmentManager manager =getSupportFragmentManager();
                //프래그먼트를 변경을 관리하는 개체를 추출
                FragmentTransaction transaction = manager.beginTransaction();
                //프래그먼트를 추가한다.
                //transaction.add(R.id.container,firstFragment);
                // 프래그먼트를 교체한다.
                transaction.replace(R.id.frame1,btnFragment1);
                //프래그먼트 변경사항을 백 스택에 포함시칸다.
                transaction.addToBackStack(null);
                //적용한다.
                transaction.commit();

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bundle.putInt("num",++num);
                btnFragment2.setArguments(bundle);
                FragmentManager manager =getSupportFragmentManager();
                //프래그먼트를 변경을 관리하는 개체를 추출
                FragmentTransaction transaction = manager.beginTransaction();
                //프래그먼트를 추가한다.
                //transaction.add(R.id.container,firstFragment);
                // 프래그먼트를 교체한다.
                transaction.replace(R.id.frame1,btnFragment2);
                //프래그먼트 변경사항을 백 스택에 포함시칸다.
                transaction.addToBackStack(null);
                //적용한다.
                transaction.commit();
            }
        });
    }
}