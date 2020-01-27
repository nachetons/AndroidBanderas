package com.tema7.tema7ejemplo1.Interfaces;

import com.tema7.tema7ejemplo1.Models.Person;

// Interfaz definida en fichero aparte para la comunicaciÃ³n entre el FormFragment
// y el ListFragment, a travÃ©s del MainAcitivty
public interface OnPersonCreated {
    void createPerson(Person person);
}
