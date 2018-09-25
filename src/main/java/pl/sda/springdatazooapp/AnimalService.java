package pl.sda.springdatazooapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository repository) {
        this.animalRepository = repository;
    }

    public void generateCars(String value) {
        AnimalGenerator gen = new AnimalGenerator();

        for (int i = 0; i < Integer.parseInt(value); i++) {
            animalRepository.save(gen.genrateAnimal());
        }
    }

    public void createAnimal(CreateAnimalRequest request) {
        Animal animal = Animal.builder()
                .species(request.getSpecies())
                .name(request.getName())
                .country(request.getCountry())
                .weight(request.getWeight())
                .height(request.getHeight())
                .age(request.getAge())
                .legs(request.getLegs())
                .birth(request.getBirth())
                .build();
        animalRepository.save(animal);
    }

    public List<Animal> getAllAnimals() {
        return animalRepository.findAll();
    }

    public List<Animal> findAllByAgeAndName(Integer age, String name) {
        return animalRepository.findAllByAgeAndName(age, name);
    }


}
