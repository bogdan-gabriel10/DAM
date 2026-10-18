package ro.ase.lab;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    public FirstFragment() {
        super(R.layout.fragment_first);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText etName = view.findViewById(R.id.etName);
        Button btnSend = view.findViewById(R.id.btnSend);


        //rezolvare
        EditText etA = view.findViewById(R.id.etA);
        EditText etB = view.findViewById(R.id.etB);
        Button btnCalculate = view.findViewById(R.id.btnCalculate);




        btnSend.setOnClickListener(v -> {
            Bundle data = new Bundle();
            data.putString("name", etName.getText().toString().trim());

            getParentFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, SecondFragment.class, data)
                    .addToBackStack(null)
                    .commit();
        });

        btnCalculate.setOnClickListener(v -> {
            String numarA = etA.getText().toString().trim();
            String numarB = etB.getText().toString().trim();
            try {
                Float.parseFloat(numarA);
                Float.parseFloat(numarB);
            } catch (NumberFormatException e) {
                Toast.makeText(requireContext(), R.string.err_numere, Toast.LENGTH_SHORT).show();
                return;
            }

            Bundle data = new Bundle();
            data.putString("etA", numarA);
            data.putString("etB", numarB);
            data.putString("name", etName.getText().toString().trim());

            getParentFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .replace(R.id.fragmentContainer, ThirdFragment.class, data)
                    .addToBackStack(null)
                    .commit();
        });
    }
}