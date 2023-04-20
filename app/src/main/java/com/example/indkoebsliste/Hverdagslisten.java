package com.example.indkoebsliste;

import java.util.ArrayList;

public class Hverdagslisten  {

        private ArrayList<Vare> varer;

    @Override
    public String toString() {
        return "Hverdagslisten{" +
                "varer=" + varer +
                '}';
    }

    public Hverdagslisten() {
            varer = new ArrayList<Vare>();
        }

        public ArrayList<Vare> getVarer() {
            return varer;
        }

        public void addVare(Vare vare) {
            varer.add(vare);
        }
    }

