package pl.sda.springdatazooapp;

import com.google.common.collect.Lists;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class AnimalGenerator {

    List<String> names = Lists.newArrayList("Tofik", "SzwainSztaiger", "Gutek", "Topik", "Topek", "Tomis", "Borys", "Psotka");
    List<String> countries = Lists.newArrayList("Polska", "Niemcy", "Rosja", "Japonia", "Korea", "Słowacja", "Czechy");


    public Animal genrateAnimal() {
        Random r = new Random();
        Animal animal = Animal.builder()
                .species(Species.values()[r.nextInt(Species.values().length)])
                .name(names.get(r.nextInt(names.size())))
                .country(countries.get(r.nextInt(names.size())))
                .weight(r.nextInt(250) + 1)
                .height(r.nextInt(200) + 1)
                .age(r.nextInt(120))
                .legs(r.nextInt(2) + 2)
                .birth(LocalDate.of(r.nextInt(18) + 2000,
                        r.nextInt(11) + 1,
                        r.nextInt(27) + 1))
                .build();
        return animal;
    }


}
