package tdm2018.ittepic.edu.tdm2018_u4_42_asnctask_fionacci;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button) findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                doStart();
            }
        });
    }
    private void doStart()
    {

        MyAsyncTask tt=new MyAsyncTask(this);

        EditText edt=(EditText) findViewById(R.id.editText1);

        int so=Integer.parseInt(edt.getText()+"");

        tt.execute(so);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


}
