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

public class EstEstatura extends Fragment {

    private static final NumberFormat numberFormat = NumberFormat.getNumberInstance();
    TextView estestatura;
    private double idx = 0.0;
    private double ajx = 0.0;
    private double eex = 0.0;

    private View view;
    private RadioGroup rg;
    private RadioButton homem;
    private RadioButton mulher;
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.estestatura,container,false);

        estestatura = (TextView) view.findViewById(R.id.estestatura);

        estestatura.setText(numberFormat.format(eex));
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


        EditText idade = (EditText) view.findViewById(R.id.idade);
        idade.addTextChangedListener(idadeWatcher);

        EditText aj = (EditText) view.findViewById(R.id.aj);
        aj.addTextChangedListener(ajWatcher);

        return view;
    }

    private void update() {

        rg = (RadioGroup)view.findViewById(R.id.rgopcoes);
        int op = rg.getCheckedRadioButtonId();
        double idy = idx;
        double ajy = ajx;
        double eey;

        if(op == R.id.homem){
            eey = 64.19 - (0.04*idy)+(2.02*ajy);
            estestatura.setText(numberFormat.format(eey) + " cm");
        } else {
            eey = 84.88 - (0.24*idy)+(1.83*ajy);
            estestatura.setText(numberFormat.format(eey) + " cm");
        }
    }

    private TextWatcher idadeWatcher = new TextWatcher()
    {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count)
        {
            try
            {
                idx = Double.parseDouble(s.toString());
            }
            catch (NumberFormatException e)
            {
                idx = 0.0;
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
}
