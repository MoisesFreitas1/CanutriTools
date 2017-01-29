package losfreitasapps.com.canutritools;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Moises on 17/12/16.
 */

public class home extends Fragment {
    private TextView imctxt;
    private TextView estpesotxt;
    private TextView pesoidealtxt;
    private TextView estestaturatxt;
    FragmentManager FM;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home,container,false);
        FM = getFragmentManager();
        imctxt = (TextView) view.findViewById(R.id.imctxt);
        imctxt.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        FM.beginTransaction().replace(R.id.content_principal, new Imc()).commit();
                    }
                });
        estpesotxt = (TextView) view.findViewById(R.id.estpesotxt);
        estpesotxt.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        FM.beginTransaction().replace(R.id.content_principal, new EstPeso()).commit();
                    }
                });
        pesoidealtxt = (TextView) view.findViewById(R.id.pesoidealtxt);
        pesoidealtxt.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        FM.beginTransaction().replace(R.id.content_principal, new PesoIdeal()).commit();
                    }
                });
        estestaturatxt = (TextView) view.findViewById(R.id.estestaturatxt);
        estestaturatxt.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick (View v){
                        FM.beginTransaction().replace(R.id.content_principal, new EstEstatura()).commit();
                    }
                });
        return view;
    }
}
