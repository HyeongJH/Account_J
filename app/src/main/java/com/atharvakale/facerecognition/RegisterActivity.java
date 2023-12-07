package com.atharvakale.facerecognition;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class RegisterActivity extends AppCompatActivity {
    private FirebaseAuth mFirebaseAuth; // 파이어베이스 인증
    private DatabaseReference mDatabaseRef; // 실시간 데이터터베이스
    private EditText et_id, et_pass, et_age, et_name ;
    private Button btn_face;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirebaseAuth = FirebaseAuth.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("Everyone's review");

        et_id = findViewById(R.id.et_id);
        et_pass = findViewById(R.id.et_pass);
        et_age = findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);

        btn_face = findViewById(R.id.btn_face);

        btn_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // EditText에 현재 입력되어있는 값을 get(가져온다)해온다.
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userAge = et_age.getText().toString();
                String userName = et_name.getText().toString();

                Intent intent = new Intent(RegisterActivity.this, AddFaceActivity.class);

                // 데이터를 Intent에 추가
                intent.putExtra("USER_ID", userID);
                intent.putExtra("USER_PW", userPass);
                intent.putExtra("USER_AGE", userAge);
                intent.putExtra("USER_NAME", userName);

                // AddFaceActivity 시작
                startActivity(intent);

                /*
                mFirebaseAuth.createUserWithEmailAndPassword(userID, userPass).addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {

                        if(task.isSuccessful()) {
                            FirebaseUser firebaseUser = mFirebaseAuth.getCurrentUser(); // 회원가입 된 유저 가져오기
                            UserAccount account = new UserAccount();
                            account.setUserIdToken(firebaseUser.getUid()); // 고유값
                            account.setUserId(firebaseUser.getEmail()); // 파이어베이스 안에 아이디 가져옴
                            account.setUserPass(userPass);
                            account.setUserAge(userAge);
                            account.setUserName(userName);

                            mDatabaseRef.child("UserAccount").orderByChild("userNickName").equalTo(userName).addListenerForSingleValueEvent(new ValueEventListener() {
                                @Override
                                public void onDataChange(@NonNull DataSnapshot snapshot) {
                                    if (snapshot.exists()) {
                                        // 닉네임이 이미 존재하는 경우
                                        Toast.makeText(RegisterActivity.this, "이미 존재하는 닉네임입니다", Toast.LENGTH_SHORT).show();
                                    } else {
                                        // 닉네임이 중복되지 않는 경우
                                        // setValue 데이터베이스 안에 삽입
                                        mDatabaseRef.child("UserAccount").child(firebaseUser.getUid()).setValue(account);
                                        Toast.makeText(RegisterActivity.this, "회원가입에 성공하셨습니다", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(RegisterActivity.this, AddFaceActivity.class);

                                        // 데이터를 Intent에 추가
                                        //intent.putExtra("USER_ID", userID);
                                        //intent.putExtra("USER_PW", userPass);
                                        //intent.putExtra("USER_AGE", userAge);
                                        intent.putExtra("USER_NAME", userName);

                                        // AddFaceActivity 시작
                                        startActivity(intent);
                                        finish();
                                    }
                                }

                                @Override
                                public void onCancelled(@NonNull DatabaseError error) {
                                    // 에러 처리
                                }
                            });

                        }

                        else {
                            Toast.makeText(RegisterActivity.this,"회원가입에 실패하셨습니다. 이메일을 확인해주세요",Toast.LENGTH_SHORT).show();
                        }

                    }
                });

                 */
            }
        });

    }

}
