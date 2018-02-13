package montenegro.erick.quiz;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private final int[] ids_boton = {
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };

    private int solution;
    private RadioGroup answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        TextView question_text = (TextView) findViewById(R.id.question_text);
        question_text.setText(R.string.question_content);

        String[] answers_texts = getResources().getStringArray(R.array.answers_texts);

        for(int i = 0; i < answers_texts.length; i++){
            RadioButton rb = (RadioButton) findViewById(ids_boton[i]);
            rb.setText(answers_texts[i]);
        }

        Button btn_check = (Button) findViewById(R.id.btn_check);
        btn_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer();
            }
        });

        solution = getResources().getInteger(R.integer.solution);
        answers = (RadioGroup) findViewById(R.id.answers);

    }

    private void checkAnswer() {
        int id_checked = answers.getCheckedRadioButtonId();
        int quin = -1;
        for(int i = 0; i < ids_boton.length; i++){
            if(id_checked==ids_boton[i]){
                quin = i+1;
            }
        }
        if(quin != -1){
            if (quin == solution){
                Toast.makeText(this, "Correcte!", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Incorrecte...", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
