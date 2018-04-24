package tdm2018.ittepic.edu.tdm2018_u4_42_asnctask_fionacci;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Jair on 23/04/2018.
 */

public class MyAsyncTask extends AsyncTask<Integer,Integer, ArrayList<Integer>> {
    Activity activityCha;
    ListView lv=null;
    ArrayList<Integer>arrCuaListview=new ArrayList<Integer>();
    ArrayAdapter<Integer> adapterCuaListview=null;
    public MyAsyncTask(Activity act) {
        activityCha=act;

        lv=(ListView) activityCha.findViewById(R.id.listView1);

        adapterCuaListview=new ArrayAdapter<Integer>
                (activityCha,
                        android.R.layout.simple_list_item_1,
                        arrCuaListview);
        lv.setAdapter(adapterCuaListview);
    }
    public int fib(int n)
    {
        if(n<=2)return 1;
        return fib(n-1)+fib(n-2);
    }
    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();

        Toast.makeText(activityCha, " ",
                Toast.LENGTH_LONG).show();

    }

    @Override
    protected void onPostExecute(ArrayList<Integer> result) {
        super.onPostExecute(result);

        int tong=0;

        for(int v : result)
        {
            tong+=v;
        }
        Toast.makeText(activityCha, "Tong ="+tong, Toast.LENGTH_LONG).show();

        TextView txt=(TextView) activityCha.findViewById(R.id.textView1);
        txt.setText(tong+"");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        arrCuaListview.add(values[0]);
        adapterCuaListview.notifyDataSetChanged();

    }

    @Override
    protected void onCancelled(ArrayList<Integer> integers) {
        super.onCancelled(integers);
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }

    @Override
    protected ArrayList<Integer> doInBackground(Integer... arg0) {
        int so=arg0[0];

        ArrayList<Integer> arrTongCacSoFib=new ArrayList<Integer>();
        for(int i=1;i<=so;i++)
        {
            SystemClock.sleep(150);

            int f=fib(i);

            arrTongCacSoFib.add(f);

            publishProgress(f);
        }

        return arrTongCacSoFib;

    }
}
