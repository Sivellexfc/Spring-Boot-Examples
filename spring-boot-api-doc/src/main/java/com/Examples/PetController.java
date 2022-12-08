package com.Examples;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/pet")
@Api(value = "Benim Pet API dokumantasyonum")
public class PetController {

    @PostConstruct
    public void init(){
        petList.add(new Pet(1L,"Test Pet",new Date()));
    }

    List<Pet> petList = new ArrayList<>();
    @PostMapping
    @ApiOperation(value = "pet ekleme",notes = "bu methodu dikkali kullan")
    public ResponseEntity<Pet> kaydet(@RequestBody @ApiParam(value = "Hayvan") Pet pet){
        petList.add(pet);
        return ResponseEntity.ok(pet);
    }
    @GetMapping
    @ApiOperation(value = "pet listeleme",notes = "bu method sayfalama yapar")
    public ResponseEntity<List<Pet>> listAll(){
        return ResponseEntity.ok(petList);
    }
}
