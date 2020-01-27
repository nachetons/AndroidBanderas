package com.tema7.tema7ejemplo1.Utils;

import com.tema7.tema7ejemplo1.Models.Country;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<Country> getCountries() {
        return new ArrayList<Country>() {{
            add(new Country("Espanita", "ES"));
            add(new Country("Argentina", "AR"));
            add(new Country("Bolivia", "BO"));
            add(new Country("Chile", "CL"));
            add(new Country("Colombia", "CO"));
            add(new Country("Ecuador", "EC"));
            add(new Country("Mexico", "MX"));
            add(new Country("Peru", "PE"));
            add(new Country("Uruguay", "UY"));
            add(new Country("Venezuela", "VE"));
        }};
    }
}
