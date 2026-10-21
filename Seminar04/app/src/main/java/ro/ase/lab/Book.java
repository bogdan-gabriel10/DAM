package ro.ase.lab;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class Book implements Serializable {
    private String titlu;
    private String gen;
    private int an;

    public Book(String titlu, String gen, int an) {
        this.titlu = titlu;
        this.gen = gen;
        this.an = an;
    }

    @NonNull
    @Override
    public String toString() {
        return titlu + " · " + gen + ", " + an;
    }
}
