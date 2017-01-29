package losfreitasapps.com.canutritools;

import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by Moises on 17/12/16.
 */

public class EstPeso extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();
    TextView estpeso;
    private double cpx = 0.0;
    private double ajx = 0.0;
    private double cbx = 0.0;
    private double pcsex = 0.0;
    private double epx = 0.0;

    private View view;
    private RadioGroup rg;
    private RadioButton homem;
    private RadioButton mulher;

    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.estpeso,container,false);

        estpeso = (TextView) view.findViewById(R.id.estpeso);

        estpeso.setText(numberFormat.format(epx));
        update();

        rg = (RadioGroup)view.findViewById(R.id.rgopcoes);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                update();
            }
        });
        homem = (RadioButton)view.findViewById(R.id.homem);
        mulher = (RadioButton)view.findViewById(R.id.mulher);


        EditText cp = (EditText) view.findViewById(R.id.cp);
        cp.addTextChangedListener(cpWatcher);

        EditText aj = (EditText) view.findViewById(R.id.aj);
        aj.addTextChangedListener(ajWatcher);

        EditText cb = (EditText) view.findViewById(R.id.cb);
        cb.addTextChangedListener(cbWatcher);

        EditText pcse = (EditText) view.findViewById(R.id.pcse);
        pcse.addTextChangedListener(pcseWatcher);

        return view;
    }

    private void update() {

        rg = (RadioGroup)view.findViewById(R.id.rgopcoes);
        int op = rg.getCheckedRadioButtonId();
        double cpy = cpx;
        double ajy = ajx;
        double cby = cbx;
        double pcsey = pcsex;
        double epy;

        if(op == R.id.homem){
            epy = (0.98*cpy)+(1.16*ajy)+(1.73*cby)+(0.37*pcsey)-81.69;
            estpeso.setText(numberFormat.format(epy) + " kg");
        } else {
            epy = (1.27*cpy)+(0.87*ajy)+(0.98*cby)+(0.4*pcsey)-62.35;
            estpeso.setText(numberFormat.format(epy) + " kg");
        }
    }

    private TextWatcher cpWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                cpx = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                cpx = 0.0;
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

    private TextWatcher ajWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                ajx = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                ajx = 0.0;
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

    private TextWatcher cbWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                cbx = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                cbx = 0.0;
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

    private TextWatcher pcseWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                pcsex = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                pcsex = 0.0;
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
