package pl.sda.springdatazooapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnimalController {

    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/createanimal")
    @ResponseStatus(HttpStatus.CREATED)
    public void createOneAnimal(@RequestBody CreateAnimalRequest request) {
        animalService.createAnimal(request);
    }

    @GetMapping("/all")
    public List<Animal> getAnimals() {
        return animalService.getAllAnimals();
    }

    @RequestMapping("/generate/{value}")
    public void generateAnimal (@PathVariable String value){
        animalService.generateCars(value);
    }

    @GetMapping("/find")
    public List<Animal> findAllBy(@RequestParam(required = false) Species species,
                                  @RequestParam(required = false) String name,
                                  @RequestParam(required = false) String country,
                                  @RequestParam(required = false) Integer weight,
                                  @RequestParam(required = false) Integer height,
                                  @RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) Integer legs) {
        if (age != null && name != null) {
            return animalService.findAllByAgeAndName(age, name);
        }
        return animalService.getAllAnimals();
    }

}
