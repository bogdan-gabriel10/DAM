package ro.ase.lab;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

public class ThirdFragment extends Fragment {


    public ThirdFragment() {
    super(R.layout.fragment_third);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView tvGreeting = view.findViewById(R.id.tvGreeting);
        Button btnBack = view.findViewById(R.id.btnBack);
        TextView tvSuma = view.findViewById(R.id.tvSuma);
        TextView tvProdus = view.findViewById(R.id.tvProdus);
        String name = requireArguments().getString("name");
        String numarA = requireArguments().getString("etA");
        String numarB = requireArguments().getString("etB");
        float suma=Float.parseFloat(numarA)+Float.parseFloat(numarB);
        float produs = Float.parseFloat(numarA)*Float.parseFloat(numarB);
        tvGreeting.setText(getString(R.string.greeting, name));
        tvSuma.setText(getString(R.string.rezultat_suma, String.valueOf(suma)));
        tvProdus.setText(getString(R.string.rezultat_produs, String.valueOf(produs)));

        btnBack.setOnClickListener(v ->
                getParentFragmentManager().popBackStack());
    }
}