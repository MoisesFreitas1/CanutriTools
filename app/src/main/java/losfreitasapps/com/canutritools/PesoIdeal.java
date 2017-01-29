package losfreitasapps.com.canutritools;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by Moises on 17/12/16.
 */

public class PesoIdeal extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();
    TextView pesoideal;
    private double peso = 0.0;
    private double estatura = 0.0;
    private double imc = 0.0;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pesoideal,container,false);

        pesoideal = (TextView) view.findViewById(R.id.pesoideal);

        pesoideal.setText(numberFormat.format(peso));
        update();

        EditText imcdj = (EditText) view.findViewById(R.id.imcdj);
        imcdj.addTextChangedListener(imcdjWatcher);

        EditText estatura = (EditText) view.findViewById(R.id.estatura);
        estatura.addTextChangedListener(estaturaWatcher);

        return view;
    }

    private void update() {
        double p;
        double h = estatura/100;
        double i = imc;

        p = i* (h*h);
        pesoideal.setText(numberFormat.format(p) + " kg");
    }

    private TextWatcher imcdjWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                imc = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                imc = 0.0;
            }
            update();
        }

        @Override
        public void afterTextChanged(Editable s)
        {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }
    };

    private TextWatcher estaturaWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                estatura = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                estatura = 0.0;
            }
            update();
        }

        @Override
        public void afterTextChanged(Editable s)
        {
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after)
        {
        }
    };
}
