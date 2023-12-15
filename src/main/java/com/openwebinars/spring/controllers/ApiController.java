package com.openwebinars.spring.controllers;

import java.util.List;

import com.openwebinars.spring.repositorios.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.openwebinars.spring.entity.Empresa;

@RestController
@RequestMapping("/api/empresas")
public class ApiController {

    @Autowired
    public EmpresaRepository empresaRepository;

    // Crear una nueva empresa
    @PostMapping
    public ResponseEntity<String> crearEmpresa(@RequestBody Empresa empresa) {
        empresaRepository.save(empresa);
        return ResponseEntity.ok("Empresa creada");
    }

    // Obtener la lista de todas las empresas
    @GetMapping
    public ResponseEntity<List<Empresa>> obtenerEmpresas() {
        List<Empresa> lista = empresaRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    // Obtener una empresa por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Empresa> obtenerEmpresaPorId(@PathVariable Long id) {
        return empresaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Actualizar una empresa existente por su ID
    @PutMapping("/{id}")
    public ResponseEntity<String> actualizarEmpresa(@PathVariable Long id, @RequestBody Empresa empresa) {
        if (empresaRepository.existsById(id)) {
            empresa.setId(id);
            empresaRepository.save(empresa);
            return ResponseEntity.ok("Empresa actualizada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una empresa por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarEmpresa(@PathVariable Long id) {
        if (empresaRepository.existsById(id)) {
            empresaRepository.deleteById(id);
            return ResponseEntity.ok("Empresa eliminada");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
