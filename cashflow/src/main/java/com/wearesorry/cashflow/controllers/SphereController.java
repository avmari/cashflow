package com.wearesorry.cashflow.controllers;

import com.wearesorry.cashflow.entities.Sphere;
import com.wearesorry.cashflow.services.SphereService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/spheres")
@AllArgsConstructor
public class SphereController {

    @Autowired
    private SphereService sphereService;

    @PostMapping("/createSphere")
    public Sphere createSphere(@RequestBody Sphere sphere){
        return this.sphereService.save(sphere);
    }

    @GetMapping("/getAllUserSpheres/{userId}")
    public Iterable<Sphere> getAllUserSpheres(@PathVariable UUID userId){
        return this.sphereService.getAllUserSpheres(userId);
    }
}
