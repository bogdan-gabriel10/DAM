package ro.ase.lab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ro.ase.lab.databinding.ActivityAddBookBinding;

public class AddBookActivity extends AppCompatActivity {

    private ActivityAddBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddBookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.buttonSaveBook.setOnClickListener(this::onSaveBook);
    }

    public void onSaveBook(View view) {
        String titlu = binding.tiltu.getText().toString().trim();
        String tip = binding.tipCarte.getSelectedItem().toString();
        String an = binding.anPublicare.getText().toString().trim();

        if (titlu.isEmpty() || an.isEmpty()) {
            Toast.makeText(this, R.string.err_empty_book, Toast.LENGTH_SHORT).show();
            return;
        }

        int year = Integer.parseInt(an);
        if (year < 1 || year > 2026) {
            Toast.makeText(this, R.string.err_year_book, Toast.LENGTH_SHORT).show();
            return;
        }

        Book book = new Book(titlu, tip, year);
        Intent data = new Intent();
        data.putExtra("book", book);

        setResult(RESULT_OK, data);
        finish();
    }
}
