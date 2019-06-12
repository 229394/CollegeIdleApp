package com.leaf.collegeidleapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.leaf.collegeidleapp.bean.Student;
import com.leaf.collegeidleapp.util.StudentDbHelper;

import java.util.LinkedList;

/**
 * 我的个人信息活动类
 * @author : autumn_leaf
 */
public class MyInfoActivity extends AppCompatActivity {

    TextView tvStuName,tvStuMajor,tvStuPhone,tvStuQq,tvStuAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_info);
        Button btnBack = findViewById(R.id.btn_back);
        //返回点击事件,销毁当前界面
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //从bundle中获取用户账号/学号
        final TextView tvUserNumber = findViewById(R.id.tv_stu_number);
        tvUserNumber.setText(this.getIntent().getStringExtra("stu_number1"));
        tvStuName = findViewById(R.id.tv_stu_name);
        tvStuMajor = findViewById(R.id.tv_stu_major);
        tvStuPhone = findViewById(R.id.tv_stu_phone);
        tvStuQq = findViewById(R.id.tv_stu_qq);
        tvStuAddress = findViewById(R.id.tv_stu_address);
        StudentDbHelper dbHelper = new StudentDbHelper(getApplicationContext(),StudentDbHelper.DB_NAME,null,1);
        LinkedList<Student> students = dbHelper.readStudents(tvUserNumber.getText().toString());
        if(students != null) {
            for(Student student : students) {
                tvStuName.setText(student.getStuName());
                tvStuMajor.setText(student.getStuMajor());
                tvStuPhone.setText(student.getStuPhone());
                tvStuQq.setText(student.getStuQq());
                tvStuAddress.setText(student.getStuAddress());
            }
        }else {
            tvStuName.setText("暂未填写");
            tvStuMajor.setText("暂未填写");
            tvStuPhone.setText("暂未填写");
            tvStuQq.setText("暂未填写");
            tvStuAddress.setText("暂未填写");
        }
        Button btnModifyInfo = findViewById(R.id.btn_modify_info);
        //跳转到修改用户信息界面
        btnModifyInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ModifyInfoActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("stu_number2",tvUserNumber.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        //刷新按钮点击事件
        TextView tvRefresh = findViewById(R.id.tv_refresh);
        tvRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StudentDbHelper dbHelper1 = new StudentDbHelper(getApplicationContext(),StudentDbHelper.DB_NAME,null,1);
                LinkedList<Student> students = dbHelper1.readStudents(tvUserNumber.getText().toString());
                if(students != null) {
                    for(Student student : students) {
                        tvStuName.setText(student.getStuName());
                        tvStuMajor.setText(student.getStuMajor());
                        tvStuPhone.setText(student.getStuPhone());
                        tvStuQq.setText(student.getStuQq());
                        tvStuAddress.setText(student.getStuAddress());
                    }
                }
            }
        });

    }
}
