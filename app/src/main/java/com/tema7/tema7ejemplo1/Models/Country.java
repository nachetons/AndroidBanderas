package com.tema7.tema7ejemplo1.Models;
import java.text.MessageFormat;

public class Country {

    private String Name;
    private String CountryCode;


    public Country(String name, String countryCode) {
        Name = name;
        CountryCode = countryCode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }


    public String getFlagURL() {
        return MessageFormat.format("http://www.geognos.com/api/en/countries/flag/"+CountryCode+".png",
                this.getCountryCode());
    }

    // Importante!! Sobreescribimos el mÃ©todo toString de nuestra clase POJO Country
    // Para que cuando el Spinner llame internamente cada objeto, use el name para ser mostrado
    // como Ãºnico valor posible en la lista desplegable
    @Override
    public String toString() {
        return Name;
    }


}
