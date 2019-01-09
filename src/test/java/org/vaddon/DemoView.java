package org.vaddon;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class DemoView extends VerticalLayout {

    private final Grid<Person> grid;
    public DemoView() {

        List<Person> persons = new ArrayList<>();

        for (int i = 0; i<20; i++) {
            persons.add(new Person("name"+i, "surname"+i, "ES"));
        }

        grid = new Grid<>(Person.class);

        grid.setItems(persons);
        expand(grid);
        CustomMediaQuery customMediaQuery1200 = new CustomMediaQuery(this::toggleColumnCountry);
        CustomMediaQuery customMediaQuery800 = new CustomMediaQuery(this::toggleColumnSurname);
        add(new H1("Grid"));
        add(customMediaQuery1200, customMediaQuery800, grid);
        customMediaQuery1200.setQuery("(min-width: 1200px)");
        customMediaQuery800.setQuery("(min-width: 800px)");
    }

    private void toggleColumnCountry(boolean visible){
        grid.getColumnByKey("country").setVisible(visible);
    }

    private void toggleColumnSurname(boolean visible){
        grid.getColumnByKey("surname").setVisible(visible);
    }


    public class Person {

        private String name;
        private String surname;
        private String country;

        public Person(String name, String surname, String country) {
            this.name = name;
            this.surname = surname;
            this.country = country;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", country='" + country + '\'' +
                    '}';
        }
    }
}