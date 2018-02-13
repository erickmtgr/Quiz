package montenegro.erick.quiz;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {

    private final int[] ids_boton = {
            R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4
    };

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

    }
}
