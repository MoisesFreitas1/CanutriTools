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

public class Imc extends Fragment {
    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();
    TextView imc;
    private double peso = 0.0;
    private double estatura = 0.0;
    private double imcx = 0.0;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.imc,container,false);

        imc = (TextView) view.findViewById(R.id.imc);

        imc.setText(numberFormat.format(imcx));
        update();

        EditText peso = (EditText) view.findViewById(R.id.peso);
        peso.addTextChangedListener(pesoWatcher);

        EditText estatura = (EditText) view.findViewById(R.id.estatura);
        estatura.addTextChangedListener(estaturaWatcher);

        return view;
    }

    private void update() {
        double p = peso;
        double h = estatura/100;
        double i;

        i = p/(h*h);
        imc.setText(numberFormat.format(i));
    }

    private TextWatcher pesoWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                peso = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                peso = 0.0;
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
