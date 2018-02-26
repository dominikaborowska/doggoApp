package com.example.dominiczka.doggoproject;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dominiczka on 08.01.2018.
 */

public class QuizActivity extends AppCompatActivity {

    private TextView mQuestionView;
    private Button mButtonChoice1;
    private Button mButtonChoice2;
    private Button mButtonChoice3;
    private Button mButtonChoice4;

    private int mScore = 0;
    private int mQuestionNumber = 0;

    List<Question> questionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_layout);

        String QUERY_URL = getString(R.string.JSONquery);

        new JSONAsyncTask().execute(QUERY_URL);

        mQuestionView = (TextView)findViewById(R.id.questionTextView);
        mButtonChoice1 = (Button)findViewById(R.id.answerButton1);
        mButtonChoice2 = (Button)findViewById(R.id.answerButton2);
        mButtonChoice3 = (Button)findViewById(R.id.answerButton3);
        mButtonChoice4 = (Button)findViewById(R.id.answerButton4);

        mButtonChoice1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                updateQuestion();
            }
        });

        mButtonChoice2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mScore = mScore + 1;
                updateQuestion();
            }
        });

        mButtonChoice3.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mScore = mScore + 2;
                updateQuestion();
            }
        });

        mButtonChoice4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                mScore = mScore + 3;
                updateQuestion();
            }
        });
    }


    private void updateQuestion(){
        Log.d("LIST", "question list size:" + questionList.size());
        if(mQuestionNumber < questionList.size() ){

            mQuestionView.setText(questionList.get(mQuestionNumber).getQuestion());

            mButtonChoice1.setText(questionList.get(mQuestionNumber).getAnswer(0));
            mButtonChoice2.setText(questionList.get(mQuestionNumber).getAnswer(1));
            mButtonChoice3.setText(questionList.get(mQuestionNumber).getAnswer(2));
            mButtonChoice4.setText(questionList.get(mQuestionNumber).getAnswer(3));

            mQuestionNumber++;
        }
        else {
              Intent intent = new Intent(QuizActivity.this, ChosenDogActivity.class);
              intent.putExtra("score", mScore);
              startActivity(intent);
              finish();
            Log.d("QUIZ", "score: " + mScore);
        }
    }

    public class JSONAsyncTask extends AsyncTask<String, String, String>{

        public JSONAsyncTask() {
            super();
        }

        @Override
        protected String doInBackground(String... urls) {

            HttpURLConnection httpURLConnection = null;
            BufferedReader bufferedReader = null;

            try{
                URL url = new URL (urls[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();

                InputStream inputStream = httpURLConnection.getInputStream();
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

                StringBuffer stringBuffer = new StringBuffer();

                String line = " ";

                while ((line = bufferedReader.readLine()) != null){
                    stringBuffer.append(line);
                }

                String finalJson = stringBuffer.toString();

                JSONObject parentObject = new JSONObject(finalJson);
                JSONArray parentArray = parentObject.getJSONArray("Quiz");
                questionList = new ArrayList<>();

                for (int i = 0; i < parentArray.length(); i++)
                {
                    JSONObject finalObject = parentArray.getJSONObject(i);

                    Question question = new Question();

                    String questionString = finalObject.getString("question");
                    JSONObject answers = finalObject.getJSONObject("answers");
                    String answer1String = answers.getString("answer1");
                    String answer2String = answers.getString("answer2");
                    String answer3String = answers.getString("answer3");
                    String answer4String = answers.getString("answer4");

                    question.setQuestion(questionString);
                    question.setAnswer(0, answer1String);
                    question.setAnswer(1, answer2String);
                    question.setAnswer(2, answer3String);
                    question.setAnswer(3, answer4String);

                    Log.d("JSON", "question: " + question.getQuestion()
                            + " answer1 " + question.getAnswer(0)
                            + " answer2 " + question.getAnswer(1)
                            + " answer3 " + question.getAnswer(2)
                            + " answer4 " + question.getAnswer(3));

                        questionList.add(question);
                }

            } catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e){
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null){
                    httpURLConnection.disconnect();
                }
                try{
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            updateQuestion();
        }
    }
}

